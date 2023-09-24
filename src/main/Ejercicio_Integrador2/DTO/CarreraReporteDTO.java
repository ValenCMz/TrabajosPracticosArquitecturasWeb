package main.Ejercicio_Integrador2.DTO;

import java.time.Year;
import java.util.List;

public class CarreraReporteDTO {

    private String carrera;

    private int anio;

    private long inscriptos;

    private long egresados;

    public CarreraReporteDTO(String carrera, int anio, long inscriptos, long egresados) {
        this.carrera = carrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public CarreraReporteDTO(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "CarreraReporteDTO{" +
                "carrera='" + carrera + '\'' +
                ", anio=" + anio +
                ", inscriptos=" + inscriptos +
                ", egresados=" + egresados +
                '}' + "\n";
    }
}
