package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class PersonaReservacion {

    private int codigo;
    private Persona oPersona;
    private Mesa oMesa;
    private String fechaReservacion;
    private String fechaReservada;

    public PersonaReservacion() {
    }

    public PersonaReservacion(int codigo, Persona oPersona) {
        this.codigo = codigo;
        this.oPersona = oPersona;
    }

    public PersonaReservacion(int codigo, Persona oPersona, Mesa oMesa, String fechaReservacion, String fechaReservada) {
        this.codigo = codigo;
        this.oPersona = oPersona;
        this.oMesa = oMesa;
        this.fechaReservacion = fechaReservacion;
        this.fechaReservada = fechaReservada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public Mesa getoMesa() {
        return oMesa;
    }

    public void setoMesa(Mesa oMesa) {
        this.oMesa = oMesa;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getFechaReservada() {
        return fechaReservada;
    }

    public void setFechaReservada(String fechaReservada) {
        this.fechaReservada = fechaReservada;
    }

    @Override
    public String toString() {
        return "PersonaReservacion{" + "codigo=" + codigo + ", oPersona=" + oPersona + ", oMesa=" + oMesa + ", fechaReservacion=" + fechaReservacion + ", fechaReservada=" + fechaReservada + '}';
    }
    
}
