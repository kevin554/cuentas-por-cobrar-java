package dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanDePago extends ObjectDTO {

    private int codigoID;
    private int clienteID;
    private int productoID;
    private Date fechaAdquisicion;
    private int cantidadCuotas;

    public PlanDePago(int codigoID, int clienteID, int productoID, 
            Date fechaAdquisicion, int cantidadCuotas) {
        this.codigoID = codigoID;
        this.clienteID = clienteID;
        this.productoID = productoID;
        this.fechaAdquisicion = fechaAdquisicion;
        this.cantidadCuotas = cantidadCuotas;
    }

    @Override
    public Object obtenerColumna(int columna) {
        switch (columna) {
            case 0:
                return this.codigoID;
                
            case 1:
                return this.clienteID;
                
            case 2:
                return this.productoID;
                
            case 3:
                return this.fechaAdquisicion;
                
            case 4:
                return this.cantidadCuotas;
                
            default:
                return null;
        }
    }

    public String getFechaAdquisicionFormateada() {
        DateFormat formato = new SimpleDateFormat("yyyyMMdd");
        
        return formato.format(fechaAdquisicion);
    }
    
    public java.sql.Date getFechaAdquisicionSQL() {
        return new java.sql.Date(fechaAdquisicion.getTime());
    }
    
    // <editor-fold defaultstate="collapsed" desc="getters, setters y toString">
    
    public int getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(int codigoID) {
        this.codigoID = codigoID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    @Override
    public String toString() {
        return "PlanDePagosDTO{" + "codigoID=" + codigoID + ", clienteID=" 
                + clienteID + ", productoID=" + productoID 
                + ", fechaAdquisicion=" + fechaAdquisicion 
                + ", cantidadCuotas=" + cantidadCuotas + '}';
    }
    
    // </editor-fold>
    
}