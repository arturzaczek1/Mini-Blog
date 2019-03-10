package pl.arturzaczek.exercise34.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arturzaczek.exercise34.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
