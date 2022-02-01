package pl.kosmider.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kosmider.dao.ArticleDao;
import pl.kosmider.dao.AuthorDao;
import pl.kosmider.entity.Article;
import pl.kosmider.entity.Author;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;
    private final ArticleDao articleDao;
    private final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    public AuthorController(AuthorDao authorDao, ArticleDao articleDao) {
        this.authorDao = authorDao;
        this.articleDao = articleDao;
    }

    @RequestMapping("/allAuthors")
    public String authorList(Model model) {
        List<Author> allAuthors = authorDao.getAllAuthors();
        model.addAttribute("authors", allAuthors);
        allAuthors.forEach(author -> logger.info(author.toString()));
        return "daoAllAuthors";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "addAuthorForm";
    }

    @PostMapping("/addAuthor")
    public String addAuthorPost(@ModelAttribute Author author) {
        authorDao.saveAuthor(author);
        return "redirect:/allAuthors";
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable long id) {
        Author authorById = authorDao.findAuthorById(id);
        List<Article> articlesFromOneAuthor = articleDao.findArticleFromOneAuthor(authorById.getId());

        for (Article a : articlesFromOneAuthor
        ) {
            articleDao.deleteArticle(a);
        }
        authorDao.deleteAuthor(authorById);

        return "redirect:/allAuthors";
    }

    @GetMapping("/updateAuthor/{id}")
    public String updateAuthor(@PathVariable long id, Model model) {
        Author authorById = authorDao.findAuthorById(id);
        model.addAttribute("authorToUpdate", authorById);

        return "updateAuthorForm";
    }

    @PostMapping("/updateAuthor/{id}")
    public String updateAuthorPost(@PathVariable long id, @RequestBody @ModelAttribute Author authorToUpdate){
        Author authorById = authorDao.findAuthorById(id);
        authorById.setFirstName(authorToUpdate.getFirstName());
        authorById.setLastName(authorToUpdate.getLastName());
        authorDao.updateAuthor(authorById);
        return "redirect:/allAuthors";
    }
}
