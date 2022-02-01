package pl.kosmider.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kosmider.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public String saveArticle(Article article) {
        entityManager.persist(article);
        return "article added: " + article.toString();
    }

    public Article findArticleByID(Long id) {
        Article article = entityManager.find(Article.class, id);
        return article;
    }

    public void deleteArticle(Article article) {
        entityManager.find(Article.class, article.getId());
        entityManager.remove(entityManager.contains(article) ? article :
                entityManager.merge(article));
    }

    public void updateArticle(Article article) {
        entityManager.merge(article);
    }

    public List<Article> allArticles() {
        Query query = entityManager.createQuery("SELECT articles FROM Article articles");
        List<Article> resultList = query.getResultList();

        for (Article a : resultList) {
            findArticleWithCategoriesById(a.getId());
        }
        return resultList;
    }

    public List<Article> getLast2Articles() {
        Query query = entityManager.createQuery("SELECT articles from Article articles order by articles.createdOn asc");
        List<Article> resultList = query.setMaxResults(2).getResultList();
        List<Article> articles =  new ArrayList<>();


        for (Article a : resultList
        ) {
            findArticleWithCategoriesById(a.getId());
            Article article = new Article(a.getTitle(), StringUtils.left(a.getContent(),200),a.getCreatedOn());
            articles.add(article);
        }
        return articles;
    }

    public List<Article> findArticleFromOneAuthor(long id){
        Query query = entityManager.createQuery("SELECT a from Article a where a.author.id = " + id);
        List<Article> resultList = query.getResultList();
        return resultList;
    }


//    public Book findBookWithAuthorsById(Long id) {
//        Book book = findById(id);
//        Hibernate.initialize(book.getAuthors());
//        return book;
//    }

    public Article findArticleWithAuthorsById(Long id) {
        Article article = findArticleByID(id);
        Hibernate.initialize(article.getAuthor());
        return article;
    }

    public Article findArticleWithCategoriesById(Long id) {
        Article article = findArticleByID(id);
        Hibernate.initialize(article.getCategories());
        return article;
    }

}
