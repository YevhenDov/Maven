package com.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class YouTubeVideo {
    private String videoId;
    private List<Comment> commentList = new ArrayList<>();
}

