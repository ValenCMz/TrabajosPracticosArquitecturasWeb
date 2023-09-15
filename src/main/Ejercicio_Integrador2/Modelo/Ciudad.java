package main.Ejercicio_Integrador2.Modelo;

import javax.persistence.*;

@Entity
public class Ciudad {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nombre;

    public Ciudad( String nombre) {
        this.nombre = nombre;
    }

    public Ciudad() {

    }

    public int getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
