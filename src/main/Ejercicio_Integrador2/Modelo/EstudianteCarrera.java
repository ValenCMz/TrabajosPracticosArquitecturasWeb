package main.Ejercicio_Integrador2.Modelo;

import javax.persistence.*;

@Entity
public class EstudianteCarrera {

    @Id
    @ManyToOne
    @JoinColumn(
            name = "id"
    )
    private Carrera idCarrera;
    @Id
    @ManyToOne
    @JoinColumn(
            name = "numeroDeDocumento"
    )
    private Estudiante idEstudiante;
    @Column
    private int antiguedad;
    @Column
    private boolean esGraduado;

    public EstudianteCarrera(Carrera idCarrera, Estudiante idEstudiante, int antiguedad, boolean esGraduado) {
        this.idCarrera = idCarrera;
        this.idEstudiante = idEstudiante;
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
