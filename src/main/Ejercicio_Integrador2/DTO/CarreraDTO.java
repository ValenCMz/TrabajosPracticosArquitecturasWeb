package main.Ejercicio_Integrador2.DTO;

import java.util.List;

public class CarreraDTO {

    private int id;

    private String nombre;

    private List<EstudianteDTO> estudiantes;

    public CarreraDTO(int id, String nombre, List<EstudianteDTO> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.estudiantes = estudiantes;
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

    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "CarreraDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estudiantes=" + estudiantes +
                '}';
    }
}
