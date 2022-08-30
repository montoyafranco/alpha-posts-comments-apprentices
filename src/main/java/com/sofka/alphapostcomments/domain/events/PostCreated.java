package com.sofka.alphapostcomments.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.Title;

public class PostCreated  extends DomainEvent {

    private final Author author;
    private final Title title;


    public PostCreated(Title title, Author author) {
        super("domain.postcreated");
        this.title = title;
        this.author = author;
    }
    //guetters
    public Author getAuthor() {
        return author;
    }

    public Title getTitle() {
        return title;
    }


}
