package modelo.vista;

import Util.MiScrollBar;
import controlador.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ALEX
 */
public class FrmPrincipal extends javax.swing.JFrame {

    CategoriaCONTROL oCategoriaCONTROL;
    ProductoCONTROL oProductoCONTROL;
    TipoUsuarioCONTROL oTipoUsuariosCONTROL;
    
    
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
        lenarCabeceras();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBG = new javax.swing.JPanel();
        PnlCabecera = new javax.swing.JPanel();
        PnalPrincipal = new javax.swing.JPanel();
        PnlHome = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PnlProductos = new javax.swing.JPanel();
        JlblProductos = new javax.swing.JLabel();
        PnlUsuarios = new javax.swing.JPanel();
        lblMenuUsuarios = new javax.swing.JLabel();
        pnlMantenimiento = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PnlSession = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        PnlOpciones = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PnlMinimizar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PnlCerrar = new javax.swing.JPanel();
        JLblCerrar = new javax.swing.JLabel();
        PnlLeft = new javax.swing.JPanel();
        pnlLeftBoddy = new javax.swing.JPanel();
        pnlLeftFoot = new javax.swing.JPanel();
        pnlLeftHead = new javax.swing.JPanel();
        PnlCenter = new javax.swing.JPanel();
        pnlCenterBoddy = new javax.swing.JPanel();
        pnlCenterFoot = new javax.swing.JPanel();
        pnlCenterHead = new javax.swing.JPanel();
        PnlRight = new javax.swing.JPanel();
        pnlRightFoot = new javax.swing.JPanel();
        pnlRightBoddy = new javax.swing.JPanel();
        pnlRightHead = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnlBG.setBackground(new java.awt.Color(255, 255, 255));

        PnlCabecera.setOpaque(false);

        PnalPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PnalPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 1, true));

        PnlHome.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_home_50px_1.png"))); // NOI18N
        jLabel4.setText("HOME");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PnlHomeLayout = new javax.swing.GroupLayout(PnlHome);
        PnlHome.setLayout(PnlHomeLayout);
        PnlHomeLayout.setHorizontalGroup(
            PnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        );
        PnlHomeLayout.setVerticalGroup(
            PnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        PnlProductos.setBackground(new java.awt.Color(255, 255, 255));

        JlblProductos.setBackground(new java.awt.Color(255, 255, 255));
        JlblProductos.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        JlblProductos.setForeground(new java.awt.Color(0, 51, 255));
        JlblProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlblProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_tags_50px.png"))); // NOI18N
        JlblProductos.setText("PRODUCTOS");
        JlblProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JlblProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JlblProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JlblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlblProductosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PnlProductosLayout = new javax.swing.GroupLayout(PnlProductos);
        PnlProductos.setLayout(PnlProductosLayout);
        PnlProductosLayout.setHorizontalGroup(
            PnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JlblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        PnlProductosLayout.setVerticalGroup(
            PnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JlblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        PnlUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        lblMenuUsuarios.setBackground(new java.awt.Color(0, 51, 255));
        lblMenuUsuarios.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblMenuUsuarios.setForeground(new java.awt.Color(0, 51, 255));
        lblMenuUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_male_user_50px.png"))); // NOI18N
        lblMenuUsuarios.setText("USUARIOS");
        lblMenuUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenuUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblMenuUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PnlUsuariosLayout = new javax.swing.GroupLayout(PnlUsuarios);
        PnlUsuarios.setLayout(PnlUsuariosLayout);
        PnlUsuariosLayout.setHorizontalGroup(
            PnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlUsuariosLayout.createSequentialGroup()
                .addComponent(lblMenuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PnlUsuariosLayout.setVerticalGroup(
            PnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlUsuariosLayout.createSequentialGroup()
                .addComponent(lblMenuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlMantenimiento.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(0, 51, 255));
        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_maintenance_50px_1.png"))); // NOI18N
        jLabel7.setText("MANTENIMIENTO");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlMantenimientoLayout = new javax.swing.GroupLayout(pnlMantenimiento);
        pnlMantenimiento.setLayout(pnlMantenimientoLayout);
        pnlMantenimientoLayout.setHorizontalGroup(
            pnlMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMantenimientoLayout.setVerticalGroup(
            pnlMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        PnlSession.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(0, 51, 255));
        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_exit_50px.png"))); // NOI18N
        jLabel8.setText("CERRAR SESION");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout PnlSessionLayout = new javax.swing.GroupLayout(PnlSession);
        PnlSession.setLayout(PnlSessionLayout);
        PnlSessionLayout.setHorizontalGroup(
            PnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlSessionLayout.setVerticalGroup(
            PnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PnalPrincipalLayout = new javax.swing.GroupLayout(PnalPrincipal);
        PnalPrincipal.setLayout(PnalPrincipalLayout);
        PnalPrincipalLayout.setHorizontalGroup(
            PnalPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnalPrincipalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(PnlHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(PnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(PnlUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(pnlMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(PnlSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        PnalPrincipalLayout.setVerticalGroup(
            PnalPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnalPrincipalLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PnalPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PnalPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PnlSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PnlUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PnlProductos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PnlHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlUsuarios.getAccessibleContext().setAccessibleName("");

        PnlOpciones.setOpaque(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_menu_80px.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PnlOpcionesLayout = new javax.swing.GroupLayout(PnlOpciones);
        PnlOpciones.setLayout(PnlOpcionesLayout);
        PnlOpcionesLayout.setHorizontalGroup(
            PnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlOpcionesLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PnlOpcionesLayout.setVerticalGroup(
            PnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlOpcionesLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PnlMinimizar.setOpaque(false);

        jLabel2.setBackground(new java.awt.Color(0, 0, 204));
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar_25px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout PnlMinimizarLayout = new javax.swing.GroupLayout(PnlMinimizar);
        PnlMinimizar.setLayout(PnlMinimizarLayout);
        PnlMinimizarLayout.setHorizontalGroup(
            PnlMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlMinimizarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        PnlMinimizarLayout.setVerticalGroup(
            PnlMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
        );

        PnlCerrar.setOpaque(false);
        PnlCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnlCerrarMouseClicked(evt);
            }
        });

        JLblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_delete_25px.png"))); // NOI18N
        JLblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PnlCerrarLayout = new javax.swing.GroupLayout(PnlCerrar);
        PnlCerrar.setLayout(PnlCerrarLayout);
        PnlCerrarLayout.setHorizontalGroup(
            PnlCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlCerrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JLblCerrar))
        );
        PnlCerrarLayout.setVerticalGroup(
            PnlCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLblCerrar)
        );

        javax.swing.GroupLayout PnlCabeceraLayout = new javax.swing.GroupLayout(PnlCabecera);
        PnlCabecera.setLayout(PnlCabeceraLayout);
        PnlCabeceraLayout.setHorizontalGroup(
            PnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCabeceraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PnalPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PnlMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(PnlCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        PnlCabeceraLayout.setVerticalGroup(
            PnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCabeceraLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PnalPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PnlMinimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PnlCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );

        PnlLeft.setBackground(new java.awt.Color(255, 255, 255));
        PnlLeft.setOpaque(false);
        PnlLeft.setPreferredSize(new java.awt.Dimension(250, 480));

        pnlLeftBoddy.setBackground(new java.awt.Color(255, 255, 255));
        pnlLeftBoddy.setOpaque(false);

        javax.swing.GroupLayout pnlLeftBoddyLayout = new javax.swing.GroupLayout(pnlLeftBoddy);
        pnlLeftBoddy.setLayout(pnlLeftBoddyLayout);
        pnlLeftBoddyLayout.setHorizontalGroup(
            pnlLeftBoddyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );
        pnlLeftBoddyLayout.setVerticalGroup(
            pnlLeftBoddyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        pnlLeftFoot.setBackground(new java.awt.Color(0, 102, 102));
        pnlLeftFoot.setOpaque(false);

        javax.swing.GroupLayout pnlLeftFootLayout = new javax.swing.GroupLayout(pnlLeftFoot);
        pnlLeftFoot.setLayout(pnlLeftFootLayout);
        pnlLeftFootLayout.setHorizontalGroup(
            pnlLeftFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLeftFootLayout.setVerticalGroup(
            pnlLeftFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        pnlLeftHead.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout pnlLeftHeadLayout = new javax.swing.GroupLayout(pnlLeftHead);
        pnlLeftHead.setLayout(pnlLeftHeadLayout);
        pnlLeftHeadLayout.setHorizontalGroup(
            pnlLeftHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLeftHeadLayout.setVerticalGroup(
            pnlLeftHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PnlLeftLayout = new javax.swing.GroupLayout(PnlLeft);
        PnlLeft.setLayout(PnlLeftLayout);
        PnlLeftLayout.setHorizontalGroup(
            PnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeftHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeftBoddy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlLeftFoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlLeftLayout.setVerticalGroup(
            PnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlLeftLayout.createSequentialGroup()
                .addComponent(pnlLeftHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLeftBoddy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLeftFoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PnlCenter.setBackground(new java.awt.Color(255, 255, 255));

        pnlCenterBoddy.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlCenterBoddyLayout = new javax.swing.GroupLayout(pnlCenterBoddy);
        pnlCenterBoddy.setLayout(pnlCenterBoddyLayout);
        pnlCenterBoddyLayout.setHorizontalGroup(
            pnlCenterBoddyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlCenterBoddyLayout.setVerticalGroup(
            pnlCenterBoddyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        pnlCenterFoot.setBackground(new java.awt.Color(0, 102, 102));
        pnlCenterFoot.setOpaque(false);

        javax.swing.GroupLayout pnlCenterFootLayout = new javax.swing.GroupLayout(pnlCenterFoot);
        pnlCenterFoot.setLayout(pnlCenterFootLayout);
        pnlCenterFootLayout.setHorizontalGroup(
            pnlCenterFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlCenterFootLayout.setVerticalGroup(
            pnlCenterFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        pnlCenterHead.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout pnlCenterHeadLayout = new javax.swing.GroupLayout(pnlCenterHead);
        pnlCenterHead.setLayout(pnlCenterHeadLayout);
        pnlCenterHeadLayout.setHorizontalGroup(
            pnlCenterHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        pnlCenterHeadLayout.setVerticalGroup(
            pnlCenterHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PnlCenterLayout = new javax.swing.GroupLayout(PnlCenter);
        PnlCenter.setLayout(PnlCenterLayout);
        PnlCenterLayout.setHorizontalGroup(
            PnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCenterHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCenterFoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCenterBoddy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlCenterLayout.setVerticalGroup(
            PnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlCenterLayout.createSequentialGroup()
                .addComponent(pnlCenterHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCenterBoddy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCenterFoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PnlRight.setBackground(new java.awt.Color(255, 255, 255));

        pnlRightFoot.setBackground(new java.awt.Color(0, 102, 102));
        pnlRightFoot.setOpaque(false);

        javax.swing.GroupLayout pnlRightFootLayout = new javax.swing.GroupLayout(pnlRightFoot);
        pnlRightFoot.setLayout(pnlRightFootLayout);
        pnlRightFootLayout.setHorizontalGroup(
            pnlRightFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlRightFootLayout.setVerticalGroup(
            pnlRightFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        pnlRightBoddy.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlRightBoddyLayout = new javax.swing.GroupLayout(pnlRightBoddy);
        pnlRightBoddy.setLayout(pnlRightBoddyLayout);
        pnlRightBoddyLayout.setHorizontalGroup(
            pnlRightBoddyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlRightBoddyLayout.setVerticalGroup(
            pnlRightBoddyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        pnlRightHead.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout pnlRightHeadLayout = new javax.swing.GroupLayout(pnlRightHead);
        pnlRightHead.setLayout(pnlRightHeadLayout);
        pnlRightHeadLayout.setHorizontalGroup(
            pnlRightHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        pnlRightHeadLayout.setVerticalGroup(
            pnlRightHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PnlRightLayout = new javax.swing.GroupLayout(PnlRight);
        PnlRight.setLayout(PnlRightLayout);
        PnlRightLayout.setHorizontalGroup(
            PnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRightHead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRightFoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRightBoddy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlRightLayout.setVerticalGroup(
            PnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlRightLayout.createSequentialGroup()
                .addComponent(pnlRightHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlRightBoddy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlRightFoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlBGLayout = new javax.swing.GroupLayout(pnlBG);
        pnlBG.setLayout(pnlBGLayout);
        pnlBGLayout.setHorizontalGroup(
            pnlBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(PnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBGLayout.setVerticalGroup(
            pnlBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBGLayout.createSequentialGroup()
                .addComponent(PnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnlBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PnlCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnlCerrarMouseClicked

    }//GEN-LAST:event_PnlCerrarMouseClicked

    private void JLblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLblCerrarMouseClicked
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_JLblCerrarMouseClicked

    private void JlblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlblProductosMouseClicked
        llenarProductos();
    }//GEN-LAST:event_JlblProductosMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        llenarHome();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void lblMenuUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuUsuariosMouseClicked
        llenarUsuarios();
    }//GEN-LAST:event_lblMenuUsuariosMouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
                
            }
        });
    }
    
    public void pintarHomeLeft(JPanel boody){
        boody.setSize(264, 450);
        boody.setLocation(0, 0);
        
        pnlLeftBoddy.removeAll();
        pnlLeftBoddy.add(boody);
        pnlLeftBoddy.revalidate();
        pnlLeftBoddy.repaint();
    }
    
    public void llenarHome(){
        PnlHead head = new PnlHead("HOME",true);
        head.setSize(264, 30);
        head.setLocation(0, 0);
        pintarPanelHead(pnlLeftHead,head);
        
        PnlHome boddy = new PnlHome();
        boddy.setSize(264, 415);
        boddy.setLocation(0, 0);
        pintarHomeLeft(boddy);
        
        pintarPanelLeftFoot(pnlLeftFoot, new JPanel(), false);
    }
    
    public void pintarPanelHead(JPanel principal,JPanel head){
        principal.removeAll();
        principal.add(head);
        principal.revalidate();
        principal.repaint();
    }

    public void pintarLeftBoddy(JPanel principal, JPanel boody, int size){
        principal.removeAll();
        int espaciosAlto=5;
        int espaciosAncho=0;
        GridLayout disposicion = new GridLayout(size, 1, espaciosAncho, espaciosAlto);
        boody.setLayout(disposicion);
        JScrollPane scroll = new JScrollPane();
        scroll.setSize(principal.getWidth(), principal.getHeight());
        scroll.setViewportView(boody);
        scroll.getVerticalScrollBar().setUI(MiScrollBar.getScrollPersonalizado(7, 10, Color.WHITE, new Color(0,102,255), new Color(0,51,255)));
        
        principal.add(scroll);
        principal.revalidate();
        principal.repaint();
    }
    
    public void pintarPanelLeftFoot(JPanel principal, JPanel pnl, boolean visible){
        pnl.setVisible(visible);
        pnlLeftFoot.removeAll();
        pnlLeftFoot.add(pnl);
        pnlLeftFoot.validate();
        pnlLeftFoot.repaint();
    }
    
     public void llenarProductos(){
        oCategoriaCONTROL = new CategoriaCONTROL();
        oCategoriaCONTROL.setPaneles(pnlLeftHead, pnlLeftBoddy, pnlLeftFoot, pnlCenterHead, pnlCenterBoddy, pnlCenterFoot, pnlRightHead, pnlRightBoddy, pnlRightFoot);
        oCategoriaCONTROL.setFrame(this);
        
        pintarPanelHead(pnlLeftHead,oCategoriaCONTROL.getLeftHead());
        pintarLeftBoddy(pnlLeftBoddy,oCategoriaCONTROL.getLeftBoddy(),oCategoriaCONTROL.getTamañoLista());
        pintarPanelLeftFoot(pnlLeftFoot, oCategoriaCONTROL.getLeftFoot(), true);
    }
    
    public void llenarUsuarios(){
        oTipoUsuariosCONTROL = new TipoUsuarioCONTROL();
        oTipoUsuariosCONTROL.setPaneles(pnlLeftHead, pnlLeftBoddy, pnlLeftFoot, pnlCenterHead, pnlCenterBoddy, pnlCenterFoot, pnlRightHead, pnlRightBoddy, pnlRightFoot);
        oTipoUsuariosCONTROL.setFrame(this);
        
        pintarPanelHead(pnlLeftHead,oTipoUsuariosCONTROL.getLeftHead());
        pintarLeftBoddy(pnlLeftBoddy,oTipoUsuariosCONTROL.getLeftBoddy(),oTipoUsuariosCONTROL.getTamañoLista());
        pintarPanelLeftFoot(pnlLeftFoot, oTipoUsuariosCONTROL.getLeftFoot(), true);
    }
    
    public static void HabilitarContenedor(Container container, Boolean activado) {
        Component[] components = container.getComponents();

        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextField) {
                ((JTextField) components[i]).setEnabled(activado);
            } else if (components[i] instanceof JTextArea) {
                ((JTextArea) components[i]).setEnabled(activado);
            } else if (components[i] instanceof JButton) {
                ((JButton) components[i]).setEnabled(activado);
            } else if (components[i] instanceof JComboBox) {
                ((JComboBox) components[i]).setEnabled(activado);
            } else if (components[i] instanceof JRadioButton) {
                ((JRadioButton) components[i]).setEnabled(activado);
            } else if (components[i] instanceof JCheckBox) {
                ((JCheckBox) components[i]).setEnabled(activado);
            } else if (components[i] instanceof JSpinner) {
                ((JSpinner) components[i]).setEnabled(activado);
            } else if (components[i] instanceof Container) {
                HabilitarContenedor((Container) components[i], activado);
            } else if (components[i] instanceof JLabel) {
                ((JLabel) components[i]).setEnabled(activado);
            }
        }
    }

    private void lenarCabeceras() {
        PnlHead p1 = new PnlHead("LEFT", false);
        PnlHead p2 = new PnlHead("BODDY", false);
        PnlHead p3 = new PnlHead("RIGHT", false);
        
        p1.setSize(264, 30);
        p1.setLocation(0, 0);
        
        p2.setSize(600, 30);
        p2.setLocation(0, 0);
        
        p3.setSize(300, 30);
        p3.setLocation(0, 0);
        
        pintarPanelHead(pnlLeftHead,p1);
        pintarPanelHead(pnlCenterHead,p2);
        pintarPanelHead(pnlRightHead,p3);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLblCerrar;
    private javax.swing.JLabel JlblProductos;
    private javax.swing.JPanel PnalPrincipal;
    private javax.swing.JPanel PnlCabecera;
    private javax.swing.JPanel PnlCenter;
    private javax.swing.JPanel PnlCerrar;
    private javax.swing.JPanel PnlHome;
    private javax.swing.JPanel PnlLeft;
    private javax.swing.JPanel PnlMinimizar;
    private javax.swing.JPanel PnlOpciones;
    private javax.swing.JPanel PnlProductos;
    private javax.swing.JPanel PnlRight;
    private javax.swing.JPanel PnlSession;
    private javax.swing.JPanel PnlUsuarios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblMenuUsuarios;
    private javax.swing.JPanel pnlBG;
    private javax.swing.JPanel pnlCenterBoddy;
    private javax.swing.JPanel pnlCenterFoot;
    private javax.swing.JPanel pnlCenterHead;
    private javax.swing.JPanel pnlLeftBoddy;
    private javax.swing.JPanel pnlLeftFoot;
    private javax.swing.JPanel pnlLeftHead;
    private javax.swing.JPanel pnlMantenimiento;
    private javax.swing.JPanel pnlRightBoddy;
    private javax.swing.JPanel pnlRightFoot;
    private javax.swing.JPanel pnlRightHead;
    // End of variables declaration//GEN-END:variables


}
