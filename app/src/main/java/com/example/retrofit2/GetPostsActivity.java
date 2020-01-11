package com.example.retrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetPostsActivity extends AppCompatActivity {

    private TextView txtView;
    private JsonApi jsonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_posts);
        txtView = findViewById(R.id.txtView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonApi = retrofit.create(JsonApi.class);

        getPosts();
    }

    private void getPosts(){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId","1");

        Call<List<Posts>> call = jsonApi.getPosts(parameters);

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(!response.isSuccessful()){
                    txtView.setText("Code: " + response.code());
                    return;
                }
                List<Posts> posts = response.body();
                for(Posts post: posts){
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";
                    txtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                txtView.setText(t.getMessage());
            }
        });
    }
}
