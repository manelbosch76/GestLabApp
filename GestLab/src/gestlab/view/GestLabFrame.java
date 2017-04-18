package gestlab.view;

import gestlab.model.Cliente;
import gestlab.model.Equipo;
import gestlab.model.HistorialEquipos;
import gestlab.model.HistorialProductos;
import gestlab.model.Producto;
import gestlab.model.Usuario;
import gestlab.restfulclient.ClienteClientSsl;
import gestlab.restfulclient.EquipoClientSsl;
import gestlab.restfulclient.HistorialEquiposClientSsl;
import gestlab.restfulclient.HistorialProductosClientSsl;
import gestlab.restfulclient.ProductoClientSsl;
import gestlab.utils.tables.TableCreator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.GenericType;

/**
 * Classe que gestiona la finestra principal del programa
 * @author manel bosch
 */
public class GestLabFrame extends javax.swing.JFrame {
    
    private final Usuario usuario;
    private final String token;
    
    private ClienteClientSsl cClient;
    private ProductoClientSsl pClient;
    private EquipoClientSsl eqClient;
    private HistorialProductosClientSsl hpClient;
    private HistorialEquiposClientSsl heClient;
    
    Cliente cliente;
    private List<Cliente> clientes;
    GenericType<List<Cliente>> gTypeClient = new GenericType<List<Cliente>>(){};
    
    private List<Producto> productos;
    GenericType<List<Producto>> gTypeProduct = new GenericType<List<Producto>>(){};
    private List<HistorialProductos> hProductos;
    GenericType<List<HistorialProductos>> gTypeHistorialProduct = new GenericType<List<HistorialProductos>>(){};
    
    private List<Equipo> equipos;
    GenericType<List<Equipo>> gTypeEquip = new GenericType<List<Equipo>>(){};
    private List<HistorialEquipos> hEquipos;
    GenericType<List<HistorialEquipos>> gTypeHistorialEquip = new GenericType<List<HistorialEquipos>>(){};
    
    private final Date date = new Date(Calendar.getInstance().getTimeInMillis());//Data del dia actual
    Date today = java.sql.Date.valueOf(date.toString());//Data del dia actual amb concepte temps a 0
    
    private TableRowSorter<TableModel> rowSorter;
    TableCreator tableCreator = new TableCreator();

    /**
     * Crea un nou frame GestLabFrame
     * @author manel bosch
     * @param u Usuari que accedeix al programa
     */
    public GestLabFrame(Usuario u) {
        this.usuario = u;
        this.token = u.getToken();

        initComponents();
        
        jButtonCancelModifProfile.setVisible(false);
        //Si l'usuari no és administrador s'amaguen alguns botons i pestanya Usuaris
        if(!usuario.getAdministrador()){
            hideButtons();
        }
        fillProfile();
        jTabbedPaneMain.addChangeListener(changeListener);
    }
    
    /**
     * Mètode per obrir la connexió al servei Cliente
     * @author manel bosch
     */
    private void openClienteClient(){
        cClient = new ClienteClientSsl(token);
    }
    
    /**
     * Mètode per obrir la connexió al servei Producto
     * @author manel bosch
     */
    private void openProductoClient(){
        pClient = new ProductoClientSsl(token);
    }
    
    /**
     * Mètode per obrir la connexió al servei HistorialProductos
     * @author manel bosch
     */
    private void openHistorialProductosClient(){
        hpClient = new HistorialProductosClientSsl(token);
    }
    
    /**
     * Mètode per obrir la connexió al servei Equipo
     * @author manel bosch
     */
    private void openEquipoClient(){
        eqClient = new EquipoClientSsl(token);
    }

     /**
     * Mètode per obrir la connexió al servei Historial Equipos
     * @author manel bosch
     */
    private void openHistorialEquiposClient(){
        heClient = new HistorialEquiposClientSsl(token);
    }
    
    /**
     * Mètode per amagar els botons i el panell d'usuaris en cas de no ser un usuari administrador
     * @author manel bosch
     */
    private void hideButtons(){
        jTabbedPaneMain.remove(jPanelUsuaris);
        jButtonNewProduct.setVisible(false);
        jButtonModifProduct.setVisible(false);
        jButtonDelProduct.setVisible(false);
        jButtonNewEquip.setVisible(false);
        jButtonModifEquip.setVisible(false);
        jButtonDelEquip.setVisible(false);
    }
    
    //Listener per controlar els canvis de pestanya de la finestra del programa
    ChangeListener changeListener = (ChangeEvent changeEvent) -> {
        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        switch (sourceTabbedPane.getTitleAt(index)) {
            case "Clients":
                fillClientsList();
                break;
            case "Productes":
                fillProductsList();
                break;
            case "Equipament":
                fillEquipsList();
                break;
            case "Perfil":
                fillProfile();
                break;
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jTabbedPaneMain = new javax.swing.JTabbedPane();
        jPanelPerfil = new javax.swing.JPanel();
        jPanelDadesPersonals = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jLabelCognom1 = new javax.swing.JLabel();
        jTextFieldCognom1 = new javax.swing.JTextField();
        jLabelCognom2 = new javax.swing.JLabel();
        jTextFieldCognom2 = new javax.swing.JTextField();
        jLabelDni = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();
        jLabelTelf = new javax.swing.JLabel();
        jTextFieldTelf = new javax.swing.JTextField();
        jButtonModifProfile = new javax.swing.JButton();
        jButtonChangePasswd = new javax.swing.JButton();
        jButtonCancelModifProfile = new javax.swing.JButton();
        jPanelUsuaris = new javax.swing.JPanel();
        jScrollPaneUsers = new javax.swing.JScrollPane();
        jTableClients = new javax.swing.JTable();
        jPanelAdminUser = new javax.swing.JPanel();
        jButtonNewClient = new javax.swing.JButton();
        jButtonModifClient = new javax.swing.JButton();
        jButtonDelClient = new javax.swing.JButton();
        jPanelUserSearch = new javax.swing.JPanel();
        jTextFieldSurname = new javax.swing.JTextField();
        jTextFieldClientId = new javax.swing.JTextField();
        jButtonClientId = new javax.swing.JButton();
        jButtonSearchSurname = new javax.swing.JButton();
        jPanelProductes = new javax.swing.JPanel();
        jPanelAdminProducts = new javax.swing.JPanel();
        jButtonNewProduct = new javax.swing.JButton();
        jButtonModifProduct = new javax.swing.JButton();
        jButtonDelProduct = new javax.swing.JButton();
        jScrollPaneProducts = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jPanelProductSearch = new javax.swing.JPanel();
        jTextFieldProduct = new javax.swing.JTextField();
        jTextFieldProductId = new javax.swing.JTextField();
        jButtonProductId = new javax.swing.JButton();
        jButtonSearchProductName = new javax.swing.JButton();
        jPanelProductGlobal = new javax.swing.JPanel();
        jButtonProductsUsed = new javax.swing.JButton();
        jButtonProductsAvailable = new javax.swing.JButton();
        jButtonBuyProduct = new javax.swing.JButton();
        jPanelEquips = new javax.swing.JPanel();
        jPanelEquipSearch = new javax.swing.JPanel();
        jTextFieldEquip = new javax.swing.JTextField();
        jTextFieldEquipId = new javax.swing.JTextField();
        jButtonEquipId = new javax.swing.JButton();
        jButtonSearchEquipName = new javax.swing.JButton();
        jPanelAdminEquips = new javax.swing.JPanel();
        jButtonNewEquip = new javax.swing.JButton();
        jButtonModifEquip = new javax.swing.JButton();
        jButtonDelEquip = new javax.swing.JButton();
        jScrollPaneEquips = new javax.swing.JScrollPane();
        jTableEquips = new javax.swing.JTable();
        jPanelProductBotons1 = new javax.swing.JPanel();
        jButtonEquipsUsed = new javax.swing.JButton();
        jButtonAllEquips = new javax.swing.JButton();
        jButtonBook = new javax.swing.JButton();
        jButtonDelbooking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("GestLab");

        jTabbedPaneMain.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabelName.setText("Nom:");

        jTextFieldNom.setEditable(false);

        jLabelCognom1.setText("Primer cognom:");

        jTextFieldCognom1.setEditable(false);

        jLabelCognom2.setText("Segon cognom:");

        jTextFieldCognom2.setEditable(false);

        jLabelDni.setText("DNI:");

        jTextFieldDni.setEditable(false);

        jLabelMail.setText("email:");

        jTextFieldMail.setEditable(false);

        jLabelTelf.setText("Telèfon:");

        jTextFieldTelf.setEditable(false);

        javax.swing.GroupLayout jPanelDadesPersonalsLayout = new javax.swing.GroupLayout(jPanelDadesPersonals);
        jPanelDadesPersonals.setLayout(jPanelDadesPersonalsLayout);
        jPanelDadesPersonalsLayout.setHorizontalGroup(
            jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCognom1)
                    .addComponent(jLabelName)
                    .addComponent(jLabelCognom2)
                    .addComponent(jLabelDni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCognom2)
                    .addComponent(jTextFieldCognom1)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMail)
                    .addComponent(jLabelTelf))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanelDadesPersonalsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldMail, jTextFieldTelf});

        jPanelDadesPersonalsLayout.setVerticalGroup(
            jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                        .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDni)
                            .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMail))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelName)
                            .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTelf)))
                    .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                        .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCognom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCognom1))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCognom2)
                    .addComponent(jTextFieldCognom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonModifProfile.setText("Modificar dades");
        jButtonModifProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifProfileActionPerformed(evt);
            }
        });

        jButtonChangePasswd.setText("Canviar Contrassenya");
        jButtonChangePasswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangePasswdActionPerformed(evt);
            }
        });

        jButtonCancelModifProfile.setText("Cancelar");
        jButtonCancelModifProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelModifProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPerfilLayout = new javax.swing.GroupLayout(jPanelPerfil);
        jPanelPerfil.setLayout(jPanelPerfilLayout);
        jPanelPerfilLayout.setHorizontalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPerfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelDadesPersonals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPerfilLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonChangePasswd)
                            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                                .addComponent(jButtonModifProfile)
                                .addGap(141, 141, 141)
                                .addComponent(jButtonCancelModifProfile)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPerfilLayout.setVerticalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanelDadesPersonals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModifProfile)
                    .addComponent(jButtonCancelModifProfile))
                .addGap(18, 18, 18)
                .addComponent(jButtonChangePasswd)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPaneMain.addTab("Perfil", jPanelPerfil);

        jScrollPaneUsers.setBorder(javax.swing.BorderFactory.createTitledBorder("Llista Clients"));

        jTableClients.setAutoCreateRowSorter(true);
        jTableClients.setModel(tableCreator.createTableModel(Cliente.class, clientes));
        jScrollPaneUsers.setViewportView(jTableClients);

        jButtonNewClient.setText("Nou Client");
        jButtonNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewClientActionPerformed(evt);
            }
        });

        jButtonModifClient.setText("Modificar Client");
        jButtonModifClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifClientActionPerformed(evt);
            }
        });

        jButtonDelClient.setText("Eliminar Client");
        jButtonDelClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminUserLayout = new javax.swing.GroupLayout(jPanelAdminUser);
        jPanelAdminUser.setLayout(jPanelAdminUserLayout);
        jPanelAdminUserLayout.setHorizontalGroup(
            jPanelAdminUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAdminUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNewClient, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonModifClient, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonDelClient, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanelAdminUserLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonDelClient, jButtonModifClient, jButtonNewClient});

        jPanelAdminUserLayout.setVerticalGroup(
            jPanelAdminUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNewClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonModifClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldSurname.setText("Cognom");
        jTextFieldSurname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSurnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSurnameFocusLost(evt);
            }
        });

        jTextFieldClientId.setText("Id");
        jTextFieldClientId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldClientIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldClientIdFocusLost(evt);
            }
        });

        jButtonClientId.setText("Buscar");
        jButtonClientId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientIdActionPerformed(evt);
            }
        });

        jButtonSearchSurname.setText("Buscar");
        jButtonSearchSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchSurnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUserSearchLayout = new javax.swing.GroupLayout(jPanelUserSearch);
        jPanelUserSearch.setLayout(jPanelUserSearchLayout);
        jPanelUserSearchLayout.setHorizontalGroup(
            jPanelUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jTextFieldClientId))
                .addGap(18, 18, 18)
                .addGroup(jPanelUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSearchSurname)
                    .addComponent(jButtonClientId))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelUserSearchLayout.setVerticalGroup(
            jPanelUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchSurname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanelUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldClientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClientId))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelUsuarisLayout = new javax.swing.GroupLayout(jPanelUsuaris);
        jPanelUsuaris.setLayout(jPanelUsuarisLayout);
        jPanelUsuarisLayout.setHorizontalGroup(
            jPanelUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addGroup(jPanelUsuarisLayout.createSequentialGroup()
                        .addComponent(jPanelUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelAdminUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelUsuarisLayout.setVerticalGroup(
            jPanelUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarisLayout.createSequentialGroup()
                .addGroup(jPanelUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAdminUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelUserSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneMain.addTab("Clients", jPanelUsuaris);

        jButtonNewProduct.setText("Nou Producte");
        jButtonNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewProductActionPerformed(evt);
            }
        });

        jButtonModifProduct.setText("Modificar Producte");
        jButtonModifProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifProductActionPerformed(evt);
            }
        });

        jButtonDelProduct.setText("Eliminar Producte");
        jButtonDelProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminProductsLayout = new javax.swing.GroupLayout(jPanelAdminProducts);
        jPanelAdminProducts.setLayout(jPanelAdminProductsLayout);
        jPanelAdminProductsLayout.setHorizontalGroup(
            jPanelAdminProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminProductsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAdminProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNewProduct, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonModifProduct, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonDelProduct, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanelAdminProductsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonDelProduct, jButtonModifProduct, jButtonNewProduct});

        jPanelAdminProductsLayout.setVerticalGroup(
            jPanelAdminProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNewProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonModifProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneProducts.setBorder(javax.swing.BorderFactory.createTitledBorder("Llista Productes"));

        jTableProducts.setAutoCreateRowSorter(true);
        jTableProducts.setModel(tableCreator.createTableModel(Producto.class, productos));
        jScrollPaneProducts.setViewportView(jTableProducts);

        jTextFieldProduct.setText("Nom Producte");
        jTextFieldProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldProductFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldProductFocusLost(evt);
            }
        });

        jTextFieldProductId.setText("0");
        jTextFieldProductId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldProductIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldProductIdFocusLost(evt);
            }
        });

        jButtonProductId.setText("Buscar");
        jButtonProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductIdActionPerformed(evt);
            }
        });

        jButtonSearchProductName.setText("Buscar");
        jButtonSearchProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchProductNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProductSearchLayout = new javax.swing.GroupLayout(jPanelProductSearch);
        jPanelProductSearch.setLayout(jPanelProductSearchLayout);
        jPanelProductSearchLayout.setHorizontalGroup(
            jPanelProductSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jTextFieldProductId))
                .addGap(18, 18, 18)
                .addGroup(jPanelProductSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProductId)
                    .addComponent(jButtonSearchProductName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelProductSearchLayout.setVerticalGroup(
            jPanelProductSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchProductName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanelProductSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProductId))
                .addContainerGap())
        );

        jButtonProductsUsed.setText("Productes consumits");
        jButtonProductsUsed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductsUsedActionPerformed(evt);
            }
        });

        jButtonProductsAvailable.setText("Productes disponibles");
        jButtonProductsAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductsAvailableActionPerformed(evt);
            }
        });

        jButtonBuyProduct.setText("Comprar Producte");
        jButtonBuyProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProductGlobalLayout = new javax.swing.GroupLayout(jPanelProductGlobal);
        jPanelProductGlobal.setLayout(jPanelProductGlobalLayout);
        jPanelProductGlobalLayout.setHorizontalGroup(
            jPanelProductGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProductsUsed)
                    .addComponent(jButtonProductsAvailable)
                    .addComponent(jButtonBuyProduct))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelProductGlobalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBuyProduct, jButtonProductsAvailable, jButtonProductsUsed});

        jPanelProductGlobalLayout.setVerticalGroup(
            jPanelProductGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonProductsUsed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProductsAvailable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButtonBuyProduct))
        );

        javax.swing.GroupLayout jPanelProductesLayout = new javax.swing.GroupLayout(jPanelProductes);
        jPanelProductes.setLayout(jPanelProductesLayout);
        jPanelProductesLayout.setHorizontalGroup(
            jPanelProductesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductesLayout.createSequentialGroup()
                        .addComponent(jPanelProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanelProductGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jPanelAdminProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneProducts))
                .addContainerGap())
        );
        jPanelProductesLayout.setVerticalGroup(
            jPanelProductesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductesLayout.createSequentialGroup()
                .addGroup(jPanelProductesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelAdminProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelProductGlobal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneMain.addTab("Productes", jPanelProductes);

        jTextFieldEquip.setText("Nom Equip");
        jTextFieldEquip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEquipFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEquipFocusLost(evt);
            }
        });

        jTextFieldEquipId.setText("0");
        jTextFieldEquipId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEquipIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEquipIdFocusLost(evt);
            }
        });

        jButtonEquipId.setText("Buscar");
        jButtonEquipId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEquipIdActionPerformed(evt);
            }
        });

        jButtonSearchEquipName.setText("Buscar");
        jButtonSearchEquipName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchEquipNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEquipSearchLayout = new javax.swing.GroupLayout(jPanelEquipSearch);
        jPanelEquipSearch.setLayout(jPanelEquipSearchLayout);
        jPanelEquipSearchLayout.setHorizontalGroup(
            jPanelEquipSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEquipSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEquip, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jTextFieldEquipId))
                .addGap(18, 18, 18)
                .addGroup(jPanelEquipSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEquipId)
                    .addComponent(jButtonSearchEquipName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEquipSearchLayout.setVerticalGroup(
            jPanelEquipSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEquipSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchEquipName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanelEquipSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEquipId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEquipId))
                .addContainerGap())
        );

        jButtonNewEquip.setText("Nou Equip");
        jButtonNewEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewEquipActionPerformed(evt);
            }
        });

        jButtonModifEquip.setText("Modificar Equip");
        jButtonModifEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifEquipActionPerformed(evt);
            }
        });

        jButtonDelEquip.setText("Eliminar Equip");
        jButtonDelEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelEquipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminEquipsLayout = new javax.swing.GroupLayout(jPanelAdminEquips);
        jPanelAdminEquips.setLayout(jPanelAdminEquipsLayout);
        jPanelAdminEquipsLayout.setHorizontalGroup(
            jPanelAdminEquipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminEquipsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAdminEquipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonModifEquip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDelEquip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNewEquip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelAdminEquipsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonDelEquip, jButtonModifEquip});

        jPanelAdminEquipsLayout.setVerticalGroup(
            jPanelAdminEquipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminEquipsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNewEquip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonModifEquip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelEquip)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneEquips.setBorder(javax.swing.BorderFactory.createTitledBorder("Llista Equips"));

        jTableEquips.setAutoCreateRowSorter(true);
        jTableEquips.setModel(tableCreator.createTableModel(Equipo.class, equipos));
        jScrollPaneEquips.setViewportView(jTableEquips);

        jButtonEquipsUsed.setText("Reserves");
        jButtonEquipsUsed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEquipsUsedActionPerformed(evt);
            }
        });

        jButtonAllEquips.setText("Equips");
        jButtonAllEquips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllEquipsActionPerformed(evt);
            }
        });

        jButtonBook.setText("Reservar equip");
        jButtonBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBookActionPerformed(evt);
            }
        });

        jButtonDelbooking.setText("Eliminar reserva");
        jButtonDelbooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelbookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProductBotons1Layout = new javax.swing.GroupLayout(jPanelProductBotons1);
        jPanelProductBotons1.setLayout(jPanelProductBotons1Layout);
        jPanelProductBotons1Layout.setHorizontalGroup(
            jPanelProductBotons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductBotons1Layout.createSequentialGroup()
                .addGroup(jPanelProductBotons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductBotons1Layout.createSequentialGroup()
                        .addComponent(jButtonEquipsUsed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelProductBotons1Layout.createSequentialGroup()
                        .addComponent(jButtonAllEquips)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelbooking)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelProductBotons1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAllEquips, jButtonEquipsUsed});

        jPanelProductBotons1Layout.setVerticalGroup(
            jPanelProductBotons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductBotons1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductBotons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEquipsUsed)
                    .addComponent(jButtonBook))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelProductBotons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAllEquips)
                    .addComponent(jButtonDelbooking))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelEquipsLayout = new javax.swing.GroupLayout(jPanelEquips);
        jPanelEquips.setLayout(jPanelEquipsLayout);
        jPanelEquipsLayout.setHorizontalGroup(
            jPanelEquipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEquipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEquipsLayout.createSequentialGroup()
                        .addComponent(jPanelEquipSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelProductBotons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelAdminEquips, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneEquips, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEquipsLayout.setVerticalGroup(
            jPanelEquipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipsLayout.createSequentialGroup()
                .addGroup(jPanelEquipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelAdminEquips, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEquipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelProductBotons1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelEquipSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneEquips, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneMain.addTab("Equipament", jPanelEquips);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneMain)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(18, 18, 18)
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /*--------------------------------
    Control del focus en els TextField
    */
    
    /**
     * Mètode per controlar desaparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en guanyar el focus
     */
    private void jTextFieldSurnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSurnameFocusGained
        if(jTextFieldSurname.getText().trim().equals("Cognom"))
           jTextFieldSurname.setText("");
    }//GEN-LAST:event_jTextFieldSurnameFocusGained

    /**
     * Mètode per controlar l'aparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en perdre el focus
     */
    private void jTextFieldSurnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSurnameFocusLost
        if(jTextFieldSurname.getText().trim().equals("")){
           jTextFieldSurname.setText("Cognom");
        }
    }//GEN-LAST:event_jTextFieldSurnameFocusLost

    /**
     * Mètode per controlar desaparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en guanyar el focus
     */
    private void jTextFieldClientIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldClientIdFocusGained
        if(jTextFieldClientId.getText().trim().equals("Id"))
           jTextFieldClientId.setText("");
    }//GEN-LAST:event_jTextFieldClientIdFocusGained

    /**
     * Mètode per controlar l'aparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en perdre el focus
     */
    private void jTextFieldClientIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldClientIdFocusLost
        if(jTextFieldClientId.getText().trim().equals("")){
           jTextFieldClientId.setText("Id");
        }
    }//GEN-LAST:event_jTextFieldClientIdFocusLost

    /**
     * Mètode per controlar desaparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en guanyar el focus
     */
    private void jTextFieldProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProductFocusGained
        if(jTextFieldProduct.getText().trim().equals("Nom Producte"))
           jTextFieldProduct.setText("");
    }//GEN-LAST:event_jTextFieldProductFocusGained

	/**
     * Mètode per controlar l'aparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en perdre el focus
     */
    private void jTextFieldProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProductFocusLost
       if(jTextFieldProduct.getText().trim().equals("")){
           jTextFieldProduct.setText("Nom Producte");
        }
    }//GEN-LAST:event_jTextFieldProductFocusLost

    /**
     * Mètode per controlar l'aparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en perdre el focus
     */
    private void jTextFieldProductIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProductIdFocusLost
        if(jTextFieldProductId.getText().trim().equals("")){
           jTextFieldProductId.setText(String.valueOf(0));
        }
    }//GEN-LAST:event_jTextFieldProductIdFocusLost

    /**
     * Mètode per controlar desaparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en guanyar el focus
     */
    private void jTextFieldProductIdFocusGained(java.awt.event.FocusEvent evt) {                                                  
        if(jTextFieldProductId.getText().trim().equals(0)){
           jTextFieldProductId.setText("");
        }
    }                                               

    /**
     * Mètode per controlar desaparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en guanyar el focus
     */
    private void jTextFieldEquipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEquipFocusGained
        if(jTextFieldEquip.getText().trim().equals("Nom Equip"))
           jTextFieldEquip.setText("");
    }//GEN-LAST:event_jTextFieldEquipFocusGained

    /**
     * Mètode per controlar l'aparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en perdre el focus
     */
    private void jTextFieldEquipFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEquipFocusLost
        if(jTextFieldEquip.getText().trim().equals("")){
           jTextFieldEquip.setText("Nom Equip");
        }
    }//GEN-LAST:event_jTextFieldEquipFocusLost

    /**
     * Mètode per controlar desaparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en guanyar el focus
     */
    private void jTextFieldEquipIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEquipIdFocusGained
        if(jTextFieldEquipId.getText().trim().equals(0)){
           jTextFieldEquipId.setText("");
        }
    }//GEN-LAST:event_jTextFieldEquipIdFocusGained

    /**
     * Mètode per controlar l'aparició del text per defecte
     * @author manel bosch
     * @param evt Event que es produeix en perdre el focus
     */
    private void jTextFieldEquipIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEquipIdFocusLost
        if(jTextFieldEquipId.getText().trim().equals("")){
           jTextFieldEquipId.setText(String.valueOf(0));
        }
    }//GEN-LAST:event_jTextFieldEquipIdFocusLost



    /*---------------------
    Accions sobre el perfil
    */

    /**
     * Mètode per modificar les dades del perfil
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonModifProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifProfileActionPerformed
        jButtonCancelModifProfile.setVisible(true);
        if(jButtonModifProfile.getText().equals("Modificar dades")){
            editProfileTextFields(true);
            jButtonModifProfile.setText("Guardar canvis");
        }else if (jButtonModifProfile.getText().equals("Guardar canvis")){
            changeProfile();
            jButtonModifProfile.setText("Modificar dades");
            jButtonCancelModifProfile.setVisible(false);
            editProfileTextFields(false);
        }
    }//GEN-LAST:event_jButtonModifProfileActionPerformed

    /**
     * Mètode per cridar la finestra per canviar el password
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonChangePasswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangePasswdActionPerformed
        PasswordDialog dialog = new PasswordDialog(this, true, usuario);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonChangePasswdActionPerformed

    /**
     * Mètode per cancelar la modificació de dades del perfil
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonCancelModifProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelModifProfileActionPerformed
        jButtonModifProfile.setText("Modificar dades");
        jButtonCancelModifProfile.setVisible(false);
        fillProfile();
        editProfileTextFields(false);
    }//GEN-LAST:event_jButtonCancelModifProfileActionPerformed


    /*-----------------------
    Accions sobre els clients
    */

    /**
     * Mètode per buscar un client a la base de dades pel seu cognom
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    //El mètode de cerca hauria d'existir en el servidor.
    private void jButtonSearchSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchSurnameActionPerformed
        if(jTextFieldSurname.getText().equals("Cognom") || jTextFieldSurname.getText().isEmpty()){
            fillClientsList();
        }else{
            String cognom = jTextFieldSurname.getText().toLowerCase();
            List<Cliente> clientsSurname = new ArrayList<>();
            for (Cliente c : clientes) {
                if(c.getPrimerApellido().toLowerCase().contains(cognom)){
                    clientsSurname.add(c);
                }
            }
            fillClientsList(clientsSurname);
        }
    }//GEN-LAST:event_jButtonSearchSurnameActionPerformed

    /**
     * Mètode per buscar un client a la base de dades pel seu identificador
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonClientIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientIdActionPerformed
        String id = jTextFieldClientId.getText();
        rowSorter = new TableRowSorter<>(jTableClients.getModel());
        jTableClients.setRowSorter(rowSorter);
        if(id.length() == 9){
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + id));
        }else{
            rowSorter.setRowFilter(null);
        }
    }//GEN-LAST:event_jButtonClientIdActionPerformed

    /**
     * Mètode per introduir un client nou a la base de dades
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewClientActionPerformed
        ClientDialog dialog = new ClientDialog(this, true, usuario);
        dialog.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                fillClientsList();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonNewClientActionPerformed

    /**
     * Mètode per modificar un client seleccionat 
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonModifClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifClientActionPerformed
        if(jTableClients.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona un client a modificar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableClients.getSelectedRow();
            String idClient = (String) jTableClients.getModel().getValueAt(row,0);
            openClienteClient();
            Cliente c = cClient.find_JSON(Cliente.class, idClient);
            cClient.close();
            ClientDialog dialog = new ClientDialog(this, true, usuario, c);
                dialog.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e){
                        fillClientsList();
                    }
                });
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButtonModifClientActionPerformed

    /**
     * Mètode per eliminar el client 
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonDelClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelClientActionPerformed
        if(jTableClients.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona un client a eliminar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableClients.getSelectedRow();
            String id = (String) jTableClients.getModel().getValueAt(row,0);
            openClienteClient();
            cClient.remove(id);
            cClient.close();
            fillClientsList();
        }
    }//GEN-LAST:event_jButtonDelClientActionPerformed
    

    
    /*-------------------------
    Accions sobre els productes
    */
    
    /**
     * Mètode per buscar un producte a la base de dades pel seu nom
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    //El mètode de cerca hauria d'existir en el servidor.
    private void jButtonSearchProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchProductNameActionPerformed
        if(jTextFieldProduct.getText().equals("Nom Producte") || jTextFieldProduct.getText().isEmpty()){
            fillProductsList();
        }else{
            String nom = jTextFieldProduct.getText().toLowerCase();
            List<Producto> productsName = new ArrayList<>();
            for (Producto p : productos) {
                if(p.getNombre().toLowerCase().contains(nom)){
                    productsName.add(p);
                }
            }
            fillProductsList(productsName);
        }
    }//GEN-LAST:event_jButtonSearchProductNameActionPerformed

    /**
     * Mètode per buscar un producte a la base de dades pel seu identificador
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductIdActionPerformed
        int idInt = Integer.parseInt(jTextFieldProductId.getText());
        rowSorter = new TableRowSorter<>(jTableProducts.getModel());
        jTableProducts.setRowSorter(rowSorter);
        if(idInt == 0){
            fillProductsList();
        }else{
            rowSorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, idInt));
        }
    }//GEN-LAST:event_jButtonProductIdActionPerformed
 
    /**
     * Mètode per buscar tots els productes consumits pel client
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    //El mètode hauria de cridar a una consulta específica que retornés només l'historial del client. 
    //A implementar en el sevidor
    private void jButtonProductsUsedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductsUsedActionPerformed
        openHistorialProductosClient();
        hProductos = hpClient.findAll_JSON(gTypeHistorialProduct);
        List<HistorialProductos> consumedProducts = new ArrayList<>();
        for(HistorialProductos hp: hProductos){
            if(hp.getIdcliente().equals(cliente)){
                consumedProducts.add(hp);
            }
        }
        fillHistorialProductos(consumedProducts);
        hpClient.close();
    }//GEN-LAST:event_jButtonProductsUsedActionPerformed

    /**
     * Mètode per mostrar la llista de productes amb les quantitats disponibles que hi ha
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonProductsAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductsAvailableActionPerformed
        fillProductsList();
    }//GEN-LAST:event_jButtonProductsAvailableActionPerformed

    /**
     * Mètode per comprar un producte. 
     * Crida a la finestra per especificar la quantitat a comprar del producte seleccionat
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonBuyProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyProductActionPerformed
        if(jTableProducts.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona un producte a comprar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableProducts.getSelectedRow();
            String idProduct = String.valueOf(jTableProducts.getModel().getValueAt(row,0));
            openProductoClient();
            Producto p = pClient.find_JSON(Producto.class, idProduct);
            pClient.close();
            BuyProductDialog dialog = new BuyProductDialog(this, true, usuario, cliente, p);
            dialog.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e){
                    fillProductsList();
                }
            });
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBuyProductActionPerformed

    /**
     * Mètode per afegir un producte nou a la llista de productes
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewProductActionPerformed
        ProductDialog dialog = new ProductDialog(this, true, usuario);
        dialog.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                fillProductsList();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonNewProductActionPerformed

    /**
     * Mètode per modificar un producte de la llista
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonModifProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifProductActionPerformed
        if(jTableProducts.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona un producte a modificar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableProducts.getSelectedRow();
            String idProduct = String.valueOf(jTableProducts.getModel().getValueAt(row,0));
            openProductoClient();
            Producto p = pClient.find_JSON(Producto.class, idProduct);
            pClient.close();
            ProductDialog dialog = new ProductDialog(this, true, usuario, p);
            dialog.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e){
                    fillProductsList();
                }
            });
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButtonModifProductActionPerformed

    /**
     * Mètode per eliminar un producte de la llista
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonDelProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelProductActionPerformed
        if(jTableProducts.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona un producte a eliminar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableProducts.getSelectedRow();
            String id = String.valueOf(jTableProducts.getModel().getValueAt(row,0));
            openProductoClient();
            pClient.remove(id);
            pClient.close();
            fillProductsList();
        }
    }//GEN-LAST:event_jButtonDelProductActionPerformed

    
    
     /*-------------------------
    Accions sobre els equips
    */
    
    /**
     * Mètode per buscar un equip a la base de dades pel seu nom
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    //El mètode de cerca hauria d'existir en el servidor.
    private void jButtonSearchEquipNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchEquipNameActionPerformed
        jTableEquips.setRowSorter(null);
        if(jTextFieldEquip.getText().equals("Nom Equip")){
            fillEquipsList();
        }else{
            String nom = jTextFieldEquip.getText().toLowerCase();
            List<Equipo> equipsName = new ArrayList<>();
            for (Equipo e : equipos) {
                if(e.getNombre().toLowerCase().contains(nom)){
                    equipsName.add(e);
                }
            }
            fillEquipsList(equipsName);
        }
    }//GEN-LAST:event_jButtonSearchEquipNameActionPerformed

     /**
     * Mètode per buscar un equip a la base de dades pel seu identificador
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonEquipIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEquipIdActionPerformed
        int idInt = Integer.parseInt(jTextFieldEquipId.getText());
        rowSorter = new TableRowSorter<>(jTableEquips.getModel());
        jTableEquips.setRowSorter(rowSorter);
        if(idInt == 0){
            fillEquipsList();
        }else{
            rowSorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, idInt));
        }
    }//GEN-LAST:event_jButtonEquipIdActionPerformed

    /**
     * Mètode per mostrar la llista d'equips reservats pel client
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonEquipsUsedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEquipsUsedActionPerformed
        List<HistorialEquipos> rentedEquips = new ArrayList<>();
        for(HistorialEquipos he: hEquipos){
            if(he.getIdcliente().equals(cliente)){
                rentedEquips.add(he);
            }
        }
        fillHistorialEquipos(rentedEquips);
    }//GEN-LAST:event_jButtonEquipsUsedActionPerformed

    /**
     * Mètode per reservar un equip
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBookActionPerformed
        if(jTableEquips.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona un equip a reservar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableEquips.getSelectedRow();
            String idEquip = String.valueOf(jTableEquips.getModel().getValueAt(row,0));
            openEquipoClient();
            Equipo e = eqClient.find_JSON(Equipo.class, idEquip);
            eqClient.close();
            BookEquipDialog dialog = new BookEquipDialog(this, true, usuario, cliente, e);
            dialog.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e){
                    fillEquipsList();
                }
            });
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBookActionPerformed

    /**
     * Mètode per afegir un equip nou a la llista d'equips
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonNewEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewEquipActionPerformed
        EquipDialog dialog = new EquipDialog(this, true, usuario);
        dialog.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                fillEquipsList();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonNewEquipActionPerformed

    /**
     * Mètode per modificar un equip de la llista
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonModifEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifEquipActionPerformed
        if(jTableEquips.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona un equip a modificar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableEquips.getSelectedRow();
            String idEquip = String.valueOf(jTableEquips.getModel().getValueAt(row,0));
            openEquipoClient();
            Equipo e = eqClient.find_JSON(Equipo.class, idEquip);
            eqClient.close();
            EquipDialog dialog = new EquipDialog(this, true, usuario, e);
            dialog.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e){
                    fillEquipsList();
                }
            });
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButtonModifEquipActionPerformed

     /**
     * Mètode per eliminar un equip de la llista
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonDelEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelEquipActionPerformed
        if(jTableEquips.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona un equip a eliminar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableEquips.getSelectedRow();
            String id = String.valueOf(jTableEquips.getModel().getValueAt(row,0));
            openEquipoClient();
            eqClient.remove(id);
            eqClient.close();
            fillEquipsList();
        }
    }//GEN-LAST:event_jButtonDelEquipActionPerformed

    /**
     * Mètode per llistar tots els equips del laboratori
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonAllEquipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllEquipsActionPerformed
        fillEquipsList();
    }//GEN-LAST:event_jButtonAllEquipsActionPerformed

    /**
     * Mètode per eliminar una reserva d'un equip
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonDelbookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelbookingActionPerformed
        if(jTableEquips.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecciona una reserva a eliminar","Alert !!",JOptionPane.WARNING_MESSAGE);
        }else{
            int row = jTableEquips.getSelectedRow();
            String id = String.valueOf(jTableEquips.getModel().getValueAt(row,1));
            openHistorialEquiposClient();
            try{
                HistorialEquipos he = heClient.find_JSON(HistorialEquipos.class, id);
                heClient.remove(id);
            }catch(NotFoundException e){
                JOptionPane.showMessageDialog(null,"La fila seleccionada no és una reserva","Alert !!",JOptionPane.WARNING_MESSAGE);
            }
            heClient.close();
            fillEquipsList();
        }
    }//GEN-LAST:event_jButtonDelbookingActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAllEquips;
    private javax.swing.JButton jButtonBook;
    private javax.swing.JButton jButtonBuyProduct;
    private javax.swing.JButton jButtonCancelModifProfile;
    private javax.swing.JButton jButtonChangePasswd;
    private javax.swing.JButton jButtonClientId;
    private javax.swing.JButton jButtonDelClient;
    private javax.swing.JButton jButtonDelEquip;
    private javax.swing.JButton jButtonDelProduct;
    private javax.swing.JButton jButtonDelbooking;
    private javax.swing.JButton jButtonEquipId;
    private javax.swing.JButton jButtonEquipsUsed;
    private javax.swing.JButton jButtonModifClient;
    private javax.swing.JButton jButtonModifEquip;
    private javax.swing.JButton jButtonModifProduct;
    private javax.swing.JButton jButtonModifProfile;
    private javax.swing.JButton jButtonNewClient;
    private javax.swing.JButton jButtonNewEquip;
    private javax.swing.JButton jButtonNewProduct;
    private javax.swing.JButton jButtonProductId;
    private javax.swing.JButton jButtonProductsAvailable;
    private javax.swing.JButton jButtonProductsUsed;
    private javax.swing.JButton jButtonSearchEquipName;
    private javax.swing.JButton jButtonSearchProductName;
    private javax.swing.JButton jButtonSearchSurname;
    private javax.swing.JLabel jLabelCognom1;
    private javax.swing.JLabel jLabelCognom2;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelTelf;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelAdminEquips;
    private javax.swing.JPanel jPanelAdminProducts;
    private javax.swing.JPanel jPanelAdminUser;
    private javax.swing.JPanel jPanelDadesPersonals;
    private javax.swing.JPanel jPanelEquipSearch;
    private javax.swing.JPanel jPanelEquips;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelPerfil;
    private javax.swing.JPanel jPanelProductBotons1;
    private javax.swing.JPanel jPanelProductGlobal;
    private javax.swing.JPanel jPanelProductSearch;
    private javax.swing.JPanel jPanelProductes;
    private javax.swing.JPanel jPanelUserSearch;
    private javax.swing.JPanel jPanelUsuaris;
    private javax.swing.JScrollPane jScrollPaneEquips;
    private javax.swing.JScrollPane jScrollPaneProducts;
    private javax.swing.JScrollPane jScrollPaneUsers;
    private javax.swing.JTabbedPane jTabbedPaneMain;
    private javax.swing.JTable jTableClients;
    private javax.swing.JTable jTableEquips;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTextField jTextFieldClientId;
    private javax.swing.JTextField jTextFieldCognom1;
    private javax.swing.JTextField jTextFieldCognom2;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldEquip;
    private javax.swing.JTextField jTextFieldEquipId;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldProduct;
    private javax.swing.JTextField jTextFieldProductId;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldTelf;
    // End of variables declaration//GEN-END:variables

    /*---------------
    Gestió del perfil
    */
    
    /**
     * Mètode per omplir els camps de la pestanya perfil
     * @author manel bosch
     */
    private void fillProfile(){
        openClienteClient();
        this.cliente = cClient.find_JSON(Cliente.class, usuario.getId());
        jTextFieldNom.setText(cliente.getNombre());
        jTextFieldDni.setText(cliente.getDni());
        jTextFieldCognom1.setText(cliente.getPrimerApellido());
        jTextFieldCognom2.setText(cliente.getSegundoApellido());
        jTextFieldMail.setText(cliente.getEmail());
        jTextFieldTelf.setText(cliente.getTelefono());
        cClient.close();
    }
    
    /**
     * Mètode per habilitar l'entrada de dades als camps de text
     * @author manel bosch
     * @param b Boolean
     */
    public void editProfileTextFields(Boolean b){
        jTextFieldNom.setEditable(b);
        jTextFieldCognom1.setEditable(b);
        jTextFieldCognom2.setEditable(b);
        jTextFieldMail.setEditable(b);
        jTextFieldTelf.setEditable(b);
        jTextFieldNom.setEditable(b);
        jTextFieldCognom1.setEditable(b);
        jTextFieldCognom2.setEditable(b);
        jTextFieldMail.setEditable(b);
        jTextFieldTelf.setEditable(b);
    }
    
     /**
     * Mètode per canviar els camps del client
     * @author manel bosch
     */
    public void changeProfile(){
        openClienteClient();
        cliente.setNombre(jTextFieldNom.getText());
        cliente.setPrimerApellido(jTextFieldCognom1.getText());
        cliente.setSegundoApellido(jTextFieldCognom2.getText());
        cliente.setEmail(jTextFieldMail.getText());
        cliente.setTelefono(jTextFieldTelf.getText());
        cClient.edit_JSON(cliente, cliente.getDni());
        cClient.close();
    }

    
    /*---------------
    Gestió de clients
    */
    
    /**
     * Mètode per omplir la taula de clients
     * @author manel bosch
     */
    public void fillClientsList(){
        openClienteClient();
        clientes = cClient.findAll_JSON(gTypeClient);
        jTableClients.setModel(tableCreator.createTableModel(Cliente.class, clientes));
        cClient.close();
    }
    
    /**
     * Mètode per omplir la taula de clients amb una llista passada per paràmetre
     * @author manel bosch
     * @param l Llista de clients a mostrar
     */
    public void fillClientsList(List l){
        jTableClients.setModel(tableCreator.createTableModel(Cliente.class, l));
    }
   
    
    /*-----------------
    Gestió de productes
    */
    
    /**
     * Mètode per omplir la taula de productes
     * @author manel bosch
     */
    public void fillProductsList(){
        openProductoClient();
        productos = pClient.findAll_JSON(gTypeProduct);
        jTableProducts.setModel(tableCreator.createTableModel(Producto.class, productos));
        pClient.close();
    }
    
    /**
     * Mètode per omplir la taula de productes amb una llista passada per paràmetre
     * @author manel bosch
     * @param l Llista de productes a mostrar
     */
    public void fillProductsList(List l){
        jTableProducts.setModel(tableCreator.createTableModel(Producto.class, l));
    }
    
    /**
     * Mètode per omplir la taula de productes amb la llista de productes consumits pel client passada per paràmetre
     * @author manel bosch
     * @param l Llista de productes consumits a mostrar
     */
    public void fillHistorialProductos(List l){
        jTableProducts.setModel(tableCreator.createTableModel(HistorialProductos.class, l));
    }
    
    
    
    /*-----------------
    Gestió d'equips
    */
    
    /**
     * Mètode per omplir la taula d'equips
     * @author manel bosch
     */
    public void fillEquipsList(){
        updateBookingOfEquips();
        jTableEquips.setModel(tableCreator.createTableModel(Equipo.class, equipos));
    }
    
    /**
     * Mètode per omplir la taula d'equips amb una llista passada per paràmetre
     * @author manel bosch
     * @param l Llista d'equips a mostrar
     */
    public void fillEquipsList(List l){
        jTableEquips.setModel(tableCreator.createTableModel(Equipo.class, l));
    }
    
    /**
     * Mètode per omplir la taula d'equips amb la llista d'equips llogats pel client passada per paràmetre
     * @author manel bosch
     * @param l Llista d'equips llogats a mostrar
     */
    public void fillHistorialEquipos(List l){
       jTableEquips.setModel(tableCreator.createTableModel(HistorialEquipos.class, l));
    }
    
    /**
     * Mètode per actualitzar l'estat de reserva de tots els equips
     * @author manel bosch
     */
    public void updateBookingOfEquips(){
        openEquipoClient();
        equipos = eqClient.findAll_JSON(gTypeEquip);
        openHistorialEquiposClient();
        hEquipos = heClient.findAll_JSON(gTypeHistorialEquip);
        for (Equipo e : equipos) {
            for (HistorialEquipos he : hEquipos) {
                if (e.equals(he.getIdequipo())){
                    //Només cal revisar les reserves que encara no han prescrit 
                    if(he.getFinalAlquiler().compareTo(today) >= 0){
                        if(he.isBookedNow(he.getInicioAlquiler(), he.getFinalAlquiler())){
                            e.setEstadoAlquiler(true);
                            eqClient.edit_JSON(e, String.valueOf(e.getId()));
                        }
                    }else{
                        if(e.getEstadoAlquiler()){
                            e.setEstadoAlquiler(false);
                            eqClient.edit_JSON(e, String.valueOf(e.getId()));
                        }
                    }
                }
            }
        }
        equipos = eqClient.findAll_JSON(gTypeEquip);
        eqClient.close();
        heClient.close();
    }
}
