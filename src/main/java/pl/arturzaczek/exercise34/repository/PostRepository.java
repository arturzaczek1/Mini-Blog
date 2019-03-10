package pl.arturzaczek.exercise34.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturzaczek.exercise34.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
