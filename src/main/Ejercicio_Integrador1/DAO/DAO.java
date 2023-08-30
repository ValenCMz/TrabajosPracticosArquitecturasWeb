package main.Ejercicio_Integrador1.DAO;

import java.util.List;

public interface DAO<T>{
    //	CRUD
    public void insert(T d);
    public void update(T d);
    public void delete(T d);
    public List getAll();
    public void crearTabla();

}
