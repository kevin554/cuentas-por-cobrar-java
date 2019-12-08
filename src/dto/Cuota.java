package dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuota extends ObjectDTO {

    private int codigoID;
    private int planDePagosID;
    private int clienteID;
    private int productoID;
    private Date fechaVencimiento;
    private Date fechaPago;
    private double monto;

    public Cuota(int codigoID, int planDePagosID, int clienteID, int productoID,
            Date fechaVencimiento, Date fechaPago, int monto) {
        this.codigoID = codigoID;
        this.planDePagosID = planDePagosID;
        this.clienteID = clienteID;
        this.productoID = productoID;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPago = fechaPago;
        this.monto = monto;
        
    }

    @Override
    public Object obtenerColumna(int columna) {
        switch (columna) {
            case 0:
                return this.codigoID;
                
            case 1:
                return this.planDePagosID;
                
            case 2:
                return this.clienteID;
                
            case 3:
                return this.productoID;
                
            case 4:
                return this.fechaVencimiento;
                
            case 5:
                return this.fechaPago;
                
            case 6:
                return this.monto;
                
            default:
                return null;
        }
    }

    public String getFechaVencimientoFormateada() {
        DateFormat formato = new SimpleDateFormat("yyyyMMdd");
        
        return formato.format(fechaVencimiento);
    }
    
    public java.sql.Date getFechaVencimientoSQL() {
        return new java.sql.Date(fechaVencimiento.getTime());
    }

    public String getFechaPagoFormateada() {
        DateFormat formato = new SimpleDateFormat("yyyyMMdd");
        
        return formato.format(fechaPago);
    }
    
    public java.sql.Date getFechaPagoSQL() {
        return new java.sql.Date(fechaPago.getTime());
    }

    // <editor-fold defaultstate="collapsed" desc="getters, setters y toString">
    
    public int getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(int codigoID) {
        this.codigoID = codigoID;
    }

    public int getPlanDePagosID() {
        return planDePagosID;
    }

    public void setPlanDePagosID(int planDePagosID) {
        this.planDePagosID = planDePagosID;
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

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Cuota{" + "codigoID=" + codigoID + ", planDePagosID=" 
                + planDePagosID + ", clienteID=" + clienteID + ", productoID=" 
                + productoID + ", fechaVencimiento=" + fechaVencimiento 
                + ", fechaPago=" + fechaPago + ", monto=" + monto + '}';
    }
    
    // </editor-fold>

}