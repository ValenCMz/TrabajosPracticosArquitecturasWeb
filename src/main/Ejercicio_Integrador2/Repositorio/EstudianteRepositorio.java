package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.Modelo.Estudiante;

public interface EstudianteRepositorio {

    public void darDeAltaEstudiante(Estudiante e);


    public void matricularEstudianteACarrera(int estudianteId, int carreraId);
}
