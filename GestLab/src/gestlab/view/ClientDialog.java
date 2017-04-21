
package gestlab.view;

import gestlab.model.Cliente;
import gestlab.model.Empresa;
import gestlab.model.Usuario;
import gestlab.restfulclient.ClienteClientSsl;
import gestlab.restfulclient.EmpresaClientSsl;
import gestlab.restfulclient.UsuarioClientSsl;
import gestlab.utils.tables.TableCreator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.core.GenericType;

/**
 * Classe que gestiona la finestra d'entrada/modificació de dades d'un client
 * @author manel bosch
 */
public class ClientDialog extends javax.swing.JDialog {
    
    private final Usuario usuario;
    private Cliente cliente;
    private Empresa empresa;
    private List<Empresa> empreses;
    GenericType<List<Empresa>> gTypeUser = new GenericType<List<Empresa>>(){};
    Boolean newClient = false;
    
    private ClienteClientSsl cClient;
    private UsuarioClientSsl uClient;
    private EmpresaClientSsl eClient;

    private final TableCreator tableCreator = new TableCreator();

    /**
     * Crea un nou formulari per entrar dades d'un nou usuari
     * @author manel bosch
     * @param parent finestra mare
     * @param modal manté el focus fins a tancar la finestra
     * @param usuario Usuari que està connectat al programa
     */
    public ClientDialog(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        this.usuario = usuario;
        initClients();
        empreses = eClient.findAll_JSON(gTypeUser);
        initComponents();
        newClient = true;
        isNew();
        fillCompanyTable();
    }
    
    /**
     * Crea un nou formulari per modificar dades d'usuari passat per paràmetre
     * @author manel bosch
     * @param parent finestra mare
     * @param modal manté el focus fins a tancar la finestra
     * @param usuario Usuari que està connectat al programa
     * @param cliente Cliente a modificar
     */
    public ClientDialog(java.awt.Frame parent, boolean modal, Usuario usuario, Cliente cliente) {
        super(parent, modal);
        this.usuario = usuario;
        initClients();
        empreses = eClient.findAll_JSON(gTypeUser);
        initComponents();
        isNew();
        this.cliente = cliente;
        empresa = cliente.getIdempresa();
        fillClientData(cliente);//Omple camps de client i d'empresa
        fillCompanyTable();
    }
    
    /**
     * Mètode per amagar camps segons si el client que s'entra és nou o és una modificació d'un existent
     * @author manel bosch
     */
    private void isNew(){
        if(newClient){
            jButtonModifCompany.setVisible(false);
            jTextFieldLogin.setEditable(false);
        }else{
            jTextFieldDni.setEditable(false);
            jPasswordField1.setVisible(false);
            jLabelPasswd.setVisible(false);
            jTextFieldLogin.setVisible(false);
            jLabelLogin.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitol = new javax.swing.JLabel();
        jPanelDadesPersonals = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jLabelCognom1 = new javax.swing.JLabel();
        jTextFieldCognom1 = new javax.swing.JTextField();
        jLabelCognom2 = new javax.swing.JLabel();
        jTextFieldCognom2 = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();
        jLabelTelf = new javax.swing.JLabel();
        jTextFieldTelf = new javax.swing.JTextField();
        jLabelDni = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jLabelNoObligation = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabelPasswd = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelAdmin = new javax.swing.JLabel();
        jCheckBoxAdmin = new javax.swing.JCheckBox();
        jPanelDadesEmpresa = new javax.swing.JPanel();
        jLabelNif = new javax.swing.JLabel();
        jLabelNomEmpresa = new javax.swing.JLabel();
        jLabelAdreca = new javax.swing.JLabel();
        jTextFieldNif = new javax.swing.JTextField();
        jTextFieldNomEmpresa = new javax.swing.JTextField();
        jTextFieldAdreca = new javax.swing.JTextField();
        jButtonNewCompany = new javax.swing.JButton();
        jButtonModifCompany = new javax.swing.JButton();
        jScrollPaneCompany = new javax.swing.JScrollPane();
        jTableCompanies = new javax.swing.JTable();
        jButtonAddCompany = new javax.swing.JButton();
        jPanelBotons = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelTitol.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabelTitol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitol.setText("GestLab: Usuari");

        jLabelName.setText("Nom:");

        jLabelCognom1.setText("Primer cognom:");

        jLabelCognom2.setText("Segon cognom:");

        jLabelMail.setText("email:");

        jLabelTelf.setText("Telèfon:");

        jLabelDni.setText("DNI:");

        jLabelNoObligation.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabelNoObligation.setText("(no obligatori)");

        jLabelLogin.setText("Login:");

        jLabelPasswd.setText("Password:");

        jPasswordField1.setText("jPasswordField1");

        jLabelAdmin.setText("Administrador:");

        javax.swing.GroupLayout jPanelDadesPersonalsLayout = new javax.swing.GroupLayout(jPanelDadesPersonals);
        jPanelDadesPersonals.setLayout(jPanelDadesPersonalsLayout);
        jPanelDadesPersonalsLayout.setHorizontalGroup(
            jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                        .addComponent(jLabelAdmin)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxAdmin)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadesPersonalsLayout.createSequentialGroup()
                        .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelCognom1)
                                                    .addComponent(jLabelName)))
                                            .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                                                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelDni)
                                                    .addComponent(jLabelCognom2)
                                                    .addComponent(jLabelNoObligation))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                                            .addComponent(jLabelMail)
                                            .addGap(69, 69, 69)))
                                    .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                                        .addComponent(jLabelTelf)
                                        .addGap(51, 51, 51)))
                                .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                                    .addComponent(jLabelLogin)
                                    .addGap(68, 68, 68)))
                            .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                                .addComponent(jLabelPasswd)
                                .addGap(38, 38, 38)))
                        .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField1)
                            .addComponent(jTextFieldLogin)
                            .addComponent(jTextFieldTelf)
                            .addComponent(jTextFieldMail)
                            .addComponent(jTextFieldCognom2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextFieldCognom1)
                            .addComponent(jTextFieldNom)
                            .addComponent(jTextFieldDni))))
                .addContainerGap())
        );

        jPanelDadesPersonalsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPasswordField1, jTextFieldCognom1, jTextFieldCognom2, jTextFieldDni, jTextFieldLogin, jTextFieldMail, jTextFieldNom, jTextFieldTelf});

        jPanelDadesPersonalsLayout.setVerticalGroup(
            jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDni)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCognom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCognom1))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCognom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDadesPersonalsLayout.createSequentialGroup()
                        .addComponent(jLabelCognom2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNoObligation)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMail)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelf)
                    .addComponent(jTextFieldTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPasswd))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesPersonalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdmin)
                    .addComponent(jCheckBoxAdmin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelNif.setText("NIF:");

        jLabelNomEmpresa.setText("Nom empresa:");

        jLabelAdreca.setText("Adreça:");

        jButtonNewCompany.setText("Nova empresa");
        jButtonNewCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewCompanyActionPerformed(evt);
            }
        });

        jButtonModifCompany.setText("Modificar empresa");
        jButtonModifCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifCompanyActionPerformed(evt);
            }
        });

        jScrollPaneCompany.setBorder(javax.swing.BorderFactory.createTitledBorder("Llista Empreses"));

        jTableCompanies.setModel(tableCreator.createTableModel(Empresa.class, empreses));
        jScrollPaneCompany.setViewportView(jTableCompanies);

        jButtonAddCompany.setText("Afegir empresa a Client");
        jButtonAddCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCompanyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadesEmpresaLayout = new javax.swing.GroupLayout(jPanelDadesEmpresa);
        jPanelDadesEmpresa.setLayout(jPanelDadesEmpresaLayout);
        jPanelDadesEmpresaLayout.setHorizontalGroup(
            jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadesEmpresaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonModifCompany))
                    .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                        .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPaneCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                            .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNif)
                                    .addComponent(jLabelNomEmpresa)
                                    .addComponent(jLabelAdreca))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNomEmpresa)
                                    .addComponent(jTextFieldNif)
                                    .addComponent(jTextFieldAdreca, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonNewCompany)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddCompany)))
                .addContainerGap())
        );

        jPanelDadesEmpresaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonModifCompany, jButtonNewCompany});

        jPanelDadesEmpresaLayout.setVerticalGroup(
            jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNif)
                    .addComponent(jTextFieldNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomEmpresa)
                    .addComponent(jTextFieldNomEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdreca)
                    .addComponent(jTextFieldAdreca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonModifCompany)
                .addGap(24, 24, 24)
                .addComponent(jScrollPaneCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCompany)
                    .addComponent(jButtonNewCompany))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonSave.setText("Guardar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClear.setText("Netejar");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel·lar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonsLayout = new javax.swing.GroupLayout(jPanelBotons);
        jPanelBotons.setLayout(jPanelBotonsLayout);
        jPanelBotonsLayout.setHorizontalGroup(
            jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonsLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jButtonSave)
                .addGap(27, 27, 27)
                .addComponent(jButtonClear)
                .addGap(28, 28, 28)
                .addComponent(jButtonCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBotonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonClear, jButtonSave});

        jPanelBotonsLayout.setVerticalGroup(
            jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonsLayout.createSequentialGroup()
                .addGroup(jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonCancel))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanelBotons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDadesPersonals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDadesEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDadesPersonals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelDadesEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mètode per guardar les noves dades
     * @author manel bosch
     * @param evt Event que es produeix en prémer el botó
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        Cliente c; Usuario u; Empresa e;
        if(checkFilledFields() && checkCompanyFields()){
            if(newClient){
                c = getClientData();
                e = eClient.find_JSON(Empresa.class, jTextFieldNif.getText());
                c.setIdempresa(e);
                jTextFieldLogin.setText(jTextFieldDni.getText());
                u = getUserData();
                cClient.create_JSON(c);
                uClient.create_JSON(u);
            }else{
                cliente = getClientData();
                e = eClient.find_JSON(Empresa.class, jTextFieldNif.getText());
                cliente.setIdempresa(e);
                String id = cliente.getDni();
                cClient.edit_JSON(cliente, id);
                u = uClient.find_JSON(Usuario.class, id);
                if(u.getAdministrador() != jCheckBoxAdmin.isSelected()){ //Comprovo si se li ha canviat la condició d'administrador
                    u.setAdministrador(jCheckBoxAdmin.isSelected());
                    uClient.edit_JSON(u, id);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Omplir tots els camps obligatoris","Alert !!",JOptionPane.WARNING_MESSAGE);
        }
        closeClients();
        this.dispose(); 
    }//GEN-LAST:event_jButtonSaveActionPerformed

    /**
     * Mètode per netejar les dades introduides
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextFieldNom.setText("");
        jTextFieldCognom1.setText("");
        jTextFieldCognom2.setText("");
        jTextFieldMail.setText("");
        jTextFieldTelf.setText("");
        jTextFieldLogin.setText("");
        jPasswordField1.setText("");
        jCheckBoxAdmin.setSelected(false);
        jTextFieldNif.setText("");
        jTextFieldNomEmpresa.setText("");
        jTextFieldAdreca.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

    /**
     * Mètode per cancelar l'entrada de dades i per tant tancar el programa
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        closeClients();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    /**
     * Mètode per cridar la finestra per omplir les dades d'una nova empresa
     * @author manel bosch
     * @param evt 
     */
    private void jButtonNewCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewCompanyActionPerformed
        CompanyDialog dialog = new CompanyDialog(this, true, usuario);
        dialog.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                fillCompanyTable();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonNewCompanyActionPerformed

    /**
     * Mètode per modificar l'empresa del client
     * @author manel bosch
     * @param evt Clicar el botó
     */
    private void jButtonModifCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifCompanyActionPerformed
        CompanyDialog dialog = new CompanyDialog(this, true, usuario, empresa);
        dialog.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                Empresa emp = eClient.find_JSON(Empresa.class, empresa.getNif());
                fillCompanyData(emp);
                fillCompanyTable();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonModifCompanyActionPerformed

    /**
     * Mètode per afegir una nova empresa a un nou Client o per reemplaçar la que té un client existent que es modifica
     * @author manel bosch
     * @param evt Clicar el botó
     */
    private void jButtonAddCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCompanyActionPerformed
        if(newClient){
            if(checkFilledFields()){
                cliente = getClientData();
                if(jTableCompanies.getSelectedRowCount() == 0){
                    JOptionPane.showMessageDialog(null,"Selecciona una empresa a afegir al client","Alert !!",JOptionPane.WARNING_MESSAGE);
                }else{
                   addCompany(cliente);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Falten les dades del client","Alert !!",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            if(jTableCompanies.getSelectedRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Selecciona una empresa a afegir al client","Alert !!",JOptionPane.WARNING_MESSAGE);
            }else{
                addCompany(cliente);
            }
        }
    }//GEN-LAST:event_jButtonAddCompanyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCompany;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonModifCompany;
    private javax.swing.JButton jButtonNewCompany;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxAdmin;
    private javax.swing.JLabel jLabelAdmin;
    private javax.swing.JLabel jLabelAdreca;
    private javax.swing.JLabel jLabelCognom1;
    private javax.swing.JLabel jLabelCognom2;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNif;
    private javax.swing.JLabel jLabelNoObligation;
    private javax.swing.JLabel jLabelNomEmpresa;
    private javax.swing.JLabel jLabelPasswd;
    private javax.swing.JLabel jLabelTelf;
    private javax.swing.JLabel jLabelTitol;
    private javax.swing.JPanel jPanelBotons;
    private javax.swing.JPanel jPanelDadesEmpresa;
    private javax.swing.JPanel jPanelDadesPersonals;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPaneCompany;
    private javax.swing.JTable jTableCompanies;
    private javax.swing.JTextField jTextFieldAdreca;
    private javax.swing.JTextField jTextFieldCognom1;
    private javax.swing.JTextField jTextFieldCognom2;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNif;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldNomEmpresa;
    private javax.swing.JTextField jTextFieldTelf;
    // End of variables declaration//GEN-END:variables

    /**
     * Mètode per inicialitzar els clients del servei RESTful
     * @author manel bosch
     */
    private void initClients(){
        uClient = new UsuarioClientSsl(usuario.getToken());
        cClient = new ClienteClientSsl(usuario.getToken());
        eClient = new EmpresaClientSsl(usuario.getToken());
    }
    
    /**
     * Mètode per tancar els clients del RESTful service
     * @author manel bosch
     */
    private void closeClients(){
        uClient.close();
        eClient.close();
        cClient.close();
    }
    
    /**
     * Mètode per omplir la llista d'empreses de la taula
     * @author manel bosch
     */
    private void fillCompanyTable(){
        empreses = eClient.findAll_JSON(gTypeUser);
        jTableCompanies.setModel(tableCreator.createTableModel(Empresa.class, empreses));
    }
    
    /**
     * Mètode per omplir els camps amb les dades del client passat com a paràmetre
     * @author manel bosch
     * @param c Client
     */
    private void fillClientData(Cliente c){
        jTextFieldDni.setText(c.getDni());
        jTextFieldNom.setText(c.getNombre());
        jTextFieldCognom1.setText(c.getPrimerApellido());
        jTextFieldCognom2.setText(c.getSegundoApellido());
        jTextFieldMail.setText(c.getEmail());
        jTextFieldTelf.setText(c.getTelefono());
        Usuario u = uClient.find_JSON(Usuario.class, c.getDni());
        jCheckBoxAdmin.setSelected(u.getAdministrador());
        fillCompanyData(c.getIdempresa());
    }
    
    /**
     * Mètode per omplir els camps amb les dades de l'empresa passada com a paràmetre
     * author manel bosch
     * @param e Empresa
     */
    private void fillCompanyData(Empresa e){
        jTextFieldNif.setText(e.getNif());
        jTextFieldNomEmpresa.setText(e.getNombreEmpresa());
        jTextFieldAdreca.setText(e.getDireccionEmpresa());
    }
    
    /**
     * Mètode per llegir els camps amb les dades entrades per crear el client
     * @author manel bosch
     * @return Client amb les dades entrades
     */
    private Cliente getClientData(){
        if(checkFilledFields()){
            Cliente c = new Cliente(jTextFieldDni.getText());
            c.setNombre(jTextFieldNom.getText());
            c.setPrimerApellido(jTextFieldCognom1.getText());
            c.setSegundoApellido(jTextFieldCognom2.getText());
            c.setEmail(jTextFieldMail.getText());
            c.setTelefono(jTextFieldTelf.getText());
            return c;
        }else{
            JOptionPane.showMessageDialog(null,"Omplir tots els camps obligatoris","Alert !!",JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    /**
     * Mètode per obtenir les dades d'un nou usuari que s'entra al sistema
     * @author manel bosch
     * @return Usuario
     */
    private Usuario getUserData(){
        if(checkFilledFields()){
            Usuario u = new Usuario(jTextFieldDni.getText());
            u.setContrasena(String.valueOf(jPasswordField1.getPassword()));//Falta encriptació
            u.setAdministrador(jCheckBoxAdmin.isSelected());
            return u;
        }else{
            JOptionPane.showMessageDialog(null,"Omplir tots els camps obligatoris","Alert !!",JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
   
    /**
     * Mètode per obtenir l'empresa seleccionada de la taula d'empreses
     * @author manel bosch
     * @return Emrpesa
     */
    private Empresa getCompanyFromTable(){
        int row = jTableCompanies.getSelectedRow();
        String id = (String) jTableCompanies.getModel().getValueAt(row,0);
        Empresa e = eClient.find_JSON(Empresa.class, id);
        return e;
    }
    
    /**
     * Mètode per afegir una empresa a un client passat per paràmetre
     * @author manel bosch
     * @param c Client a qui afegir l'empresa
     */
    private void addCompany(Cliente c){
        Empresa e = getCompanyFromTable();
        c.setIdempresa(e);
        fillCompanyData(e);
    }
    
    /**
     * Mètode per saber si tots els camps necessaris estan plens
     * @author manel bosch
     * @return true si els camps estan plens, false si no
     */
    private boolean checkFilledFields(){
        if(newClient){
            return !(jTextFieldDni.getText().equals("")
                    ||jTextFieldNom.getText().equals("")
                    ||jTextFieldCognom1.getText().equals("")
                    ||jTextFieldMail.getText().equals("")
                    ||jTextFieldTelf.getText().equals("")
                    ||jPasswordField1.getPassword().length<5);
        }else{//Si el client no és nou no es comproven els camps login ni passwd
            return !(jTextFieldDni.getText().equals("")
                    ||jTextFieldNom.getText().equals("")
                    ||jTextFieldCognom1.getText().equals("")
                    ||jTextFieldMail.getText().equals("")
                    ||jTextFieldTelf.getText().equals(""));
        }
    }
    
    /**
     * Mètode per saber si els camps de l'empresa estan buits
     * @author manel bosch
     * @return true si els camps estan plens, false si no
     */
    private boolean checkCompanyFields(){
        return !(jTextFieldNif.getText().equals("")
                ||jTextFieldNomEmpresa.getText().equals("")
                ||jTextFieldAdreca.getText().equals(""));
    }

}
