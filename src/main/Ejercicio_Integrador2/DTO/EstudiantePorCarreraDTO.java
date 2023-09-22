package main.Ejercicio_Integrador2.DTO;

import main.Ejercicio_Integrador2.Modelo.Carrera;
import main.Ejercicio_Integrador2.Modelo.EstudianteCarrera;

import java.util.List;

public class EstudiantePorCarreraDTO {
    private int numeroDeDocumento;

    private String nombreCompleto;

    private String carrera;

    private String ciudadResidencia;

    public EstudiantePorCarreraDTO(int numeroDeDocumento, String nombreCompleto, String carrera, String ciudadResidencia) {
        this.numeroDeDocumento = numeroDeDocumento;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.ciudadResidencia = ciudadResidencia;
    }

    @Override
    public String toString() {
        return "EstudiantePorCarreraDTO{" +
                "numeroDeDocumento=" + numeroDeDocumento +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", carrera=" + carrera +
                ", ciudadResidencia='" + ciudadResidencia + '\'' +
                '}' + "\n";
    }
}
