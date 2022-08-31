package com.sofka.alphapostcomments.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.business.gateways.DomainEventRepository;
import com.sofka.alphapostcomments.domain.Post;
import com.sofka.alphapostcomments.domain.commands.AddComment;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.CommentID;
import com.sofka.alphapostcomments.domain.values.Content;
import com.sofka.alphapostcomments.domain.values.PostID;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
@Component
public class AddCommentUseCase  {

    private final DomainEventRepository domainEventRepository;


    public AddCommentUseCase(DomainEventRepository domainEventRepository) {
        this.domainEventRepository = domainEventRepository;
    }

    public Flux<DomainEvent> applyAddComment(Mono<AddComment> comentario){
        return comentario.flatMapMany(
                comand -> domainEventRepository.findPostById(comand.getPostID())
                        .collectList()
                        //con el flatmap iterable lo convierto en FLUX y me permite trabajarlo
                        .flatMapIterable(events ->{
                            Post post = Post.from(PostID.of(comand.getPostID()),events);

                            post.addComment(CommentID.of(comand.getID()),new Author(comand.getAuthor()),new Content(comand.getContent()));

                            return post.getUncommittedChanges();
                        }).flatMap(event -> domainEventRepository.saveEvent(event))
        );

    }

}
