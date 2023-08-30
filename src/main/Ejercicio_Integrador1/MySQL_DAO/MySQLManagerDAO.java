package main.Ejercicio_Integrador1.MySQL_DAO;


import main.Ejercicio_Integrador1.DAO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManagerDAO extends DAOFactory {

    private Connection conn;
    private ClienteDAO clienteDAO = null;
    private FacturaDAO facturaDAO = null;
    private FacturaProductoDAO facturaProductoDAO = null;
    private ProductoDAO producto = null;

    //Con esto me conecto a la base de datos
    public MySQLManagerDAO(String host, String username, String password, String database) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database,username,password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
    }


    @Override
    public ClienteDAO getClienteDAO() {
        if(this.clienteDAO ==null){
            this.clienteDAO = new MySQLClienteDAO(conn);
        }
        return clienteDAO;
    }

    @Override
    public FacturaDAO getFacturaDAO() {
        if(this.facturaDAO ==null){
            this.facturaDAO = new MySQLFacturaDAO(conn);
        }
        return facturaDAO;
    }

    @Override
    public FacturaProductoDAO getFacturaProductoDAO() {
        if(this.facturaProductoDAO ==null){
            this.facturaProductoDAO = new MySQLFacturaProductoDAO(conn);
        }
        return facturaProductoDAO;
    }

    @Override
    public ProductoDAO getProductoDAO() {
        if(this.producto ==null){
            this.producto = new MySQLProductoDAO(conn);
        }
        return producto;
    }
}