package com.parser;

public class ParserApp {
    public static void main(String[] args) {
        CommentParser commentParser = new CommentParser();
        commentParser.init();

        String[] videoIds = {"VLQc6lEZOgA", "5BHLeLuVeXQ"};
        commentParser.getComments(videoIds);
    }
}

