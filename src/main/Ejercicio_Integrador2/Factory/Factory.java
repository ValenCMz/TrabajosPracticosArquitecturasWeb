package main.Ejercicio_Integrador2.Factory;

import main.Ejercicio_Integrador2.Repositorio.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

    private static EntityManagerFactory emf;
    private static CarreraRepositorioImpl carreraRepositorio;
    private static EstudianteRepositorioImpl estudianteRepositorio;
    private static EstudianteCarreraRepositorioImpl estudianteCarreraRepositorio;
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

    public static EstudianteCarreraRepositorioImpl getEstudianteCarreraRepositorio(){
        if (estudianteCarreraRepositorio == null){
            estudianteCarreraRepositorio = new EstudianteCarreraRepositorioImpl(Factory.getEntityManagerSQL());
        }
        return estudianteCarreraRepositorio;
    }
}
