package main.Ejercicio_Integrador1.MySQL_DAO;

import main.Ejercicio_Integrador1.DAO.FacturaDAO;
import main.Ejercicio_Integrador1.Modelo.Cliente;
import main.Ejercicio_Integrador1.Modelo.Factura;
import main.Ejercicio_Integrador1.Modelo.Producto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLFacturaDAO implements FacturaDAO {
    private Connection conn;

    public MySQLFacturaDAO(Connection conn) {
        this.conn = conn;
    }



    @Override
    public void insert(Factura d) {
        String sentence = "INSERT INTO factura (idFactura,idCliente) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sentence);
            ps.setInt(1,d.getIdFactura());
            ps.setInt(2,d.getIdCliente());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public void generarDatos(String path) {
        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new
                    FileReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Agrego los datos
        for(CSVRecord row: parser) {
            insert(new Factura(Integer.valueOf(row.get("idFactura")), Integer.valueOf(row.get("idCliente"))));
        }
    }

}
