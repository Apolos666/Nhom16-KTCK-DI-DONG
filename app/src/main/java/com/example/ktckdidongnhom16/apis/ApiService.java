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
//        @POST("api/auth/register")
//        Call<String> register(@Body RegisterDto registerDto);
//
//        @POST("api/auth/login")
//        Call<String> login(@Body LoginDto loginDto);
//
//        @GET("api/auth/user")
//        Call<UserDto> getUser(@Header("Authorization") String token);
//
//        @GET("api/recipe-categories")
//        Call<List<RecipeCategoryDto>> getRecipeCategories();

        @Multipart
        @POST("api/recipes")
        Call<Void> createRecipe(
                        @Header("Authorization") String token,
                        @Part("Title") RequestBody title,
                        @Part("Ingredients") RequestBody ingredients,
                        @Part("Instructions") RequestBody instructions,
                        @Part("RecipeCategoryId") RequestBody recipeCategoryId,
                        @Part List<MultipartBody.Part> mediaFiles);

        @GET("api/recipes")
        Call<List<RecipeDto>> getRecipes();

        @GET("api/recipes/{id}")
        Call<RecipeDto> getRecipe(@Path("id") String recipeId, @Header("Authorization") String token);

//        @POST("api/comments")
//        Call<CommentDto> createComment(@Header("Authorization") String token, @Body CreateCommentRequest request);
//
//        @GET("api/users/{id}")
//        Call<UserDto> getUserById(@Path("id") String userId, @Header("Authorization") String token);
//
//        @PUT("api/users/{id}")
//        Call<Void> updateUser(@Path("id") String userId, @Header("Authorization") String token,
//                        @Body UpdateUserDto updateUserDto);
//
//        @POST("api/chat/start")
//        Call<String> startConversation(@Header("Authorization") String token, @Query("recipientId") String recipientId);
//
//        @POST("api/chat/send")
//        Call<Void> sendMessage(@Header("Authorization") String token, @Body SendMessageRequest request);
//
//        @GET("api/chat/conversations")
//        Call<List<ConversationDto>> getConversations(@Header("Authorization") String token);
//
//        @GET("api/chat/messages/{conversationId}")
//        Call<List<MessageDto>> getMessages(@Header("Authorization") String token,
//                        @Path("conversationId") String conversationId);
//
//        @POST("api/users-follow/{id}/follow")
//        Call<Void> followUser(@Path("id") String userId, @Header("Authorization") String token);
//
//        @DELETE("api/users-follow/{id}/unfollow")
//        Call<Void> unfollowUser(@Path("id") String userId, @Header("Authorization") String token);
//
//        @GET("api/users-follow/{id}/follow-status")
//        Call<FollowStatusResponse> getFollowStatus(@Path("id") String userId, @Header("Authorization") String token);
//
//        @GET("api/search")
//        Call<SearchResultDto> search(@Header("Authorization") String token, @Query("q") String searchTerm);
//
//        @GET("api/bookmarks/check/{recipeId}")
//        Call<BookmarkResponse> getBookmarkStatus(@Header("Authorization") String token, @Path("recipeId") String recipeId);
//
//        @POST("api/bookmarks/{recipeId}")
//        Call<Void> addBookmark(@Header("Authorization") String token, @Path("recipeId") String recipeId);
//
//        @DELETE("api/bookmarks/{recipeId}")
//        Call<Void> removeBookmark(@Header("Authorization") String token, @Path("recipeId") String recipeId);
//
//        @GET("api/bookmarks")
//        Call<List<BookmarkDto>> getBookmarks(@Header("Authorization") String token);
//
//        @POST("api/recipes/{id}/like")
//        Call<Void> likeRecipe(@Path("id") String recipeId, @Header("Authorization") String token);
//
//        @DELETE("api/recipes/{id}/unlike")
//        Call<Void> unlikeRecipe(@Path("id") String recipeId, @Header("Authorization") String token);
//
//        @GET("api/recipes/trending")
//        Call<List<TrendingRecipeDto>> getTrendingRecipes(@Query("limit") int limit);
//
//        @GET("api/recipes/recent")
//        Call<List<RecentRecipeDto>> getRecentRecipes(@Query("limit") int limit);
}
