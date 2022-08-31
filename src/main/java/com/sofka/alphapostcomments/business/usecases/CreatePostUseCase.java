package com.sofka.alphapostcomments.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.business.gateways.DomainEventRepository;
import com.sofka.alphapostcomments.domain.Post;
import com.sofka.alphapostcomments.domain.commands.CreatePost;
import com.sofka.alphapostcomments.domain.values.Author;
import com.sofka.alphapostcomments.domain.values.PostID;
import com.sofka.alphapostcomments.domain.values.Title;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CreatePostUseCase  {
    private final DomainEventRepository eventRepository;

    public CreatePostUseCase(DomainEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public Flux<DomainEvent> apply(Mono<CreatePost> createPostMono){
        //COMO TENGO QUE DEVOLVER UN FLUX de un MONO USO flatMapIterable
        // transformandolo y permitiendo poder trabajarlo
        return createPostMono.flatMapIterable(comando->{
            Post post = new Post(PostID.of(comando.getPostID()),new Title(comando.getTitle())
                    ,new Author(comando.getAuthor()));
            return post.getUncommittedChanges();
        });
    }
}
