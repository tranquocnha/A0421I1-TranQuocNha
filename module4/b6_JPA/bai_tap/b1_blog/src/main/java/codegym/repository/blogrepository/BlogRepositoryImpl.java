package codegym.repository.blogrepository;

import codegym.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        return entityManager
                .createQuery(" select b from Blog b", Blog.class)
                .getResultList();
    }

    @Override
    public Blog findById(Integer id) {
        try {
            return entityManager
                    .createQuery("select b from Blog b where b.id=:id", Blog.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }
    }

    @Override
    public void save(Blog model) {
        if(model.getId() != null){
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Blog blog) {
        entityManager.remove(entityManager.merge(blog));
    }
}