package modelo.Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author ALEX
 */
public class Mesa {
    private Integer codigo;
    private Boolean estado;
    private Integer numeroPersonas;
    private String horaEntrada;
    private String horaSalida;
    private Integer mesaNumero;
//    private String formatoFecha;
//    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
    
    public Mesa() {
    }
    
    public Mesa(Integer codigo) {
        this.codigo = codigo;
    }

    public Mesa(Integer codigo, Boolean estado, Integer numeroPersonas, String horaEntrada, String horaSalida, Integer mesaNumero) {
        this.codigo = codigo;
        this.estado = estado;
        this.numeroPersonas = numeroPersonas;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.mesaNumero = mesaNumero;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getMesaNumero() {
        return mesaNumero;
    }

    public void setMesaNumero(Integer mesaNumero) {
        this.mesaNumero = mesaNumero;
    }

    @Override
    public String toString() {
        return "Mesa{" + "codigo=" + codigo + ", estado=" + estado + ", numeroPersonas=" + numeroPersonas + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", mesaNumero=" + mesaNumero + '}';
    }
}
