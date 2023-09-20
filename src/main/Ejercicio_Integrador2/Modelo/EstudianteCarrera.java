package main.Ejercicio_Integrador2.Modelo;

import javax.persistence.*;

@Entity
public class EstudianteCarrera {

    @EmbeddedId
    private CarreraEstudianteKey id;

    @ManyToOne
    @MapsId("carreraId")
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToOne
    @MapsId("estudianteId")
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    @Column
    private int antiguedad;
    @Column
    private boolean esGraduado;

    public EstudianteCarrera(Carrera idCarrera, Estudiante idEstudiante, int antiguedad, boolean esGraduado) {
        this.carrera = idCarrera;
        this.estudiante = idEstudiante;
        this.antiguedad = antiguedad;
        this.esGraduado = esGraduado;
    }

    public EstudianteCarrera() {

    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isEsGraduado() {
        return esGraduado;
    }

    public void setEsGraduado(boolean esGraduado) {
        this.esGraduado = esGraduado;
    }
}
