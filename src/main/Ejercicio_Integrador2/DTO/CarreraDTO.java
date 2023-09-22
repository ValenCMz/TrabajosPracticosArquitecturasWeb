package main.Ejercicio_Integrador2.DTO;

import java.util.List;

public class CarreraDTO {

    private int id;

    private String nombre;

    private Long cantidadDeInscriptos;

    public CarreraDTO(int id, String nombre, Long cantidadDeInscriptos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDeInscriptos = cantidadDeInscriptos;
    }


    @Override
    public String toString() {
        return "CarreraDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeInscriptos=" + cantidadDeInscriptos +
                '}' + "\n";
    }
}
