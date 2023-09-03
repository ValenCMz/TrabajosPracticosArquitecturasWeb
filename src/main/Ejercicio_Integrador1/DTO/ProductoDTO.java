package main.Ejercicio_Integrador1.DTO;

public class ProductoDTO {
    private int idProducto;
    private String nombre;
    private float valor;

    private float recaudado;

    public ProductoDTO(int idProducto, String nombre, float valor, float recaudado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valor = valor;
        this.recaudado = recaudado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(float recaudado) {
        this.recaudado = recaudado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                ", recaudado=" + recaudado +
                '}';
    }
}
