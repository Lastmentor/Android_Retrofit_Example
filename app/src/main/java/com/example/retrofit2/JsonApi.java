package com.example.retrofit2;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonApi {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    // GET POSTS OPERATION
    @GET("posts")
    Call<List<Posts>> getPosts();

    @GET("posts")
    Call<List<Posts>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET("posts")
    Call<List<Posts>> getPosts(@QueryMap Map<String, String> parameters);


    // GET COMMENTS OPERATION
    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postId);

    @GET
    Call<List<Comments>> getComments(@Url String url);


    // POSTS OPERATIONS
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") int text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);

    // PUT OPERATIONS
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);


    // PATCH OPERATIONS
    @PATCH("posts/{id}")
    Call<Post> pacthPost(@Path("id") int id, @Body Post post);


    // DELETE OPERATIONS
    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
