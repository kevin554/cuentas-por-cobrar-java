package dto;

import java.util.Date;

public class DetalleDePagosMensuales extends ObjectDTO {

    private int cuota;
    private int monto;
    private Date fechaPago;

    public DetalleDePagosMensuales(int cuota, int monto, Date fechaPago) {
        this.cuota = cuota;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    @Override
    public Object obtenerColumna(int columna) {
        switch (columna) {
            case 0:
                return this.cuota;

            case 1:
                return this.monto;

            case 2:
                return this.fechaPago;

            default:
                return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="getters, setters y toString">
    
    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "DetalleDePagosMensualesDTO{" + "cuota=" + cuota + ", monto="
                + monto + ", fechaPago=" + fechaPago + '}';
    }
    
    // </editor-fold>
    
}
