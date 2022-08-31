package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class PersonaCelular {

    private Integer codigo;
    private Persona oPersona;
    private String celular;

    public PersonaCelular() {
    }

    public PersonaCelular(Integer codigo) {
        this.codigo = codigo;
    }

    public PersonaCelular(Integer codigo, Persona oPersona, String celular) {
        this.codigo = codigo;
        this.oPersona = oPersona;
        this.celular = celular;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "PersonaCelular{" + "codigo=" + codigo + ", oPersona=" + oPersona + ", celular=" + celular + '}';
    }
    
}
