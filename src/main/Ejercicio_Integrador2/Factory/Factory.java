package main.Ejercicio_Integrador2.Factory;

import main.Ejercicio_Integrador2.Repositorio.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

    private static EntityManagerFactory emf;
    private static CarreraRepositorioImpl carreraRepositorio;
    private static EstudianteRepositorioImpl estudianteRepositorio;
    public static EntityManager getEntityManagerSQL(){
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("Example");
        }
        return emf.createEntityManager();
    }
    public static CarreraRepositorioImpl getCarreraRepositorio(){
        if (carreraRepositorio == null){
            carreraRepositorio = new CarreraRepositorioImpl(Factory.getEntityManagerSQL());
        }
        return carreraRepositorio;
    }
    public static EstudianteRepositorioImpl getEstudianteRepositorio(){
        if (estudianteRepositorio == null){
            estudianteRepositorio = new EstudianteRepositorioImpl(Factory.getEntityManagerSQL());
        }
        return estudianteRepositorio;
    }
}
