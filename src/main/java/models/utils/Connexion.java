package models.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connexion {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Charge explicitement depuis le dossier resources
            Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Affiche l'erreur complète pour debug
            System.err.println("Erreur de création du SessionFactory : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void close() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
