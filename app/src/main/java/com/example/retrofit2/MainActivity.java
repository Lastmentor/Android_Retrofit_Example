package com.example.retrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Getbtn = findViewById(R.id.getBtn);
        Button Getbtncomments = findViewById(R.id.getBtnComments);
        Button PostPosts = findViewById(R.id.postBtnPosts);
        Button PutPosts = findViewById(R.id.putPostBtn);
        Button DeletePost = findViewById(R.id.deletePostBtn);

        Getbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetPostsActivity.class);
                startActivity(intent);
            }
        });

        Getbtncomments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetCommentsActivity.class);
                startActivity(intent);
            }
        });

        PostPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostPostsActivity.class);
                startActivity(intent);
            }
        });

        PutPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PutPostActivity.class);
                startActivity(intent);
            }
        });

        DeletePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeletePostActivity.class);
                startActivity(intent);
            }
        });
    }
}
