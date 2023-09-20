package main.Ejercicio_Integrador2.Modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrera {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private List<EstudianteCarrera> estudiantes;



    public Carrera(String nombre) {
        this.nombre = nombre;
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
}
