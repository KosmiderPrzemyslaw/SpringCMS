package pl.kosmider.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kosmider.dao.ArticleDao;
import pl.kosmider.dao.AuthorDao;
import pl.kosmider.dao.CategoryDao;
import pl.kosmider.entity.Article;
import pl.kosmider.entity.Author;
import pl.kosmider.entity.Category;

import java.util.List;

@Controller
@SessionAttributes({"articles", "authors", "categories"})
public class ArticleController {
    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/getAllArticles")
    public String getAllArticles(Model model) {
        List<Article> articles = articleDao.allArticles();
        model.addAttribute("articles", articles);

        return "/daoAllArticles";
    }

    @GetMapping("/addArticle")
    public String addArticle(Model model) {
        Article article = new Article();
        List<Author> allAuthors = authorDao.getAllAuthors();
        model.addAttribute("authors", allAuthors);
        model.addAttribute("article", article);
        return "addArticleForm";
    }

    @PostMapping("/addArticle")
    public String addArticlePost(@ModelAttribute Article article) {

        Author authorById = authorDao.findAuthorById(article.getAuthor().getId());
        article.setAuthor(authorById);
        articleDao.saveArticle(article);

        return "redirect:/getAllArticles";
    }

    @GetMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable long id){
        Article articleByID = articleDao.findArticleByID(id);
        articleDao.deleteArticle(articleByID);
        return "redirect:/getAllArticles";
    }

    @GetMapping("updateArticle/{id}")
    public String updateArticle(@PathVariable long id, Model model){
        Article article = articleDao.findArticleByID(id);
        List<Author> allAuthors = authorDao.getAllAuthors();
        List<Category> categories = categoryDao.getAllcategories();

        model.addAttribute("article", article);
        model.addAttribute("categories", categories);
        model.addAttribute("authors", allAuthors);
        return "/updateArticle";
    }

    @PostMapping("updateArticle/{id}")
    public String updateArticle(@PathVariable long id, @ModelAttribute Article article, @RequestParam List<Category> categories){

        Article articleByID = articleDao.findArticleByID(id);
        articleByID.setAuthor(article.getAuthor());
        articleByID.setContent(article.getContent());
        articleByID.setCategories(categories);
        articleByID.setTitle(article.getTitle());
        articleDao.updateArticle(articleByID);
        return "redirect:/getAllArticles";
    }
}
