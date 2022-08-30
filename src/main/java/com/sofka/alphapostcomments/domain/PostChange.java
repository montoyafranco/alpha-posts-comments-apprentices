package com.sofka.alphapostcomments.domain;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.alphapostcomments.domain.events.CommentAdded;
import com.sofka.alphapostcomments.domain.events.PostCreated;

import java.util.ArrayList;
import java.util.List;

public class PostChange  extends EventChange {

    public PostChange (Post post){

        apply((PostCreated event) -> {
            post.author = event.getAuthor();
            post.title = event.getTitle();
            post.comments = new ArrayList<>();

        });

        apply((CommentAdded event) -> {
            List<Comment> comments = post.comments;
            comments.add(new Comment(event.getId(), event.getAuthor(), event.getContent()));
        });


    }

}
