
package modelo.Entidades;


/**
 *
 * @author ALEX
 */
public class Usuario {
    
    private Persona oPersona;
    private TipoUsuario oTipoUsuarios;
    private String User;
    private String Password;
    private byte[] foto;

    public Usuario() {
    }

    public Usuario(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public Usuario(TipoUsuario oTipoUsuarios) {
        this.oTipoUsuarios = oTipoUsuarios;
    }

    public Usuario(Persona oPersona, TipoUsuario oTipoUsuarios) {
        this.oPersona = oPersona;
        this.oTipoUsuarios = oTipoUsuarios;
    }
    
    public Usuario(Persona oPersona, TipoUsuario oTipoUsuarios, String User, String Password, byte[] foto) {
        this.oPersona = oPersona;
        this.oTipoUsuarios = oTipoUsuarios;
        this.User = User;
        this.Password = Password;
        this.foto = foto;
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public TipoUsuario getoTipoUsuarios() {
        return oTipoUsuarios;
    }

    public void setoTipoUsuarios(TipoUsuario oTipoUsuarios) {
        this.oTipoUsuarios = oTipoUsuarios;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return oTipoUsuarios.getNombre();
    }

}
