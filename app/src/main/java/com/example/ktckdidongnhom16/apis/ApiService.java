package com.example.ktckdidongnhom16.apis;

//import com.example.ktckdidongnhom16.models.BookmarkDto;
//import com.example.ktckdidongnhom16.models.BookmarkResponse;
//import com.example.ktckdidongnhom16.models.CommentDto;
//import com.example.ktckdidongnhom16.models.ConversationDto;
//import com.example.ktckdidongnhom16.models.CreateCommentRequest;
//import com.example.ktckdidongnhom16.models.LoginDto;
//import com.example.ktckdidongnhom16.models.MessageDto;
//import com.example.ktckdidongnhom16.models.RecipeCategoryDto;
import com.example.ktckdidongnhom16.models.RecipeDto;
//import com.example.ktckdidongnhom16.models.RegisterDto;
//import com.example.ktckdidongnhom16.models.SendMessageRequest;
//import com.example.ktckdidongnhom16.models.UpdateUserDto;
//import com.example.ktckdidongnhom16.models.explore.RecentRecipeDto;
//import com.example.ktckdidongnhom16.models.explore.TrendingRecipeDto;
//import com.example.ktckdidongnhom16.models.search.SearchResultDto;
//import com.example.ktckdidongnhom16.models.user.UserDto;
//import com.example.ktckdidongnhom16.models.userfollow.FollowStatusResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
        @GET("/api/recipes")
        Call<List<RecipeDto>> getRecipes();
}
