package com.sofka.alphapostcomments.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.CommentID;
import com.sofka.alphapostcomments.domain.values.Content;

public class CommentAdded extends DomainEvent {

    private  String id;
    private  String author;
    private  String content;

    public CommentAdded(String id, String author, String content) {
        super("domain.commentadded");
        this.id = id;
        this.author = author;
        this.content = content;
    }
    public CommentAdded(){
        super("domain.commentadded");
    }
//guetters
    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
