package main.Ejercicio_Integrador2.Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManagerSQL(){
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("Example");
        }
        EntityManager em = emf.createEntityManager();
        return em;
    }


}
