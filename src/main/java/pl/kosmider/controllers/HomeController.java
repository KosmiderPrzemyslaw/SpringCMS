package pl.kosmider.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kosmider.dao.ArticleDao;
import pl.kosmider.dao.AuthorDao;
import pl.kosmider.dao.CategoryDao;
import pl.kosmider.entity.Article;
import pl.kosmider.entity.Author;
import pl.kosmider.entity.Category;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public HomeController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/add")
    @ResponseBody
    public String add() {
        Author author = new Author("Jan", "Kowalski");
        authorDao.saveAuthor(author);

        Category przyroda = new Category("Przyroda", "opis przyrody");
        categoryDao.addCategory(przyroda);
        Category wojny = new Category("Wojny", "opis wojen");
        categoryDao.addCategory(wojny);
        List<Category> categories = List.of(przyroda, wojny);

        Article article = new Article("Co z tym swiatem", author, categories, "content", LocalDateTime.now(), LocalDateTime.now());
        articleDao.saveArticle(article);
        return "added";
    }

    @GetMapping("/jpql")
    @ResponseBody
    public List<Category> categoryList() {

        StringBuilder stringBuilder = new StringBuilder();
        List<Category> allcategories = categoryDao.getAllcategories();
        return allcategories;
    }

    @GetMapping("/")
    @ResponseBody
    public StringBuilder getLast2Articles() {
        List<Article> last5Articles = articleDao.getLast2Articles();

        StringBuilder stringBuilder = new StringBuilder();
        last5Articles.forEach(article -> stringBuilder.append(article.getContent()).append("\t").append(article.getTitle()).append("\t").append(article.getCreatedOn()).append("\n"));


        return stringBuilder;
    }
}
