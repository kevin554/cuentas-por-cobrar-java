package dto;

public class Cliente extends ObjectDTO {

    private int codigoID;
    private String nombre;
    private String apellido;
    private String factura;
    private String estado;

    public Cliente(int codigoID, String nombre, String apellido, String factura,
            String estado) {
        this.codigoID = codigoID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.factura = factura;
        this.estado = estado;
    }

    @Override
    public Object obtenerColumna(int columna) {
        switch (columna) {
            case 0:
                return this.codigoID;
                
            case 1:
                return this.nombre;
                
            case 2:
                return this.apellido;
                
            case 3:
                return this.factura;
                
            case 4:
                return this.estado;
                
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ClientesDTO{" + "codigoID=" + codigoID + ", nombre=" + nombre 
                + ", apellido=" + apellido + ", factura=" + factura 
                + ", estado=" + estado + '}';
    }
    
    // </editor-fold>
    
}