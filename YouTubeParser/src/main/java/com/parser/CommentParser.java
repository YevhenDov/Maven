package com.parser;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.youtube.YouTube;
import com.google.common.collect.Lists;

import java.util.List;

public class CommentParser {
    private YouTube youTube;
    private static List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.force-ssl");

    public void init(){
        Credential credential = null;
        try {
            credential = Auth.authorize(scopes, "CommentThreads");
        } catch (Exception e) {
            e.printStackTrace();
        }
        youTube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                .setApplicationName("youtube-comments-parser").build();
    }


}
