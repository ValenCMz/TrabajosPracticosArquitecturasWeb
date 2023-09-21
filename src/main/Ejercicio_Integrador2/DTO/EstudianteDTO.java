package main.Ejercicio_Integrador2.DTO;

import main.Ejercicio_Integrador2.Modelo.Carrera;
import main.Ejercicio_Integrador2.Modelo.EstudianteCarrera;

import java.util.List;

public class EstudianteDTO {

    private int dni;

    private String nombreCompleto;

    private int edad;

    private List<String> carreras;

    public EstudianteDTO(int dni, String nombreCompleto, int edad, List<String> carreras) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.carreras = carreras;
    }

    public EstudianteDTO(int dni, String nombreCompleto, int edad) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }



    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<String> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "numeroDeLibretaUniversitaria=" + dni +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", edad=" + edad +
                ", carreras=" + carreras +
                '}';
    }
}
