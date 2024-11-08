package nz.clemwhite.blogsite.repository;
import nz.clemwhite.blogsite.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}