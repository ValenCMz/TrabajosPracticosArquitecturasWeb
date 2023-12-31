package main.Ejercicio_Integrador2.Main;

import main.Ejercicio_Integrador2.Factory.Factory;
import main.Ejercicio_Integrador2.Modelo.Carrera;
import main.Ejercicio_Integrador2.Modelo.Estudiante;
import main.Ejercicio_Integrador2.Repositorio.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.persistence.EntityManager;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[]args)  {
        EntityManager em = Factory.getEntityManagerSQL();

        EstudianteRepositorioImpl estudianteRepositorio = Factory.getEstudianteRepositorio();
        CarreraRepositorioImpl carreraRepositorio = Factory.getCarreraRepositorio();
        EstudianteCarreraRepositorioImpl estudianteCarreraRepositorio = Factory.getEstudianteCarreraRepositorio();



/*

CODIGO PARA CARGAR DATOS EN LA BASE DE DATOS

       CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/carreras.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parser) {
            carreraRepositorio.addCarrera(new Carrera(row.get("carrera")));
        }

        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/estudiantes.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord row: parser){
            estudianteRepositorio.darDeAltaEstudiante(new Estudiante(Integer.valueOf(row.get("LU")),row.get("nombre"),row.get("apellido"),Integer.valueOf(row.get("edad")),row.get("genero"),Integer.valueOf(row.get("DNI")),row.get("ciudad")));
        }
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/estudianteCarrera.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord row: parser){
            estudianteCarreraRepositorio.addEstudianteCarrera(Integer.valueOf(row.get("id_estudiante")), Integer.valueOf(row.get("id_carrera")), Integer.valueOf(row.get("inscripcion")), Integer.valueOf(row.get("graduacion")),Integer.valueOf(row.get("antiguedad")));
        }

 */

        System.out.println("Ejercicio 2.c)" + "\n" + estudianteRepositorio.getEstudiantesDTOOrdenadosPorApellido());
        System.out.println("Ejercicio 2.d)"+ "\n" +estudianteRepositorio.getEstudianteDTOByNumeroDeLibreta(250020));
        System.out.println("Ejercicio 2.e)"+ "\n" +estudianteRepositorio.getEstudiantesPorGenero("Male"));
        System.out.println("Ejercicio 2.f)"+ "\n" +carreraRepositorio.getCarrerasConInscriptos());
        System.out.println("Ejercicio 2.g)"+ "\n" +estudianteRepositorio.getEstudiantesPorCarreraPorCiudad(1,"Paquera"));
        System.out.println("Ejercicio 3)"+ "\n" +carreraRepositorio.getCarrerasReporte());


        em.close();
    }
}
