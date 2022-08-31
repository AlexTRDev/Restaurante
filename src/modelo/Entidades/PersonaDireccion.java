package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class PersonaDireccion {

    private Integer codigo;
    private Persona oPersona;
    private String calle;
    private String numero;
    private String ciudad;
    private String departamento;
    private String pais;

    public PersonaDireccion() {
    }

    public PersonaDireccion(Integer codigo) {
        this.codigo = codigo;
    }

    public PersonaDireccion(Integer codigo, Persona oPersona, String calle, String numero, String ciudad, String departamento, String pais) {
        this.codigo = codigo;
        this.oPersona = oPersona;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "PersonaDireccion{" + "codigo=" + codigo + ", oPersona=" + oPersona + ", calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", departamento=" + departamento + ", pais=" + pais + '}';
    }
    
}
