package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
    private String commentAuthor;
    private String commentText;
    private int likeCount;
    private Date lastEditDate;
    private boolean isEdited;
}
