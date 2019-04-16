package com.mateusz.app.message.request;

import lombok.Data;

@Data
public class CommentRequest {

    private String body;

    public CommentRequest(String body) {
        this.body = body;
    }
}