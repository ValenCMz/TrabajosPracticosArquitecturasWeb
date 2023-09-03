package main.Ejercicio_Integrador1.DAO;


import main.Ejercicio_Integrador1.MySQL_DAO.MySQLManagerDAO;

import java.sql.Connection;

public abstract class DAOFactory {
    private static MySQLManagerDAO connMYSQL = null;

    public abstract ClienteDAO getClienteDAO();
    public abstract FacturaDAO getFacturaDAO();
    public abstract FacturaProductoDAO getFacturaProductoDAO();
    public abstract ProductoDAO getProductoDAO();
    public abstract Connection getConexion();

    public static DAOFactory getDAOManagerMYSQL(){
        if(connMYSQL==null){
            connMYSQL = new MySQLManagerDAO("localhost", "admin", "admin", "basededatosarquitectura");
        }
        return connMYSQL;
    }
}
