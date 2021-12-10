package codegym.repository;

import codegym.model.Commen;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommenRepositoryImpl implements CommenRepository{
    @Override
    public List<Commen> findAll() {
        Session session = null;
        List<Commen> commentList = new ArrayList<>();
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            commentList = session.createQuery("FROM Commen").getResultList();
        } finally {
            if (session != null)
                session.close();
        }
        return commentList;
    }

}
