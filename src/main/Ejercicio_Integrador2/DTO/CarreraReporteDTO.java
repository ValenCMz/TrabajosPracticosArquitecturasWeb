package main.Ejercicio_Integrador2.DTO;

import java.util.List;

public class CarreraReporteDTO {

    private String carrera;

    private int anio;

    private Long inscriptos;

    private Long egresados;

    public CarreraReporteDTO(String carrera, int anio, Long inscriptos, Long egresados) {
        this.carrera = carrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
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
