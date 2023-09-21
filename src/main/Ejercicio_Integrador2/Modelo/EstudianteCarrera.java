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
    private int inscripcion;
    @Column
    private int graduacion;

    public EstudianteCarrera(Carrera idCarrera,Estudiante idEstudiante,CarreraEstudianteKey eck,int antiguedad,int inscripcion,int graduacion){
        this.carrera = idCarrera;
        this.estudiante = idEstudiante;
        this.id = eck;
        this.antiguedad = antiguedad;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
    }

    public EstudianteCarrera() {

    }

    public CarreraEstudianteKey getId() {
        return id;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
