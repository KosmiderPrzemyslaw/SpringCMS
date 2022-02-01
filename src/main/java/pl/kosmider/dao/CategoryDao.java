package pl.kosmider.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kosmider.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public String addCategory(Category category) {
        entityManager.persist(category);

        return "category added: " + category;
    }

    public void deleteCategory(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public List<Category> getAllcategories() {
        Query query = entityManager.createQuery("SELECT c from Category c");
        List<Category> categories = query.getResultList();
        return categories;
    }

    public Category findCategoryById(Long id) {
        return entityManager.find(Category.class, id);
    }
}
