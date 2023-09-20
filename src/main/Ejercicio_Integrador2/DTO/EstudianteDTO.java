package main.Ejercicio_Integrador2.DTO;

import main.Ejercicio_Integrador2.Modelo.Carrera;

import java.util.List;

public class EstudianteDTO {

    private int numeroDeLibretaUniversitaria;

    private String nombreCompleto;

    private int edad;

    private List<String> carreras;

    public EstudianteDTO(int numeroDeLibretaUniversitaria, String nombreCompleto, int edad, List<String> carreras) {
        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.carreras = carreras;
    }

    public EstudianteDTO(int numeroDeLibretaUniversitaria, String nombreCompleto, int edad) {
        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }



    public int getNumeroDeLibretaUniversitaria() {
        return numeroDeLibretaUniversitaria;
    }

    public void setNumeroDeLibretaUniversitaria(int numeroDeLibretaUniversitaria) {
        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
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
                "numeroDeLibretaUniversitaria=" + numeroDeLibretaUniversitaria +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", edad=" + edad +
                ", carreras=" + carreras +
                '}';
    }
}
