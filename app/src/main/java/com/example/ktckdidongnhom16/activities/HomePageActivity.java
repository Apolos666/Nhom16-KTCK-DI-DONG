package com.example.ktckdidongnhom16.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktckdidongnhom16.R;
import com.example.ktckdidongnhom16.adapters.PostAdapter;
import com.example.ktckdidongnhom16.apis.ApiService;
import com.example.ktckdidongnhom16.custom.CustomBottomNavigationView;
import com.example.ktckdidongnhom16.models.Post;
import com.example.ktckdidongnhom16.models.RecipeDto;
import com.example.ktckdidongnhom16.utils.RetrofitClient;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageActivity extends AppCompatActivity implements PostAdapter.OnPostClickListener {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> postList;
    private CustomBottomNavigationView bottomNavigationView;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Khởi tạo postList
        postList = new ArrayList<>();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter and set it to the RecyclerView
        postAdapter = new PostAdapter(this, postList, this);
        recyclerView.setAdapter(postAdapter);


        // Initialize navigation
        initializeNavigation();

        ImageView addRecipe = findViewById(R.id.add_recipe);

        EditText searchEditText = findViewById(R.id.search_bar);

        // Khởi tạo Retrofit
        apiService = RetrofitClient.getInstance().getApiService();

        // Gọi API để lấy danh sách công thức
        fetchRecipes();
    }

    private void initializeNavigation() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("HomePageActivity", "Navigation item clicked: " + item.getTitle());

                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    return true;
                } else if (itemId == R.id.navigation_explorer) {
                    return true;
                } else if (itemId == R.id.navigation_profile) {
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
        fetchRecipes();
    }

    private void fetchRecipes() {
        Call<List<RecipeDto>> call = apiService.getRecipes();
        call.enqueue(new Callback<List<RecipeDto>>() {
            @Override
            public void onResponse(Call<List<RecipeDto>> call, Response<List<RecipeDto>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<RecipeDto> recipes = response.body();
                    Log.d("HomePageActivity", "Số lượng công thức nhận được: " + recipes.size());
                    for (RecipeDto recipe : recipes) {
                        Log.d("HomePageActivity", "Công thức: " + recipe.getTitle() +
                                ", Tác giả: " + recipe.getUserName() +
                                ", Số lượt thích: " + recipe.getLikesCount() +
                                ", Số bình luận: " + 5);
                        if (recipe.getMediaUrls() != null && !recipe.getMediaUrls().isEmpty()) {
                            Log.d("HomePageActivity", "Media URL đầu tiên: " + recipe.getMediaUrls().get(0));
                        } else {
                            Log.d("HomePageActivity", "Không có media URL");
                        }
                    }
                    updateRecyclerView(recipes);
                } else {
                    Log.e("HomePageActivity", "Lỗi khi lấy danh sách công thức: " + response.code());
                    Toast.makeText(HomePageActivity.this, "Không thể lấy danh sách công thức", Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<List<RecipeDto>> call, Throwable t) {
                Log.e("HomePageActivity", "Lỗi kết nối: " + t.getMessage(), t);
                Toast.makeText(HomePageActivity.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateRecyclerView(List<RecipeDto> recipes) {
        postList.clear();
        for (RecipeDto recipe : recipes) {
            String mediaUrl = recipe.getMediaUrls() != null && !recipe.getMediaUrls().isEmpty()
                    ? recipe.getMediaUrls().get(0)
                    : null;
            Post post = new Post(recipe.getId().toString(), recipe.getTitle(), recipe.getUserName(),
                    recipe.getLikesCount(),
                    5, mediaUrl);
            postList.add(post);
            Log.d("HomePageActivity", "Đã thêm post: " + post.getRecipeName() +
                    ", Tác giả: " + post.getChefName() +
                    ", Media URL: " + post.getMediaUrl());
        }
        Log.d("HomePageActivity", "Tổng số post sau khi cập nhật: " + postList.size());
        postAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPostClick(String recipeId) {

    }
}
