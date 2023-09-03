package main.Ejercicio_Integrador1.DAO;

import main.Ejercicio_Integrador1.DTO.ProductoDTO;
import main.Ejercicio_Integrador1.Modelo.Producto;

public interface ProductoDAO extends DAO<Producto> {
    public ProductoDTO getProductoMasRecaudo();
}
