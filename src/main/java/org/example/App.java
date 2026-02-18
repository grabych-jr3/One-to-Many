package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
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

            //4) Добавьте еще один фильм для любого режиссера.
//            Director director3 = session.find(Director.class, 2);
//            Movie movie2 = new Movie("Test Name", 2000, director3);
//            session.persist(movie2);
//            director3.getMovies().add(movie2);

            //5) Создайте нового режиссера и новый фильм и свяжите эти сущности
//            Director director4 = new Director("Test Director", 34);
//            Movie movie3 = new Movie("Test movie 2", 2006, director4);
//
//            session.persist(director4);
//            session.persist(movie3);
//
//            director4.setMovies(Collections.singletonList(movie3));

            //6) Смените режиссера у существующего фильма.
//            Director director5 = session.find(Director.class, 4);
//            Movie movie4 = session.find(Movie.class, 13);
//
//            movie4.getOwner().getMovies().remove(movie4);
//            movie4.setOwner(director5);
//            director5.getMovies().add(movie4);
//

            //7) Удалите фильм у любого режиссера.
//            Director director6 = session.find(Director.class, 6);
//            Movie movieToDelete = director6.getMovies().stream().findFirst().orElse(null);
//            System.out.println(movieToDelete);
//            session.remove(movieToDelete);
//            director6.getMovies().remove(movieToDelete);

            /// Каскадування і рефакторинг
            Director director = new Director("Cascade test", 99);

            director.addMovie(new Movie("Movie 1", 1999));
            director.addMovie(new Movie("Movie 2", 2000));
            director.addMovie(new Movie("Movie 3", 2001));

            session.persist(director);

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }

    }

}
