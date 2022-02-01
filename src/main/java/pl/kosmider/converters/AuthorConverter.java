package pl.kosmider.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.kosmider.dao.AuthorDao;
import pl.kosmider.entity.Author;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;


    @Override
    public Author convert(String source) {
        Author author = authorDao.findAuthorById(Long.parseLong(source));
        return author;
    }
}
