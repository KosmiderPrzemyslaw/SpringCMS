package pl.kosmider.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kosmider.entity.Article;
import pl.kosmider.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public String saveAuthor(Author author) {
        entityManager.persist(author);
        return "author: " + author + " added";
    }

    public void deleteAuthor(Author author) {
        Author author1 = entityManager.find(Author.class, author.getId());
        entityManager.remove(entityManager.contains(author1)
                ? author1 : entityManager.merge(author1));
    }

    public void updateAuthor(Author author) {
        entityManager.merge(author);
    }

    public List<Author> getAllAuthors() {
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        List<Author> resultList = query.getResultList();
        return resultList;
    }

    public Author findAuthorById(long id) {
        Author author = entityManager.find(Author.class, id);
        return author;
    }
}
