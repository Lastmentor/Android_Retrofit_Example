package com.example.retrofit2;

import com.google.gson.annotations.SerializedName;

public class Posts {
    private int userId;

    private Integer id;

    private String title;

    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
