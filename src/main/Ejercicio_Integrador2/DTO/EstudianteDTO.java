package main.Ejercicio_Integrador2.DTO;

import main.Ejercicio_Integrador2.Modelo.Carrera;
import main.Ejercicio_Integrador2.Modelo.EstudianteCarrera;

import java.util.List;

public class EstudianteDTO {

    private int numeroDeDocumento;

    private String nombreCompleto;

    private int numeroDeLibretaUniversitaria;

    private String genero;

    public EstudianteDTO(int numeroDeDocumento, String nombreCompleto, int numeroDeLibretaUniversitaria, String genero) {
        this.numeroDeDocumento = numeroDeDocumento;
        this.nombreCompleto = nombreCompleto;

        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
        this.genero = genero;
    }


    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "numeroDeDocumento=" + numeroDeDocumento +
                ", nombreCompleto='" + nombreCompleto  + '\'' +
                ", numeroDeLibretaUniversitaria=" + numeroDeLibretaUniversitaria +
                ", genero='" + genero + '\'' +
                '}' + "\n";
    }
}
