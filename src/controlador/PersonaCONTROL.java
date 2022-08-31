package controlador;



import Util.Util;
import Util.mdlGeneral;
import java.awt.event.*;

import java.util.*;

import javax.swing.*;

import modelo.Entidades.*;
import modelo.LogicaNegocio.*;
import modelo.vista.*;

/**
 *
 * @author ALEX
 */
public class PersonaCONTROL {

    private final PersonaLN DATOS;
    
    private JFrame principal;
    private MantenimientoProducto oMantenimientoProducto;
    
    private List<Persona> lista;
    private List<JLabel> listaProductosImagenes, listaBotonesCenter;

    private JPanel pnlCenterHead, pnlCenterBoddy, pnlCenterFoot;
    private JPanel pnlRightHead, pnlRightBoddy, pnlRightFoot;

    private MouseListener oyenteCenterFoot,oyenteCenterBoddy, oyenteRightFoot;

    private JLabel lblNuevoProducto, lblEditarProducto, lblEliminarProducto;

    private Categoria selecionCategoria;
    private Producto seleccionProducto;
    
    private boolean isNuevo;
    private JLabel lblCabecera;
    private JLabel lblFiltrar;

    public PersonaCONTROL() {
        DATOS = new PersonaLN();

    }

    public List<Persona> Listar() {
        return DATOS.listar();
    }
    public List<Persona> ListarPorDNI(Persona obj) {
        return DATOS.listarPorDNI(obj);
    }
    
        
//    public List<Persona> listarPorTipoUsuario(TipoUsuario oTipoUsuario) {
//        return DATOS.listarPorTipoUsuario(oTipoUsuario);
//    }
    
   
    public String Insertar(Persona obj) {
//        if (DATOS.buscarNombre(obj) == 1) {
//            return "EL NOMBRE INGRESADO YA EXISTE";
//        } else {
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "ERROR AL INSERTAR EL REGISTRO";
            }
//        }
    }

    public String Actualizar(Persona obj) {
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "ERROR AL ACTUALIZAR EL REGISTRO";
        }

    }

    public String Eliminar(Persona obj) {
        if (DATOS.eliminar(obj)) {
            return "OK";
        } else {
            return "ERROR AL ELIMINAR EL REGISTRO";
        }
    }
    
    public void modeloTabla(JTable tabla){
        
        String []nombreColumnas = {"DNI","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","SEXO","FECHA NACIMIENTO"};
       
        tabla.setModel(new mdlGeneral(nombreColumnas));
        Integer anchos[] = {100,100,125,125,100,175};
        Integer alineaciones[] = {JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER};
        String formatos[] = {"Cadena","Cadena","Cadena","Cadena","Cadena","Cadena",};
        String modos[] = {"RESALTADO","EDITABLE","NORMAL","NORMAL","NORMAL","NORMAL"};

        Util.AplicarEstilos(tabla,anchos,alineaciones,formatos,modos);
    }
    
    public void mostrarTabla(JTable tabla){
        lista = Listar();
        ((mdlGeneral)(tabla.getModel())).setData(parseVector(lista));
        
    }
    
    public void mostrarTablaFiltro(JTable tabla, Persona filtro){
        lista = ListarPorDNI(filtro);
        ((mdlGeneral)(tabla.getModel())).setData(parseVector(lista));
        
    }
    
    private List parseVector(List<Persona> lista) {
        List datos = new ArrayList();
        Object[] newdata;
        for(int i = 0; i < lista.size(); i++) {
            newdata = new Object[6];

            newdata[0] = lista.get(i).getDni();
            newdata[1] = lista.get(i).getNombres();
            newdata[2] = lista.get(i).getApellidoPaterno();
            newdata[3] = lista.get(i).getApellidoMaterno();
            newdata[4] = lista.get(i).getSexo();
            newdata[5] = lista.get(i).getFechaNacimiento();

            datos.add(newdata);
        }
        return datos;
    }
    

    public void setFrame(JFrame principal){
        this.principal = principal;
    }
    
    public void setPaneles(JPanel pnlCenterHead, JPanel pnlCenterBoddy, JPanel pnlCenterFoot, JPanel pnlRightHead, JPanel pnlRightBoddy, JPanel pnlRightFoot) {
        this.pnlCenterHead = pnlCenterHead;
        this.pnlCenterBoddy = pnlCenterBoddy;
        this.pnlCenterFoot = pnlCenterFoot;
        this.pnlRightHead = pnlRightHead;
        this.pnlRightBoddy = pnlRightBoddy;
        this.pnlRightFoot = pnlRightFoot;
    }

    public void setSelecionCategoria(Categoria selecionCategoria) {
        this.selecionCategoria = selecionCategoria;
    }

}
