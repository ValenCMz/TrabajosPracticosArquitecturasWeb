package main.Ejercicio_Integrador2.Main;

import main.Ejercicio_Integrador2.Modelo.Carrera;
import main.Ejercicio_Integrador2.Modelo.Ciudad;
import main.Ejercicio_Integrador2.Modelo.Estudiante;
import main.Ejercicio_Integrador2.Repositorio.CarreraRepositorioImpl;
import main.Ejercicio_Integrador2.Repositorio.CiudadRepositorioImpl;
import main.Ejercicio_Integrador2.Repositorio.EstudianteRepositorio;
import main.Ejercicio_Integrador2.Repositorio.EstudianteRepositorioImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[]args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();

        EstudianteRepositorioImpl estudianteRepositorio = new EstudianteRepositorioImpl(em);
        CiudadRepositorioImpl ciudadRepositorio = new CiudadRepositorioImpl(em);
        CarreraRepositorioImpl carreraRepositorio = new CarreraRepositorioImpl(em);


        Ciudad c1 = new Ciudad("Tandil");
        Carrera carrera = new Carrera("Tudai");
        ciudadRepositorio.addCiudad(c1);
        Estudiante estudiante = new Estudiante(1, "Valentin", "Caminos", 22, 'M', 43512842, c1);
        carreraRepositorio.addCarrera(carrera);
        estudianteRepositorio.darDeAltaEstudiante(estudiante);
        estudianteRepositorio.matricularEstudianteACarrera(1,2);



        em.close();
    }
}
