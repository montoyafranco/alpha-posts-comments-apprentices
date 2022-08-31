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
        //en teoria el flatmapiterable lo hace si el mono tiene List adentro
        //---------si hubiera llamado al repositorio eventsby Id tendria que haber usado FLATmapMany
        // xq -----
        return createPostMono
                //con flatmap no me dio
                //con flatmapmany no me funciono --- pruebo con flatmapiterable
                .flatMapIterable(comando->{
                    //preguntar diferencia entre
                    //FLATMAPITERABLE Y FLATMAPMANY
                    //
            Post post = new Post(PostID.of(comando.getPostID()),new Title(comando.getTitle()),new Author(comando.getAuthor()));
            //aplico el return de uncomited-changes pero no me acuerdo para que era
            return post
                    .getUncommittedChanges();
        }).flatMap(e -> eventRepository.saveEvent(e));
        //ESTA LINEA LA PUEDO BORRAR??  por ahora no se usa... o eso creo
        //le aplico flatmap xq le agrega una indentacion
    }
}
