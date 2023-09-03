package main.Ejercicio_Integrador1.Helper;

import java.sql.Connection;
import java.sql.SQLException;

public class CreadorHelper {

    private Connection conn;

    public CreadorHelper(Connection conn) {
        this.conn = conn;
    }
    public void crearTabla() {
        String crearCliente = "CREATE TABLE IF NOT EXISTS cliente("+ "idCliente INT,"
                + "nombre VARCHAR(500),"+ "email VARCHAR(150)," +
                "PRIMARY KEY(idCliente))";

        String crearProducto = "CREATE TABLE IF NOT EXISTS producto("+ "idProducto INT,"
                + "nombre VARCHAR(45),"+ "valor float," +
                "PRIMARY KEY(idProducto))";

        String crearFactura =
                " CREATE TABLE IF NOT EXISTS factura(" + "idFactura INT,"+
                        "idCLiente int,"+
                        "PRIMARY KEY(idFactura),"+
                        "FOREIGN KEY (idCliente) REFERENCES cliente(idCliente))";

        String crearFacturaProducto = "CREATE TABLE IF NOT EXISTS factura_producto("+ "idFactura INT,"
                + "idProducto int,"+ "cantidad int," +
                "PRIMARY KEY(idFactura,idProducto),"+
                "FOREIGN KEY(idFactura) REFERENCES factura(idFactura),"+
                "FOREIGN KEY(idProducto)REFERENCES producto(idProducto))";

        try {
            conn.setAutoCommit(false);
            conn.prepareStatement(crearCliente).execute();
            conn.prepareStatement(crearProducto).execute();
            conn.prepareStatement(crearFactura).execute();
            conn.prepareStatement(crearFacturaProducto).execute();

            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
