package modelo.Entidades;

import java.sql.Date;

/**
 *
 * @author ALEX
 */
public class Factura {
    private Integer codigo;
    private String numeroFactura;
    private String numeroBoleta;
    private Double IGV;
    private String fechaFacturacion;
    private String tipo;
    public enum tipoFactura{
    BOLETA,FACTURA
    };

    public Factura() {
    }

    public Factura(Integer codigo) {
        this.codigo = codigo;
    }

    public Factura(Integer codigo, String numeroFactura, String numeroBoleta, Double IGV, String fechaFacturacion, String tipo) {
        this.codigo = codigo;
        this.numeroFactura = numeroFactura;
        this.numeroBoleta = numeroBoleta;
        this.IGV = IGV;
        this.fechaFacturacion = fechaFacturacion;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(String numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }
    
    public Double getIGV() {
        return IGV;
    }

    public void setIGV(Double IGV) {
        this.IGV = IGV;
    }

    public String getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(String fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Factura{" + "codigo=" + codigo + ", numeroFactura=" + numeroFactura + ", IGV=" + IGV + ", fechaFacturacion=" + fechaFacturacion + ", tipo=" + tipo + '}';
    }
    
}
