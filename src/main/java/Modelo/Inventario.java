
package Modelo;

public class Inventario {
    int id;
    int idProducto;
    int cantidad;
    String nombreProducto;

    public Inventario() {
    }

    public Inventario(int id, int idProducto, int cantidad, String nombreProducto) {
        this.id = id;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
}
    