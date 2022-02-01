package pl.kosmider.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.kosmider.dao.CategoryDao;
import pl.kosmider.entity.Category;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String source) {
        Category category = categoryDao.findCategoryById(Long.parseLong(source));
        return category;
    }
}
