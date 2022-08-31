package modelo.dao.interfaces;

import java.util.List;

/**
 *
 * @author ALEX
 */
public interface metodosDAO<E> {
    
    public List<E> listar();
    public boolean insertar(E Obj);
    public boolean actualizar(E Obj);
    public boolean eliminar(E Obj);
    public int buscaCodigo(E Obj);
    public E getObjeto(E Obj);
    
}
