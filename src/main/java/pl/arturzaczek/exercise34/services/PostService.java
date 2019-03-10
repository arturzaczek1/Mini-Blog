package pl.arturzaczek.exercise34.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arturzaczek.exercise34.entity.Post;
import pl.arturzaczek.exercise34.entity.User;
import pl.arturzaczek.exercise34.form.PostNewForm;
import pl.arturzaczek.exercise34.repository.PostRepository;

import java.time.LocalDateTime;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserContextService userContextService;

    @Autowired
    public PostService(PostRepository postRepository, UserContextService userContextService){
        this.postRepository = postRepository;
        this.userContextService = userContextService;
    }

    public void savePost (PostNewForm postNewForm){
        Post post = new Post();
        post.setTitle(postNewForm.getTitle());
        post.setPostBody(postNewForm.getContent());
        post.setAddedDate(LocalDateTime.now());
        post.setUser(userContextService.getLoggedUser());
        postRepository.save(post);
    }
}
