package main.Ejercicio_Integrador2.Main;

import main.Ejercicio_Integrador2.Factory.Factory;
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
        EntityManager em = Factory.getEntityManagerSQL();

        EstudianteRepositorioImpl estudianteRepositorio = new EstudianteRepositorioImpl(em);
        CiudadRepositorioImpl ciudadRepositorio = new CiudadRepositorioImpl(em);
        CarreraRepositorioImpl carreraRepositorio = new CarreraRepositorioImpl(em);

/*
        Ciudad c1 = new Ciudad("Tandil");
        Carrera carrera = new Carrera("Tudai");
        Carrera carrera1 = new Carrera("sin estudiantes");
        ciudadRepositorio.addCiudad(c1);
        Estudiante estudiante = new Estudiante(1, "Valentin", "Caminos", 22, 'M', 43512842, c1);
        Estudiante estudiante1 = new Estudiante(2,"jose","asas",33, 'F',2133213,c1);
        carreraRepositorio.addCarrera(carrera);
        carreraRepositorio.addCarrera(carrera1);
        estudianteRepositorio.darDeAltaEstudiante(estudiante1);
        estudianteRepositorio.darDeAltaEstudiante(estudiante);
        estudianteRepositorio.matricularEstudianteACarrera(1,1);

 */



   /*
        System.out.println(estudianteRepositorio.getEstudiantesDTOOrdenados());
        System.out.println(estudianteRepositorio.getEstudianteDTOByNumeroDeLibreta(1));
        System.out.println(estudianteRepositorio.getEstudiantesPorGenero('M'));

    */

        //    System.out.println(carreraRepositorio.getCarrerasConEstudiantesOrdenadosPorCantidadDeInscriptos());

        System.out.println(estudianteRepositorio.getEstudiantesPorCarreraPorCiudad(1,"asdas"));


        em.close();
    }
}
