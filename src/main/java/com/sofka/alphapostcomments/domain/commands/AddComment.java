package com.sofka.alphapostcomments.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.CommentID;
import com.sofka.alphapostcomments.domain.values.Content;
import com.sofka.alphapostcomments.domain.values.PostID;

public class AddComment extends Command {

    private  String postID;
    private  String id;
    private  String author;
    private  String content;



    public AddComment(String postID, String id, String author, String content) {
        this.postID = postID;
        this.id = id;
        this.author = author;
        this.content = content;
    }
    ///getters
    public String getPostID() {
        return postID;
    }
    public String getID() {
        return id;
    }
    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }
}
