package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	
	static {
		try {
            // корень проекта, папка - 'src' - ложим сюда в корень конфигурационный файл 'hibernate.cfg.xml' (по умолчанию, чтобы не делать хитрых путей...)
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//            sessionFactory = new Configuration()
//                    .configure("/hibernate.cfg.xml")
//                    .buildSessionFactory();
	    } catch (Exception e) {
	    	  e.printStackTrace();
	    }
	}

    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
}
