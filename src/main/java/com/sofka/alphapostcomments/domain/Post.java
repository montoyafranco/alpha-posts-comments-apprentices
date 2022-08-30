package com.sofka.alphapostcomments.domain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.domain.events.CommentAdded;
import com.sofka.alphapostcomments.domain.events.PostCreated;
import com.sofka.alphapostcomments.domain.values.*;

import java.util.List;
import java.util.Objects;

public class Post extends AggregateEvent<PostID> {

    protected Title title;
    protected Author author;
    protected List<Comment> comments;

    private Post(PostID postID) {
        super(postID);
        subscribe(new PostChange(this));
    }

    public static Post from(PostID postID, List<DomainEvent> events){
        Post post = new Post(postID);
        events.forEach(post::applyEvent);
        return post;
    }

    public Post(PostID postID, Title title, Author author){
        super(postID);
        appendChange(new PostCreated(title, author));
    }

    public void addComment(CommentID commentID, Author author, Content content){
        Objects.requireNonNull(commentID);
        Objects.requireNonNull(author);
        Objects.requireNonNull(content);
        appendChange(new CommentAdded(commentID, author, content));
    }

    public Title title() {
        return title;
    }

    public Author author() {
        return author;
    }

    public List<Comment> comments() {
        return comments;
    }
}
