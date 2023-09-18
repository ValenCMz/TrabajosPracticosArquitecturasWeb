package main.Ejercicio_Integrador2.Modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "carrera_estudiante",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "numeroDeLibretaUniversitaria")
    )
    private List<Estudiante>estudiantes;

    public Carrera(String nombre) {

        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public Carrera() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
