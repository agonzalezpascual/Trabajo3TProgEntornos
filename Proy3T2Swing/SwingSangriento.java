package nombrepaquete;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SwingSangriento {

    private JFrame frmBancoDeSangre;
    private JScrollPane juanmita;
    private JScrollPane manuelito;
    private JScrollPane salvita;
    private JTextField txtFechaNac;
    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTable tblDonantes;
    private JTextField txtDniDonante;
    private JTable tblDonaciones;
    private JTable tblPuedeDonarRecibir;
    private JTextField txtCodPostal;
    private JTextField txtLocalidad;
    private JTextField txtMail;

    protected ActionListener listenerBotonInsertar;
    protected ActionListener listenerBotonModificar;
    protected ActionListener listenerBotonEliminar;
    protected ActionListener listenerBotonConsultar;
    protected ActionListener listenerBotonAveriguar;
    protected ActionListener listenerBotonConsultarDonaciones;

    protected JLabel lblSetNombreDonante;
    protected JLabel lblSetTipoSangre;

    Funcionalidad funcionalidad;
    ManejarFichero manejarFicheros;
    Donaciones datosDonaciones;

    public JLabel getLblSetNombreDonante() {
        return lblSetNombreDonante;
    }

    public JLabel getLblSetTipoSangre() {
        return lblSetTipoSangre;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LeSwingSangriento window = new LeSwingSangriento();
                    window.frmBancoDeSangre.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void luisitoLimpiaTablas(JTable xTabla) {
        Boolean boolFalse = false;
        for (int i = 0; i < xTabla.getRowCount(); i++) {
            for (int juanmilla = 0; juanmilla < xTabla.getColumnCount(); juanmilla++) {
                xTabla.setValueAt("", i, juanmilla);
            }
        }
    }

    /**
     * Create the application.
     */
    public LeSwingSangriento() {
        funcionalidad = new Funcionalidad();
        manejarFicheros = new ManejarFichero();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmBancoDeSangre = new JFrame();
        frmBancoDeSangre.setTitle("Banco de sangre");
        frmBancoDeSangre.setBounds(100, 100, 1033, 732);
        frmBancoDeSangre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBancoDeSangre.getContentPane().setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 11, 1017, 682);
        frmBancoDeSangre.getContentPane().add(tabbedPane);

        JPanel panelDonantes = new JPanel();
        panelDonantes.setName("");
        tabbedPane.addTab("Donantes", null, panelDonantes, "Accede a la pesta\u00F1a Donantes");
        panelDonantes.setLayout(null);

        JButton btnConsultarDni = new JButton("Consultar DNI");
        btnConsultarDni.setBounds(125, 593, 115, 30);
        panelDonantes.add(btnConsultarDni);

        JLabel lblDni = new JLabel("DNI");
        lblDni.setBounds(163, 89, 98, 14);
        panelDonantes.add(lblDni);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(163, 127, 98, 14);
        panelDonantes.add(lblNombre);

        JLabel lblDireccion = new JLabel("Direcci\u00F3n");
        lblDireccion.setBounds(163, 165, 98, 14);
        panelDonantes.add(lblDireccion);

        JLabel lblTelefono = new JLabel("Tel\u00E9fono");
        lblTelefono.setBounds(530, 165, 98, 14);
        panelDonantes.add(lblTelefono);

        JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
        lblFechaNac.setBounds(530, 89, 150, 14);
        panelDonantes.add(lblFechaNac);

        txtFechaNac = new JTextField();
        TextPrompt placeholderFechaNac = new TextPrompt("aaaa-mm-dd", txtFechaNac);
        placeholderFechaNac.changeAlpha(0.75f);
        placeholderFechaNac.changeStyle(Font.ITALIC);
        txtFechaNac.setToolTipText("aaaa-mm-dd");
        txtFechaNac.setBounds(690, 84, 166, 25);
        panelDonantes.add(txtFechaNac);
        txtFechaNac.setColumns(10);

        txtDni = new JTextField();
        TextPrompt placeholderDNI = new TextPrompt("12345678X", txtDni);
        placeholderDNI.changeAlpha(0.75f);
        placeholderDNI.changeStyle(Font.ITALIC);
        txtDni.setToolTipText("Formato: 12345678X");
        txtDni.setBounds(271, 84, 166, 25);
        panelDonantes.add(txtDni);
        txtDni.setColumns(10);

        txtNombre = new JTextField();
        txtNombre.setToolTipText("Introduzca el mombre y apellidos");
        txtNombre.setColumns(10);
        txtNombre.setBounds(271, 122, 166, 25);
        panelDonantes.add(txtNombre);

        txtDireccion = new JTextField();
        txtDireccion.setToolTipText("Introduzca la dirección");
        txtDireccion.setColumns(10);
        txtDireccion.setBounds(271, 160, 166, 25);
        panelDonantes.add(txtDireccion);

        txtTelefono = new JTextField();
        TextPrompt placeholderTelf = new TextPrompt("123456789", txtTelefono);
        placeholderTelf.changeAlpha(0.75f);
        placeholderTelf.changeStyle(Font.ITALIC);
        txtTelefono.setToolTipText("Formato: 123456789");
        txtTelefono.setColumns(10);
        txtTelefono.setBounds(690, 160, 166, 25);
        panelDonantes.add(txtTelefono);

        JLabel lblGrupoSanguineo = new JLabel("Grupo Sangu\u00EDneo");
        lblGrupoSanguineo.setBounds(530, 203, 106, 14);
        panelDonantes.add(lblGrupoSanguineo);

        JLabel lblFactorRH = new JLabel("Factor RH");
        lblFactorRH.setBounds(530, 241, 89, 14);
        panelDonantes.add(lblFactorRH);

        JComboBox cbxGrupoSanguineo = new JComboBox();
        cbxGrupoSanguineo.setModel(new DefaultComboBoxModel(new String[]{"0", "A", "B", "AB"}));
        cbxGrupoSanguineo.setMaximumRowCount(4);
        cbxGrupoSanguineo.setBounds(690, 198, 166, 25);
        panelDonantes.add(cbxGrupoSanguineo);

        JComboBox cbxFactorRH = new JComboBox();
        cbxFactorRH.setModel(new DefaultComboBoxModel(new String[]{"-", "+"}));
        cbxFactorRH.setMaximumRowCount(2);
        cbxFactorRH.setBounds(690, 236, 166, 25);
        panelDonantes.add(cbxFactorRH);

        tblDonantes = new JTable();
        manuelito = new JScrollPane(tblDonantes);
        manuelito.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblDonantes.setDefaultRenderer(Object.class, centerRenderer);
        tblDonantes.setDefaultRenderer(Float.class, centerRenderer);
        tblDonantes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tblDonantes.setFillsViewportHeight(true);
        tblDonantes.getTableHeader().setReorderingAllowed(false);
        tblDonantes.getTableHeader().setResizingAllowed(false);
        tblDonantes.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        tblDonantes.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "<html><b>DNI</b></html>", "<html><b>Nombre</b></html>", "<html><b>Dirección</b></html>", "<html><b>C.P</b></html>", "<html><b>Localidad</b></html>", "<html><b>Fecha Nac</b></html>", "<html><b>E-Mail</b></html>", "<html><b>Teléfono</b></html>", "<html><b>Grupo Sang</b></html>", "<html><b>Factor RH</b></html>"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        tblDonantes.getColumnModel().getColumn(0).setMinWidth(75);
        tblDonantes.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblDonantes.getColumnModel().getColumn(1).setMinWidth(100);
        tblDonantes.getColumnModel().getColumn(2).setPreferredWidth(115);
        tblDonantes.getColumnModel().getColumn(2).setMinWidth(115);
        tblDonantes.getColumnModel().getColumn(3).setMinWidth(75);
        tblDonantes.getColumnModel().getColumn(3).setPreferredWidth(115);
        tblDonantes.getColumnModel().getColumn(4).setMinWidth(115);
        tblDonantes.getColumnModel().getColumn(4).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(5).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(5).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(6).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(6).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(7).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(7).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(8).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(8).setPreferredWidth(107);
        tblDonantes.getColumnModel().getColumn(9).setPreferredWidth(107);

        tblDonantes.setBounds(32, 311, 948, 247);
        manuelito.setBounds(32, 311, 948, 247);

        panelDonantes.add(manuelito);

        JButton btnConsultarTodos = new JButton("Consultar todos");
        btnConsultarTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnConsultarTodos.setBounds(279, 593, 150, 30);
        panelDonantes.add(btnConsultarTodos);

        JButton btnInsertar = new JButton("Insertar");
        btnInsertar.setBounds(469, 593, 115, 30);
        panelDonantes.add(btnInsertar);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(623, 593, 115, 30);
        panelDonantes.add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(777, 593, 115, 30);
        panelDonantes.add(btnEliminar);

        JLabel lblTituloDonantes = new JLabel("GESTI\u00D3N BANCO DE SANGRE");
        lblTituloDonantes.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTituloDonantes.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloDonantes.setBounds(10, 11, 992, 62);
        panelDonantes.add(lblTituloDonantes);

        JLabel lblCodPostal = new JLabel("C.P.");
        lblCodPostal.setBounds(163, 203, 98, 14);
        panelDonantes.add(lblCodPostal);

        txtCodPostal = new JTextField();
        TextPrompt placeholderCP = new TextPrompt("12345", txtCodPostal);
        placeholderCP.changeAlpha(0.75f);
        placeholderCP.changeStyle(Font.ITALIC);
        txtCodPostal.setToolTipText("Formato: 12345");
        txtCodPostal.setColumns(10);
        txtCodPostal.setBounds(271, 198, 166, 25);
        panelDonantes.add(txtCodPostal);

        JLabel lblLocalidad = new JLabel("Localidad");
        lblLocalidad.setBounds(163, 241, 98, 14);
        panelDonantes.add(lblLocalidad);

        txtLocalidad = new JTextField();
        txtLocalidad.setToolTipText("Introduzca la localidad");
        txtLocalidad.setColumns(10);
        txtLocalidad.setBounds(271, 236, 166, 25);
        panelDonantes.add(txtLocalidad);

        JLabel lblEmail = new JLabel("E-Mail");
        lblEmail.setBounds(530, 127, 129, 14);
        panelDonantes.add(lblEmail);

        txtMail = new JTextField();
        TextPrompt placeholderMail= new TextPrompt("nombre@organizacion.tipo", txtMail);
        placeholderMail.changeAlpha(0.75f);
        placeholderMail.changeStyle(Font.ITALIC);
        txtMail.setToolTipText("Formato: nombre@organizacion.tipo");
        txtMail.setColumns(10);
        txtMail.setBounds(690, 122, 166, 25);
        panelDonantes.add(txtMail);

        JPanel panelDonaciones = new JPanel();
        tabbedPane.addTab("Donaciones", null, panelDonaciones, "Accede a la pesta\u00F1a Donaciones");
        panelDonaciones.setLayout(null);

        JLabel lblDniDonante = new JLabel("DNI Donante");
        lblDniDonante.setBounds(117, 106, 70, 14);
        panelDonaciones.add(lblDniDonante);

        txtDniDonante = new JTextField();
        TextPrompt placeholderWapo = new TextPrompt("12345678X", txtDniDonante);
        placeholderWapo.changeAlpha(0.75f);
        placeholderWapo.changeStyle(Font.ITALIC);
        txtDniDonante.setToolTipText("Formato: 12345678X");
        txtDniDonante.setBounds(215, 101, 166, 25);
        panelDonaciones.add(txtDniDonante);
        txtDniDonante.setColumns(10);

        JButton btnConsultarDonaciones = new JButton("Consultar donaciones");
        btnConsultarDonaciones.setBounds(158, 152, 166, 30);
        panelDonaciones.add(btnConsultarDonaciones);

        JLabel lblNombreDonante = new JLabel("Nombre Donante:");
        lblNombreDonante.setBounds(492, 106, 122, 14);
        panelDonaciones.add(lblNombreDonante);

        lblSetNombreDonante = new JLabel("");
        lblSetNombreDonante.setHorizontalAlignment(SwingConstants.LEFT);
        lblSetNombreDonante.setBounds(624, 106, 265, 14);
        panelDonaciones.add(lblSetNombreDonante);

        JLabel lblTipoSangre = new JLabel("Tipo de sangre:");
        lblTipoSangre.setBounds(492, 160, 122, 14);
        panelDonaciones.add(lblTipoSangre);

        lblSetTipoSangre = new JLabel("");
        lblSetTipoSangre.setBounds(624, 160, 265, 14);
        panelDonaciones.add(lblSetTipoSangre);

        tblDonaciones = new JTable();
        juanmita = new JScrollPane(tblDonaciones);

        juanmita.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        tblDonaciones.setDefaultRenderer(Object.class, centerRenderer);
        tblDonaciones.setDefaultRenderer(Float.class, centerRenderer);
        tblDonaciones.setName("");
        tblDonaciones.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        tblDonaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tblDonaciones.setDefaultRenderer(Object.class, centerRenderer);
        tblDonaciones.setFillsViewportHeight(true);
        tblDonaciones.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "<html><b>C\u00F3d. Sanitario<b><html>", "<html><b>Nombre Sanitario<b><html>", "<html><b>Fecha<b><html>", "<html><b>Cantidad (ml)<b><html>", "<html><b>Incidencia<b><html>"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Object.class, Object.class, String.class, Float.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        tblDonaciones.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblDonaciones.getColumnModel().getColumn(0).setMinWidth(100);
        tblDonaciones.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblDonaciones.getColumnModel().getColumn(1).setMinWidth(150);
        tblDonaciones.getColumnModel().getColumn(2).setPreferredWidth(115);
        tblDonaciones.getColumnModel().getColumn(2).setMinWidth(115);
        tblDonaciones.setBounds(20, 209, 970, 407);
        juanmita.setBounds(20, 209, 970, 407);
        panelDonaciones.add(juanmita);

        JLabel lblTituloDonaciones = new JLabel("GESTIÓN BANCO DE SANGRE");
        lblTituloDonaciones.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloDonaciones.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTituloDonaciones.setBounds(10, 11, 992, 62);
        panelDonaciones.add(lblTituloDonaciones);

        JPanel panelCompatibilidad = new JPanel();
        tabbedPane.addTab("Compatibilidad", null, panelCompatibilidad, "Accede a la pestaña Compatibilidad");
        panelCompatibilidad.setLayout(null);

        JLabel lblGrupoSanguineoComp = new JLabel("Grupo Sanguíneo");
        lblGrupoSanguineoComp.setBounds(105, 164, 168, 14);
        panelCompatibilidad.add(lblGrupoSanguineoComp);

        JComboBox cbxGrupoSanguineoComp = new JComboBox();
        cbxGrupoSanguineoComp.setModel(new DefaultComboBoxModel(new String[]{"0", "A", "B", "AB"}));
        cbxGrupoSanguineoComp.setMaximumRowCount(4);
        cbxGrupoSanguineoComp.setBounds(283, 159, 123, 25);
        panelCompatibilidad.add(cbxGrupoSanguineoComp);

        JLabel lblFactorRHcomp = new JLabel("Factor RH");
        lblFactorRHcomp.setBounds(105, 216, 168, 14);
        panelCompatibilidad.add(lblFactorRHcomp);

        JComboBox cbxFactorRHcomp = new JComboBox();
        cbxFactorRHcomp.setModel(new DefaultComboBoxModel(new String[]{"+", "-"}));
        cbxFactorRHcomp.setMaximumRowCount(2);
        cbxFactorRHcomp.setBounds(283, 211, 123, 25);
        panelCompatibilidad.add(cbxFactorRHcomp);

        JLabel lblTituloCompatibilidad = new JLabel("GESTIÓN BANCO DE SANGRE");
        lblTituloCompatibilidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCompatibilidad.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTituloCompatibilidad.setBounds(10, 25, 992, 62);
        panelCompatibilidad.add(lblTituloCompatibilidad);

        JButton btnAveriguarCompatibilidad = new JButton("Averiguar compatibilidad");
        btnAveriguarCompatibilidad.setBounds(136, 279, 211, 30);
        panelCompatibilidad.add(btnAveriguarCompatibilidad);

        tblPuedeDonarRecibir = new JTable();
        salvita = new JScrollPane(tblPuedeDonarRecibir);
        salvita.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        tblPuedeDonarRecibir.setDefaultRenderer(Object.class, centerRenderer);
        tblPuedeDonarRecibir.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        tblPuedeDonarRecibir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tblPuedeDonarRecibir.getTableHeader().setReorderingAllowed(false);
        tblPuedeDonarRecibir.getTableHeader().setResizingAllowed(false);
        tblPuedeDonarRecibir.setFillsViewportHeight(true);
        tblPuedeDonarRecibir.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblPuedeDonarRecibir.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[]{
                        "<html><b>Puede donar a</b></html>", "<html><b>Puede recibir de</b></html>"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Object.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[]{
                    false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        tblPuedeDonarRecibir.getColumnModel().getColumn(0).setPreferredWidth(115);
        tblPuedeDonarRecibir.getColumnModel().getColumn(0).setMinWidth(115);
        tblPuedeDonarRecibir.getColumnModel().getColumn(1).setPreferredWidth(113);
        tblPuedeDonarRecibir.getColumnModel().getColumn(1).setMinWidth(113);
        tblPuedeDonarRecibir.setBounds(525, 159, 439, 151);
        salvita.setBounds(525, 159, 439, 151);
        panelCompatibilidad.add(salvita);

        JLabel lblLogoDonantes = new JLabel("");
        lblLogoDonantes.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogoDonantes.setIcon(new ImageIcon("src/logoSwing.png"));
        lblLogoDonantes.setBounds(203, 0, 652, 750);
        panelDonantes.add(lblLogoDonantes);

        JLabel lblLogoDonaciones = new JLabel("");
        lblLogoDonaciones.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogoDonaciones.setIcon(new ImageIcon("src/logoSwing.png"));
        lblLogoDonaciones.setBounds(203, 0, 652, 750);
        panelDonaciones.add(lblLogoDonaciones);

        JLabel lblLogoCompatibilidad = new JLabel("");
        lblLogoCompatibilidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogoCompatibilidad.setIcon(new ImageIcon("src/logoSwing.png"));
        lblLogoCompatibilidad.setBounds(203, 0, 652, 750);
        panelCompatibilidad.add(lblLogoCompatibilidad);

        // Botones:

        listenerBotonInsertar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = txtDni.getText();
                String nomDonante = txtNombre.getText();
                String direccionDonante = txtDireccion.getText();
                String codPostal = txtCodPostal.getText();
                String localidad = txtLocalidad.getText();
                String telefono = txtTelefono.getText();
                String fechaNac = txtFechaNac.getText();
                String mail = txtMail.getText();
                String grupoSang = cbxGrupoSanguineo.getSelectedItem().toString();
                String factorRH = cbxFactorRH.getSelectedItem().toString();
                System.out.println(factorRH);

                if (e.getSource() == btnInsertar) {
                    boolean a = funcionalidad.insertar("INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('" + dni + "', '" + nomDonante + "', '" + direccionDonante + "', '" + codPostal + "', '" + localidad + "', '" + fechaNac + "', '" + mail + "', '" + telefono + "', '" + grupoSang + "', '" + factorRH + "')");
                    if (a) {
                        txtDni.setText("");
                        txtNombre.setText("");
                        txtDireccion.setText("");
                        txtCodPostal.setText("");
                        txtLocalidad.setText("");
                        txtTelefono.setText("");
                        txtFechaNac.setText("");
                        txtMail.setText("");
                        cbxGrupoSanguineo.setSelectedIndex(0);
                        cbxFactorRH.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valores introducidos erróneos", "Insertar registro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        };
        btnInsertar.addActionListener(listenerBotonInsertar);


        listenerBotonModificar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = txtDni.getText();
                String nomDonante = txtNombre.getText();
                String direccionDonante = txtDireccion.getText();
                String codPostal = txtCodPostal.getText();
                String localidad = txtLocalidad.getText();
                String telefono = txtTelefono.getText();
                String fechaNac = txtFechaNac.getText();
                String mail = txtMail.getText();
                String grupoSang = cbxGrupoSanguineo.getSelectedItem().toString();
                String factorRH = cbxFactorRH.getSelectedItem().toString();

                if (e.getSource() == btnModificar) {
                    boolean a = funcionalidad.insertar("UPDATE DONANTES SET Nombre ='" + nomDonante + "', Direccion ='" + direccionDonante + "', CodPostal ='" + codPostal + "', Localidad = '" + localidad + "', FechaNac = '" + fechaNac + "', Correo ='" + mail + "', Telefono ='" + telefono + "', GrupoSang ='" + grupoSang + "', FactorRH ='" + factorRH + "' WHERE DNI = '" + dni + "'");
                    if (a) {
                        txtDni.setText("");
                        txtNombre.setText("");
                        txtDireccion.setText("");
                        txtCodPostal.setText("");
                        txtLocalidad.setText("");
                        txtTelefono.setText("");
                        txtFechaNac.setText("");
                        txtMail.setText("");
                        cbxGrupoSanguineo.setSelectedIndex(0);
                        cbxFactorRH.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valores introducidos erróneos", "Modificar registro", JOptionPane.INFORMATION_MESSAGE);
                    }
                } 
            }
        }; 
        btnModificar.addActionListener(listenerBotonModificar);

        listenerBotonEliminar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = txtDni.getText();

                if (e.getSource() == btnEliminar) {
                    boolean a = funcionalidad.insertar("DELETE FROM DONANTES WHERE DNI = '" + dni + "'");
                    if (a) {
                        txtDni.setText("");
                        txtNombre.setText("");
                        txtDireccion.setText("");
                        txtCodPostal.setText("");
                        txtLocalidad.setText("");
                        txtTelefono.setText("");
                        txtFechaNac.setText("");
                        txtMail.setText("");
                        cbxGrupoSanguineo.setSelectedIndex(0);
                        cbxFactorRH.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valores introducidos erróneos", "Eliminar registro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        };
        btnEliminar.addActionListener(listenerBotonEliminar);

        listenerBotonConsultar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResultSet sql;
                String dni = txtDni.getText();
                String nomDonante = "";
                String direccionDonante = "";
                String codPostal = "";
                String localidad = "";
                String telefono = "";
                String fechaNac = "";
                String mail = "";
                String grupoSang = "";
                String factorRH = "";

                if (e.getSource() == btnConsultarTodos) {
                    sql = funcionalidad.consulta("SELECT * FROM DONANTES");
                    try {
                        luisitoLimpiaTablas(tblDonantes);
                        int i = 0;
                        while (sql.next()) {
                            tblDonantes.setValueAt(sql.getString(1), i, 0);
                            tblDonantes.setValueAt(sql.getString(2), i, 1);
                            tblDonantes.setValueAt(sql.getString(3), i, 2);
                            tblDonantes.setValueAt(sql.getString(4), i, 3);
                            tblDonantes.setValueAt(sql.getString(5), i, 4);
                            tblDonantes.setValueAt(sql.getString(6), i, 5);
                            tblDonantes.setValueAt(sql.getString(7), i, 6);
                            tblDonantes.setValueAt(sql.getString(8), i, 7);
                            tblDonantes.setValueAt(sql.getString(9), i, 8);
                            tblDonantes.setValueAt(sql.getString(10), i, 9);
                            i++;
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

                if (e.getSource() == btnConsultarDni) {
                    sql = funcionalidad.consulta("SELECT * FROM DONANTES WHERE DNI = '" + dni + "'");
                    try {
                        luisitoLimpiaTablas(tblDonantes);
                        if (sql.next()) {
                            nomDonante = sql.getString("Nombre");
                            direccionDonante = sql.getString("Direccion");
                            codPostal = sql.getString("CodPostal");
                            localidad = sql.getString("Localidad");
                            fechaNac = sql.getString("FechaNac");
                            mail = sql.getString("Correo");
                            telefono = sql.getString("Telefono");
                            grupoSang = sql.getString("GrupoSang");
                            factorRH = sql.getString("FactorRH");

                            tblDonantes.setValueAt(dni, 0, 0);
                            tblDonantes.setValueAt(nomDonante, 0, 1);
                            tblDonantes.setValueAt(direccionDonante, 0, 2);
                            tblDonantes.setValueAt(codPostal, 0, 3);
                            tblDonantes.setValueAt(localidad, 0, 4);
                            tblDonantes.setValueAt(fechaNac, 0, 5);
                            tblDonantes.setValueAt(mail, 0, 6);
                            tblDonantes.setValueAt(telefono, 0, 7);
                            tblDonantes.setValueAt(grupoSang, 0, 8);
                            tblDonantes.setValueAt(factorRH, 0, 9);

                        } else {
                            JOptionPane.showMessageDialog(null, "Valores introducidos erróneos", "Consultar DNI", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception i) {
                        System.out.println(i.getMessage());
                    }
                }
            }
        };
        btnConsultarTodos.addActionListener(listenerBotonConsultar);
        btnConsultarDni.addActionListener(listenerBotonConsultar);

        listenerBotonAveriguar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<String> puedeDonarA = new ArrayList();
                ArrayList<String> puedeRecibirDe = new ArrayList();

                puedeDonarA.clear();
                puedeRecibirDe.clear();
                luisitoLimpiaTablas(tblPuedeDonarRecibir);

                if (e.getSource() == btnAveriguarCompatibilidad) {
                    if (cbxFactorRHcomp.getSelectedItem().equals("+")) {
                        switch ((String) cbxGrupoSanguineoComp.getSelectedItem()) {
                            case "0":
                                puedeDonarA.add("0+");
                                puedeDonarA.add("A+");
                                puedeDonarA.add("B+");
                                puedeDonarA.add("AB+");
                                puedeRecibirDe.add("0-");
                                puedeRecibirDe.add("0+");
                                break;
                            case "A":
                                puedeDonarA.add("A+");
                                puedeDonarA.add("AB+");
                                puedeRecibirDe.add("0-");
                                puedeRecibirDe.add("0+");
                                puedeRecibirDe.add("A-");
                                puedeRecibirDe.add("A+");
                                break;
                            case "B":
                                puedeDonarA.add("B+");
                                puedeDonarA.add("AB+");
                                puedeRecibirDe.add("0-");
                                puedeRecibirDe.add("0+");
                                puedeRecibirDe.add("B-");
                                puedeRecibirDe.add("B+");
                                break;
                            case "AB":
                                puedeDonarA.add("AB+");
                                puedeRecibirDe.add("0-");
                                puedeRecibirDe.add("0+");
                                puedeRecibirDe.add("A-");
                                puedeRecibirDe.add("A+");
                                puedeRecibirDe.add("B-");
                                puedeRecibirDe.add("B+");
                                puedeRecibirDe.add("AB-");
                                puedeRecibirDe.add("AB+");
                                break;
                        }
                    } else {
                        switch ((String) cbxGrupoSanguineoComp.getSelectedItem()) {
                            case "0":
                                puedeRecibirDe.add("0-");
                                puedeDonarA.add("0-");
                                puedeDonarA.add("0+");
                                puedeDonarA.add("A-");
                                puedeDonarA.add("A+");
                                puedeDonarA.add("B-");
                                puedeDonarA.add("B+");
                                puedeDonarA.add("AB-");
                                puedeDonarA.add("AB+");
                                break;
                            case "A":
                                puedeDonarA.add("A-");
                                puedeDonarA.add("A+");
                                puedeDonarA.add("AB-");
                                puedeDonarA.add("AB+");
                                puedeRecibirDe.add("0-");
                                puedeRecibirDe.add("A-");
                                break;
                            case "B":
                                puedeDonarA.add("B-");
                                puedeDonarA.add("B+");
                                puedeDonarA.add("AB-");
                                puedeDonarA.add("AB+");
                                puedeRecibirDe.add("0-");
                                puedeRecibirDe.add("B-");
                                break;
                            case "AB":
                                puedeDonarA.add("AB-");
                                puedeDonarA.add("AB+");
                                puedeRecibirDe.add("0-");
                                puedeRecibirDe.add("A-");
                                puedeRecibirDe.add("B-");
                                puedeRecibirDe.add("AB-");
                                break;
                        }
                    }

                    for (int i = 0; i < puedeDonarA.size(); i++) {
                        tblPuedeDonarRecibir.setValueAt(puedeDonarA.get(i), i, 0);
                    }

                    for (int i = 0; i < puedeRecibirDe.size(); i++) {
                        tblPuedeDonarRecibir.setValueAt(puedeRecibirDe.get(i), i, 1);
                    }
                }
            }
        };
        btnAveriguarCompatibilidad.addActionListener(listenerBotonAveriguar);

        listenerBotonConsultarDonaciones = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String dni = txtDniDonante.getText();

                if (e.getSource() == btnConsultarDonaciones) {
                    luisitoLimpiaTablas(tblDonaciones);

                    manejarFicheros.leerDatosDat(dni, tblDonaciones, lblSetNombreDonante, lblSetTipoSangre);
                    datosDonaciones = manejarFicheros.getDonaciones();
                }
            }
        };
        btnConsultarDonaciones.addActionListener(listenerBotonConsultarDonaciones);

        frmBancoDeSangre.setLocationRelativeTo(null);
    }
}
