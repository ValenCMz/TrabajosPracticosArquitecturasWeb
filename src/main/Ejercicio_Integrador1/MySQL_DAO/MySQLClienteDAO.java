package main.Ejercicio_Integrador1.MySQL_DAO;

import main.Ejercicio_Integrador1.DAO.ClienteDAO;
import main.Ejercicio_Integrador1.DTO.ClienteDTO;
import main.Ejercicio_Integrador1.Modelo.Cliente;
import main.Ejercicio_Integrador1.Modelo.Producto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLClienteDAO implements ClienteDAO {

    private Connection conn;

    public MySQLClienteDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente d) {
        String sentence = "INSERT INTO cliente (idCliente,nombre,email) VALUES(?,?,?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sentence);
            ps.setInt(1,d.getIdCliente());
            ps.setString(2,d.getNombre());
            ps.setString(3,d.getEmail());
            ps.executeUpdate();
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
            insert(new Cliente(Integer.valueOf(row.get("idCliente")),row.get("nombre"),row.get("email")));
        }
    }

    @Override
    public List<ClienteDTO> getClientes() {
        List<ClienteDTO> toReturn = new ArrayList<>();
        try {
            conn.setAutoCommit(false);
            String query = "SELECT c.idCliente, c.nombre, c.email, SUM(p.valor * fp.cantidad) as suma\n" +
                    "FROM cliente c\n" +
                    "JOIN factura f ON c.idCliente = f.idCLiente \n" +
                    "JOIN factura_producto fp ON f.idFactura = fp.idFactura\n" +
                    "JOIN producto p ON fp.idProducto = p.idProducto\n" +
                    "GROUP BY c.idCliente\n" +
                    "ORDER BY suma DESC;";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClienteDTO c = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                toReturn.add(c);
            }
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
}
