package com.mateusz.app.message.request;

import lombok.Data;

@Data
public class PostRequest {

    private String title;

    private String content;

    public PostRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
