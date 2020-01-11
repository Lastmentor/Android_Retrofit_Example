package com.example.retrofit2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PutPostActivity extends AppCompatActivity {

    private TextView txtView;
    private JsonApi jsonApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txtView = findViewById(R.id.txtView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonApi = retrofit.create(JsonApi.class);

        updatePost();
    }

    private void updatePost(){
        Post post = new Post(25, null, "New Title");

        Call<Post> call = jsonApi.putPost(101, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    txtView.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";
                txtView.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txtView.setText(t.getMessage());
            }
        });
    }
}
