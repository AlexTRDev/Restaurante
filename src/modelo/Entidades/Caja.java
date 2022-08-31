package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class Caja {
    
    private Integer codigo;
    private Double saldoInicial;
    private Double saldoFinal;
    private Boolean estado;
    private String fechaOpen;
    private String fechaClose;
    private String detalle;
    private Usuario oUsuario;

    public Caja() {
    }

    public Caja(Integer codigo) {
        this.codigo = codigo;
    }

    public Caja(Integer codigo, Double saldoInicial, Double saldoFinal, Boolean estado, String fechaOpen, String fechaClose, String detalle, Usuario oUsuario) {
        this.codigo = codigo;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.estado = estado;
        this.fechaOpen = fechaOpen;
        this.fechaClose = fechaClose;
        this.detalle = detalle;
        this.oUsuario = oUsuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFechaOpen() {
        return fechaOpen;
    }

    public void setFechaOpen(String fechaOpen) {
        this.fechaOpen = fechaOpen;
    }

    public String getFechaClose() {
        return fechaClose;
    }

    public void setFechaClose(String fechaClose) {
        this.fechaClose = fechaClose;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    @Override
    public String toString() {
        return "Caja{" + "codigo=" + codigo + ", saldoInicial=" + saldoInicial + ", saldoFinal=" + saldoFinal + ", estado=" + estado + ", fechaOpen=" + fechaOpen + ", fechaClose=" + fechaClose + ", detalle=" + detalle + ", oUsuario=" + oUsuario + '}';
    }
    
    
}
