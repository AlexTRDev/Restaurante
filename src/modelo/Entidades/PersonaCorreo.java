package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class PersonaCorreo {
    
    private Integer codigo;
    private Persona oPersona;
    private String correo;

    public PersonaCorreo() {
    }

    public PersonaCorreo(Integer codigo) {
        this.codigo = codigo;
    }

    public PersonaCorreo(Integer codigo, Persona oPersona, String correo) {
        this.codigo = codigo;
        this.oPersona = oPersona;
        this.correo = correo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "PersonaCorreo{" + "codigo=" + codigo + ", oPersona=" + oPersona + ", correo=" + correo + '}';
    }

}
