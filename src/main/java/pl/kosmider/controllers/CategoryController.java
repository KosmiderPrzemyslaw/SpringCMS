package pl.kosmider.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kosmider.dao.CategoryDao;
import pl.kosmider.entity.Category;

import java.util.Arrays;
import java.util.List;

@Controller
public class CategoryController {
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/allCategories")
    public String categoryList(Model model) {
        List<Category> daoAllCategories = categoryDao.getAllcategories();
        model.addAttribute("daoAllCategories", daoAllCategories);
        return "daoAllCategories";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategoryForm";
    }

    @PostMapping("/addCategory")
        public String addC(@ModelAttribute Category category) {

        categoryDao.addCategory(category);
        return "redirect:/allCategories";

    }

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[]{"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }

    @GetMapping("/languages")
    public String lang() {
        return "languages";
    }

    @GetMapping("/deleteCategory/{id}")
    public String delete(@PathVariable long id) {
        Category categoryById = categoryDao.findCategoryById(id);
        categoryDao.deleteCategory(categoryById);
        return "redirect:/allCategories";
    }

    @Transactional
    @GetMapping("/updateCategory/{id}")
    public String update(@PathVariable long id, Model model) {

        Category categoryById = categoryDao.findCategoryById(id);
        model.addAttribute("categoryById", categoryById);

        return "/updateCategoryForm";
    }

    @PostMapping("/updateCategory/{id}")
    public String updatePost(@PathVariable long id, @RequestBody @ModelAttribute Category categoryById) {
        Category categoryToUpdate = categoryDao.findCategoryById(id);

        categoryToUpdate.setDescription(categoryById.getDescription());
        categoryToUpdate.setName(categoryById.getName());
        categoryDao.update(categoryToUpdate);
        return "redirect:/allCategories";
    }

}
