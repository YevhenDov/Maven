package com.parser;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentSnippet;
import com.google.api.services.youtube.model.CommentThread;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import com.google.common.collect.Lists;
import com.model.Comment;
import com.model.YouTubeVideo;

import java.util.ArrayList;
import java.util.List;

public class CommentParser {
    private YouTube youTube;
    private static List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.force-ssl");
    private YouTubeVideo youTubeVideo = new YouTubeVideo();

    public void init() {
        Credential credential = null;
        try {
            credential = Auth.authorize(scopes, "CommentThreads");
        } catch (Exception e) {
            e.printStackTrace();
        }
        youTube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                .setApplicationName("youtube-comments-parser").build();
    }

    public void getComments(String... videoIds) {

        for (String videoId : videoIds) {
            try {
                List<Comment> commentList = new ArrayList<>();

                CommentThreadListResponse videoCommentsListResponse = youTube.commentThreads()
                        .list("snippet").setVideoId(videoId).setTextFormat("plainText").execute();

                List<CommentThread> videoComments = videoCommentsListResponse.getItems();

                for (CommentThread videoComment : videoComments) {
                    CommentSnippet snippet = videoComment.getSnippet().getTopLevelComment().getSnippet();
                    Comment comment = new Comment();

                    comment.setCommentAuthor(snippet.getAuthorDisplayName());
                    comment.setCommentText(snippet.getTextDisplay());
                    comment.setLikeCount(snippet.getLikeCount());
                    comment.setLastEditDate(snippet.getUpdatedAt());
                    comment.setEdited((!(snippet.getUpdatedAt().equals(snippet.getPublishedAt()))));

                    commentList.add(comment);
                }
                youTubeVideo.setCommentList(commentList);
                youTubeVideo.setVideoId(videoId);

                System.out.println(youTubeVideo.getVideoId());
                System.out.println(youTubeVideo.getCommentList());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

