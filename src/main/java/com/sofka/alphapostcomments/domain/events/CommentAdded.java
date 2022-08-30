package com.sofka.alphapostcomments.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.CommentID;
import com.sofka.alphapostcomments.domain.values.Content;

public class CommentAdded extends DomainEvent {

    private final CommentID id;
    private final Author author;
    private final Content content;

    public CommentAdded(CommentID id, Author author, Content content) {
        super("domain.commentadded");
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public CommentID getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public Content getContent() {
        return content;
    }
}
