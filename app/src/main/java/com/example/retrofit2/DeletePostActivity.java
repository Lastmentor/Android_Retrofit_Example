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

public class DeletePostActivity extends AppCompatActivity {

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

        deletePost();
    }

    private void deletePost() {
        Call<Void> call = jsonApi.deletePost(5);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                txtView.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                txtView.setText(t.getMessage());
            }
        });
    }
}
