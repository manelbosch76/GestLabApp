
package gestlab.view;

import gestlab.model.Producto;
import gestlab.model.Usuario;
import gestlab.restfulclient.ProductoClientSsl;
import javax.swing.JOptionPane;


/**
 * Classe per gestionar l'entrada/modificació de dades d'un producte
 * @author manel bosch
 */
public class ProductDialog extends javax.swing.JDialog {
    
    private Producto producto;
    private final Usuario usuario;
    private ProductoClientSsl pClient;

    /**
     * Crea una finestra per entrar un nou producte
     * @author manel bosch
     * @param parent finestra mare
     * @param modal manté el focus fins a tancar la finestra
     * @param usuario que està connectat al programa
     */
    public ProductDialog(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        this.usuario = usuario;
        openClient();
        initComponents();
        hideFields();
    }
    
    /**
     * Crea un nou formulari per modificar dades d'un producte passat per paràmetre
     * @author manel bosch
     * @param parent finestra mare
     * @param modal manté el focus fins a tancar la finestra
     * @param usuario que està connectat al programa
     * @param producto Producte a modificar
     */
    public ProductDialog(java.awt.Frame parent, boolean modal, Usuario usuario, Producto producto) {
        super(parent, modal);
        this.usuario = usuario;
        openClient();
        initComponents();
        jTextFieldIdProducte.setEditable(false);
        this.producto = producto;
        fillProductData(producto);
    }
    
    /**
     * Mètode per amagar els camps referents al ID del producte en cas de ser un producte nou
     * @author manel bosch
     */
    private void hideFields(){
        jLabelIdProducte.setVisible(false);
        jTextFieldIdProducte.setVisible(false);
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
        jPanelDadesProducte = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jLabelCompany = new javax.swing.JLabel();
        jTextFieldCompany = new javax.swing.JTextField();
        jLabelReference = new javax.swing.JLabel();
        jTextFieldReference = new javax.swing.JTextField();
        jLabelUnits = new javax.swing.JLabel();
        jTextFieldUnits = new javax.swing.JTextField();
        jLabelQuantity = new javax.swing.JLabel();
        jLabelIdProducte = new javax.swing.JLabel();
        jTextFieldIdProducte = new javax.swing.JTextField();
        jTextFieldQuantity = new javax.swing.JTextField();
        jPanelBotons = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelTitol.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabelTitol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitol.setText("GestLab: Producte");

        jLabelName.setText("Nom:");

        jLabelCompany.setText("Casa comercial:");

        jLabelReference.setText("Referència:");

        jLabelUnits.setText("Unitats:");

        jLabelQuantity.setText("Quantitat:");

        jLabelIdProducte.setText("ID:");

        javax.swing.GroupLayout jPanelDadesProducteLayout = new javax.swing.GroupLayout(jPanelDadesProducte);
        jPanelDadesProducte.setLayout(jPanelDadesProducteLayout);
        jPanelDadesProducteLayout.setHorizontalGroup(
            jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesProducteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadesProducteLayout.createSequentialGroup()
                        .addComponent(jLabelIdProducte)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDadesProducteLayout.createSequentialGroup()
                        .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName)
                            .addComponent(jLabelCompany)
                            .addComponent(jLabelReference)
                            .addComponent(jLabelUnits)
                            .addComponent(jLabelQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldUnits, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jTextFieldReference, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCompany, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldIdProducte, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldQuantity))
                .addContainerGap())
        );
        jPanelDadesProducteLayout.setVerticalGroup(
            jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadesProducteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdProducte)
                    .addComponent(jTextFieldIdProducte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelName))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCompany))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelReference))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUnits))
                .addGap(20, 20, 20)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantity)
                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
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
                .addContainerGap()
                .addComponent(jButtonSave)
                .addGap(18, 18, 18)
                .addComponent(jButtonClear)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBotonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonClear, jButtonSave});

        jPanelBotonsLayout.setVerticalGroup(
            jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelBotons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDadesProducte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitol)
                .addGap(18, 18, 18)
                .addComponent(jPanelDadesProducte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mètode per guardar els canvis
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if(producto == null){
            Producto p = getProductData();
            int done = pClient.create_JSON(p);//retorna 204
        }else{
            producto = getProductData();
            String id = jTextFieldIdProducte.getText();
            int done = pClient.edit_JSON(producto, id);//retorna 204
        }
        pClient.close();
        this.dispose(); 
    }//GEN-LAST:event_jButtonSaveActionPerformed

    /**
     * Mètode per netejar les dades introduides
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextFieldNom.setText("");
        jTextFieldCompany.setText("");
        jTextFieldReference.setText("");
        jTextFieldUnits.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

    /**
     * Mètode per cancelar l'entrada de dades i per tant tancar la finestra
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        pClient.close();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelCompany;
    private javax.swing.JLabel jLabelIdProducte;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelQuantity;
    private javax.swing.JLabel jLabelReference;
    private javax.swing.JLabel jLabelTitol;
    private javax.swing.JLabel jLabelUnits;
    private javax.swing.JPanel jPanelBotons;
    private javax.swing.JPanel jPanelDadesProducte;
    private javax.swing.JTextField jTextFieldCompany;
    private javax.swing.JTextField jTextFieldIdProducte;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldQuantity;
    private javax.swing.JTextField jTextFieldReference;
    private javax.swing.JTextField jTextFieldUnits;
    // End of variables declaration//GEN-END:variables

    /**
     * Mètode per inicialitzar el ProductoClientSsl que accedirà al servei RESTful
     * @author manel bosch
     */
    private void openClient(){
        pClient = new ProductoClientSsl(usuario.getToken());
    }
    
    /**
     * Mètode per omplir els camps amb les dades del producte passat com a paràmetre
     * @author manel bosch
     * @param p Producte
     */
    private void fillProductData(Producto p){
        jTextFieldIdProducte.setText(String.valueOf(p.getId()));
        jTextFieldNom.setText(p.getNombre());
        jTextFieldCompany.setText(p.getCasaComercial());
        jTextFieldReference.setText(p.getReferencia());
        jTextFieldUnits.setText(p.getUnidades());
        jTextFieldQuantity.setText(String.valueOf(p.getCantidad()));
    }
    
    /**
     * Mètode per llegir els camps amb les dades entrades per crear el producte
     * @author manel bosch
     * @return Producte amb les dades entrades
     */
    private Producto getProductData(){
        if(checkFilledFields()){
            Producto p = new Producto();
            p.setNombre(jTextFieldNom.getText());
            p.setCasaComercial(jTextFieldCompany.getText());
            p.setReferencia(jTextFieldReference.getText());
            p.setUnidades(jTextFieldUnits.getText());
            p.setCantidad(Float.parseFloat(jTextFieldQuantity.getText()));
            if(producto != null){
                p.setId(producto.getId());
            }
            return p;
        }else{
            JOptionPane.showMessageDialog(null,"Omplir tots els camps","Alert !!",JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    /**
     * Mètode per saber si tots els camps necessaris estan plens
     * @author manel bosch
     * @return true o false
     */
    private boolean checkFilledFields(){
        return !(jTextFieldNom.getText().equals("")
                ||jTextFieldCompany.getText().equals("")
                ||jTextFieldUnits.getText().equals("")
                ||jTextFieldQuantity.getText().equals(""));
    }
}
