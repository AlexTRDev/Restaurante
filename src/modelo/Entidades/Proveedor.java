package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class Proveedor {
    private Integer ruc;
    private String nombre;
    private String pagina_web;

    public Proveedor() {
    }

    public Proveedor(Integer ruc) {
        this.ruc = ruc;
    }

    public Proveedor(Integer ruc, String nombre, String pagina_web) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.pagina_web = pagina_web;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public Integer getRuc() {
        return ruc;
    }

    public void setRuc(Integer ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "ruc=" + ruc + ", nombre=" + nombre + ", pagina_web=" + pagina_web + '}';
    }
    
}
