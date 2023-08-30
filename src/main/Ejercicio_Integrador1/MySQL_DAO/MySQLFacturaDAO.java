package main.Ejercicio_Integrador1.MySQL_DAO;

import main.Ejercicio_Integrador1.DAO.FacturaDAO;
import main.Ejercicio_Integrador1.Modelo.Factura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLFacturaDAO implements FacturaDAO {
    private Connection conn;

    public MySQLFacturaDAO(Connection conn) {
        this.conn = conn;
    }



    @Override
    public void insert(Factura d) {

    }

    @Override
    public void update(Factura d) {

    }

    @Override
    public void delete(Factura d) {

    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public void crearTabla() {

        String create =
               " CREATE TABLE IF NOT EXISTS factura(" + "idFactura INT,"+
                "idCLiente int,"+
                "PRIMARY KEY(idFactura),"+
                "FOREIGN KEY (idCliente) REFERENCES cliente(idCliente))";
        try {
            conn.setAutoCommit(false);
            conn.prepareStatement(create).execute();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
