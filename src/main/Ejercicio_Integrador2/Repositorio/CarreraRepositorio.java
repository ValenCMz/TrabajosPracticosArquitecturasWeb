package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.DTO.CarreraDTO;
import main.Ejercicio_Integrador2.Modelo.Carrera;

import java.util.List;

public interface CarreraRepositorio {
    public void addCarrera(Carrera c);

    public List<CarreraDTO>getCarrerasConEstudiantesOrdenadosPorCantidadDeInscriptos();
}
