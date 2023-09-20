package main.Ejercicio_Integrador2.Modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CarreraEstudianteKey implements Serializable {
    @Column(name = "carrera_id")
    private int carreraId;
    @Column(name = "estudiante_id")
    private int estudianteId;


    public CarreraEstudianteKey(int carreraId, int estudianteId) {
        this.carreraId = carreraId;
        this.estudianteId = estudianteId;
    }

    public CarreraEstudianteKey() {

    }

    public int getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(int carreraId) {
        this.carreraId = carreraId;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }
}
