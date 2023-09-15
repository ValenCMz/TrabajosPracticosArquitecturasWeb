package main.Ejercicio_Integrador2.Modelo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    private int numeroDeLibretaUniversitaria;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column
    private char genero;

    @Column
    private int numeroDeDocumento;

    @ManyToOne
    private Ciudad ciudadDeResidencia;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Carrera>carreras;


    public Estudiante(int numeroDeLibretaUniversitaria, String nombre, String apellido, int edad, char genero, int numeroDeDocumento, Ciudad ciudadDeResidencia) {
        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.numeroDeDocumento = numeroDeDocumento;
        this.ciudadDeResidencia = ciudadDeResidencia;
        this.carreras = new ArrayList<>();
    }

    public Estudiante() {

    }

    public int getNumeroDeLibretaUniversitaria() {
        return numeroDeLibretaUniversitaria;
    }

    public void setNumeroDeLibretaUniversitaria(int numeroDeLibretaUniversitaria) {
        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(int numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public Ciudad getCiudadDeResidencia() {
        return ciudadDeResidencia;
    }

    public void setCiudadDeResidencia(Ciudad ciudadDeResidencia) {
        this.ciudadDeResidencia = ciudadDeResidencia;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
}
