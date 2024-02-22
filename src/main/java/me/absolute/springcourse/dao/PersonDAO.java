package me.absolute.springcourse.dao;

import me.absolute.springcourse.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person> index() {
        System.out.println("Транзакция открыта");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Person> people = session.createQuery("FROM Person", Person.class)
                .getResultList();
        System.out.println("Список отсканен");
        people.forEach(x -> System.out.println(x));
        session.close();

        return people;
    }

    public Person show(int id) {
        return null;
    }
    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.close();
    }

    public void update(int id, Person updatedPerson) {

    }

    public void delete(int id) {

    }
}

