package com.model;

import com.google.api.client.util.DateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private String commentAuthor;
    private String commentText;
    private long likeCount;
    private DateTime lastEditDate;
    private boolean isEdited;

    @Override
    public String toString() {
        return "\n Author name: " + commentAuthor +
                "\n Text: " + commentText +
                "\n Like count: " + likeCount +
                "\n Last update: " + lastEditDate +
                "\n Edited status: " + isEdited + "\n";
    }
}

