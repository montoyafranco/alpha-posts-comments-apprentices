package com.sofka.alphapostcomments.domain;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.alphapostcomments.domain.events.CommentAdded;
import com.sofka.alphapostcomments.domain.events.PostCreated;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.CommentID;
import com.sofka.alphapostcomments.domain.values.Content;
import com.sofka.alphapostcomments.domain.values.Title;

import java.util.ArrayList;
import java.util.List;

public class PostChange  extends EventChange {

    public PostChange (Post post){

        apply((PostCreated event) -> {
            post.author = new Author(event.getAuthor());
            post.title = new Title(event.getTitle());
            post.comments = new ArrayList<>();

        });

        apply((CommentAdded event) -> {
            post.comments.add(
                    new Comment(
                            new CommentID(event.getId()),
                            new Author(event.getAuthor()),new Content(event.getContent())));


        });


    }

}
