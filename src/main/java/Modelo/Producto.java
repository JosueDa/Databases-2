
package Modelo;

public class Producto {
    int id;
    String Nombre;
    int precioL;
    int memoria;
    int almacenamiento;
    String procesador;
    int cores;
    String descripcion;
    String color;
    Double precioV;
    String imagen1;
    String imagen2;
    String imagen3;
    int Cantidad;
    int idMarca;
    String marca;
    
        public Producto() {
    }

    public Producto(int id, String Nombre, int precioL, int memoria, int almacenamiento, String procesador, int cores, String descripcion, String color, Double precioV, String imagen1, String imagen2, String imagen3, int Cantidad, int idMarca, String marca) {
        this.id = id;
        this.Nombre = Nombre;
        this.precioL = precioL;
        this.memoria = memoria;
        this.almacenamiento = almacenamiento;
        this.procesador = procesador;
        this.cores = cores;
        this.descripcion = descripcion;
        this.color = color;
        this.precioV = precioV;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.Cantidad = Cantidad;
        this.idMarca = idMarca;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    
    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPrecioL() {
        return precioL;
    }

    public void setPrecioL(int precioL) {
        this.precioL = precioL;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(Double precioV) {
        this.precioV = precioV;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }
    
    
}
