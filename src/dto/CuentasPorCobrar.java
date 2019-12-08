package dto;

import java.util.Date;

public class CuentasPorCobrar extends ObjectDTO {

    private int codigoID;
    private String factura;
    private String nombre;
    private String apellido;
    private String producto;
    private double precio;
    private double montoRestante;
    private Date fechaAdquisicion;
    private Date fechaFinalizacion;

    public CuentasPorCobrar(int codigoID, String factura, String nombre,
            String apellido, String producto, double precio,
            double montoRestante, Date fechaAdquisicion,
            Date fechaFinalizacion) {
        this.codigoID = codigoID;
        this.factura = factura;
        this.nombre = nombre;
        this.apellido = apellido;
        this.producto = producto;
        this.precio = precio;
        this.montoRestante = montoRestante;
        this.fechaAdquisicion = fechaAdquisicion;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    @Override
    public Object obtenerColumna(int columna) {
        switch (columna) {
            case 0:
                return this.codigoID;

            case 1:
                return this.factura;

            case 2:
                return this.nombre;

            case 3:
                return this.apellido;

            case 4:
                return this.producto;

            case 5:
                return this.precio;

            case 6:
                return this.montoRestante;

            case 7:
                return this.fechaAdquisicion;

            case 8:
                return this.fechaFinalizacion;

            default:
                return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    
    public int getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(int codigoID) {
        this.codigoID = codigoID;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMontoRestante() {
        return montoRestante;
    }

    public void setMontoRestante(double montoRestante) {
        this.montoRestante = montoRestante;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    @Override
    public String toString() {
        return "CuentasPorCobrar{" + "codigoID=" + codigoID + ", factura=" 
                + factura + ", nombre=" + nombre + ", apellido=" + apellido 
                + ", producto=" + producto + ", precio=" + precio 
                + ", montoRestante=" + montoRestante + ", fechaAdquisicion=" 
                + fechaAdquisicion + ", fechaFinalizacion=" + fechaFinalizacion 
                + '}';
    }
    
    // </editor-fold>

}
