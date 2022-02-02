package lesson_24.util;

import lesson_24.entity.Depart;
import lesson_24.entity.UserCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CardUserFill {

    private SessionFactory sessionFactory;

      public CardUserFill() {
        sessionFactory = ConnectDb.getSessionFactory();
    }

    public void addUsersCards(List<UserCard> userCards, List<Depart> departList) {
          Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        for (UserCard useCard : userCards) {
            session.save(useCard);
        }
        transaction.commit();
        session.close();
    }
    public void addDeparts(List<Depart> departs) {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        for (Depart depart : departs) {
            session.save(depart);
        }
        transaction.commit();
        session.close();
    }

    public List<UserCard> getAllUserCards() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserCard> criteriaQuery = criteriaBuilder.createQuery(UserCard.class);
        Root<UserCard> root = criteriaQuery.from(UserCard.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<UserCard> userCardList = query.getResultList();
        session.close();
        return userCardList;
    }

}
