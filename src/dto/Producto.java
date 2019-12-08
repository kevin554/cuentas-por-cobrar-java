package dto;

public class Producto extends ObjectDTO {

    private int codigoID;
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto(int codigoID, String nombre, String descripcion, 
            double precio) {
        this.codigoID = codigoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public Object obtenerColumna(int columna) {
        switch (columna) {
            case 0:
                return this.codigoID;
                
            case 1:
                return this.nombre;
                
            case 2:
                return this.descripcion;
                
            case 3:
                return this.precio;
                
            default:
                return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="getters, setters y toString">
    
    public int getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(int codigoID) {
        this.codigoID = codigoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductosDTO{" + "codigoID=" + codigoID + ", nombre=" + nombre 
                + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    // </editor-fold>
    
}