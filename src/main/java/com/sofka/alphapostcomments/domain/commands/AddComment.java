package com.sofka.alphapostcomments.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.CommentID;
import com.sofka.alphapostcomments.domain.values.Content;
import com.sofka.alphapostcomments.domain.values.PostID;

public class AddComment extends Command {

    private final PostID postID;
    private final CommentID id;
    private final Author author;
    private final Content content;

    public AddComment(PostID postID, CommentID id, Author author, Content content) {
        this.postID = postID;
        this.id = id;
        this.author = author;
        this.content = content;
    }
    ///getters
    public PostID getPostID() {
        return postID;
    }
    public CommentID getID() {
        return id;
    }
    public Author getAuthor() {
        return author;
    }
    public Content getContent() {
        return content;
    }
}
