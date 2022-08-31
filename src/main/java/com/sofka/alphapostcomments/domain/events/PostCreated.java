package com.sofka.alphapostcomments.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.Title;

public class PostCreated  extends DomainEvent {

    private  String author;
    private  String title;



    public PostCreated(String title, String author) {
        super("domain.postcreated");
        this.title = title;
        this.author = author;
    }
    public PostCreated(){
        super("domain.postcreated");
    }
    //guetters
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }


}
