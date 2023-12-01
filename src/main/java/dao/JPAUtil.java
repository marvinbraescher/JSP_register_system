package dao;


import javax.persistence.*;

public class JPAUtil {
    private static EntityManagerFactory emf;
    public static EntityManager getEntityManager() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("test");
        return emf.createEntityManager();
    }
    public static void close(){
        emf.close();
    }
}

