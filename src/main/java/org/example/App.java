package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClasses(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //2) С помощью Hibernate получите любого режиссера, а затем получите список его фильмов
//            Director director1 = session.find(Director.class, 2);
//            List<Movie> movies1 = director1.getMovies();
//            System.out.println(director1);
//            System.out.println(movies1);

            //3) Получите любой фильм, а затем получите его режиссера
//            Movie movie1 = session.find(Movie.class, 1);
//            Director director2 = movie1.getOwner();
//            System.out.println(movie1);
//            System.out.println(director2);



            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }

    }

}
