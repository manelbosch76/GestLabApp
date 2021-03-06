
package gestlab.view;

import gestlab.model.Cliente;
import gestlab.model.HistorialProductos;
import gestlab.model.Producto;
import gestlab.model.Usuario;
import gestlab.restfulclient.HistorialProductosClientSsl;
import gestlab.restfulclient.ProductoClientSsl;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;


/**
 * Classe per gestionar la compra d'un producte
 * @author manel bosch
 */
public class BuyProductDialog extends javax.swing.JDialog {
    
    private final Producto producto;
    private final Usuario usuario;
    private final Cliente cliente;
    
    private HistorialProductosClientSsl hpClient;
    private ProductoClientSsl pClient;
    
    private final Date date = new Date(Calendar.getInstance().getTimeInMillis());//Data del dia actual

    /**
     * Crea una finestra per comprar un nou producte
     * @author manel bosch
     * @param parent finestra mare
     * @param modal manté el focus fins a tancar la finestra
     * @param usuario Usuari que està connectat al programa
     * @param cliente Client que fa la compra
     * @param producto Producte a adquirir
     */
    public BuyProductDialog(java.awt.Frame parent, boolean modal, Usuario usuario, Cliente cliente, Producto producto) {
        super(parent, modal);
        this.usuario = usuario;
        this.cliente = cliente;
        this.producto = producto;
        openClient();
        initComponents();
        fillData();
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
        jLabelProductName = new javax.swing.JLabel();
        jTextFieldProducte = new javax.swing.JTextField();
        jLabelDate = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jLabelUnits = new javax.swing.JLabel();
        jTextFieldUnits = new javax.swing.JTextField();
        jLabelQuantity = new javax.swing.JLabel();
        jTextFieldQuantity = new javax.swing.JTextField();
        jPanelBotons = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelTitol.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabelTitol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitol.setText("GestLab: Compra");

        jLabelProductName.setText("Producte:");

        jLabelDate.setText("Data:");

        jLabelUnits.setText("Unitats:");

        jLabelQuantity.setText("Quantitat:");

        jTextFieldQuantity.setName("quantityText"); // NOI18N

        javax.swing.GroupLayout jPanelDadesProducteLayout = new javax.swing.GroupLayout(jPanelDadesProducte);
        jPanelDadesProducte.setLayout(jPanelDadesProducteLayout);
        jPanelDadesProducteLayout.setHorizontalGroup(
            jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesProducteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProductName)
                    .addComponent(jLabelDate)
                    .addComponent(jLabelUnits)
                    .addComponent(jLabelQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldQuantity)
                    .addComponent(jTextFieldUnits, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jTextFieldDate)
                    .addComponent(jTextFieldProducte))
                .addContainerGap())
        );
        jPanelDadesProducteLayout.setVerticalGroup(
            jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadesProducteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProducte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProductName))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantity)
                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesProducteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUnits))
                .addContainerGap())
        );

        jButtonSave.setText("Guardar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );

        jPanelBotonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonSave});

        jPanelBotonsLayout.setVerticalGroup(
            jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
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
                        .addComponent(jLabelTitol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelBotons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelDadesProducte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        HistorialProductos hp = new HistorialProductos();
        hp.setFechaCompra(date);
        hp.setIdcliente(cliente);
        hp.setIdproducto(producto);
        float amount = getAmount();
        if(amount != 0){
            hp.setCantidad(amount);
            int done = hpClient.create_JSON(hp);
            hpClient.close();
            if(done == 204 || done == 200){
                updateProduct(amount);
            }
        }
        this.dispose(); 
    }//GEN-LAST:event_jButtonSaveActionPerformed

    /**
     * Mètode per cancelar l'entrada de dades i per tant tancar la finestra
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        hpClient.close();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelProductName;
    private javax.swing.JLabel jLabelQuantity;
    private javax.swing.JLabel jLabelTitol;
    private javax.swing.JLabel jLabelUnits;
    private javax.swing.JPanel jPanelBotons;
    private javax.swing.JPanel jPanelDadesProducte;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldProducte;
    private javax.swing.JTextField jTextFieldQuantity;
    private javax.swing.JTextField jTextFieldUnits;
    // End of variables declaration//GEN-END:variables

    /**
     * Mètode per inicialitzar el HistorialProductosClientSsl que accedirà al servei RESTful
     * @author manel bosch
     */
    private void openClient(){
        hpClient = new HistorialProductosClientSsl(usuario.getToken());
    }
    
    /**
     * Mètode per omplir els camps de text
     * @author manel bosch
     */
    private void fillData(){
        jTextFieldProducte.setText(producto.getNombre());
        jTextFieldDate.setText(date.toString());
        jTextFieldUnits.setText(producto.getUnidades());
        jTextFieldQuantity.setText("");
    }
    
    /**
     * Mètode per llegir la quantitat de producte desitjada
     * @author manel bosch
     * @return quantitat de producte desitjat
     */
    private float getAmount(){
        if(correctAmount()){
            return Float.parseFloat(jTextFieldQuantity.getText());
        }else{
            return 0;
        }
    }
    
    /**
     * Mètode per saber si la quantitat entrada és un valor correcte i és menor que el stock del producte
     * @author manel bosch
     * @return true o false
     */
    public boolean correctAmount(){
        String amountString = jTextFieldQuantity.getText();
        float amount = 0;
        try {
            amount = Float.parseFloat(amountString);
            if(amount <= producto.getCantidad()){
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"La quantitat entrada és més gran que el stock","Alert !!",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"La quantitat entrada no és un valor correcte","Alert !!",JOptionPane.WARNING_MESSAGE);
            return false;    
        }    
    }
    
    /**
     * Mètode per actualitzar la quantitat que queda d'stcok del producte comprat
     * @author manel bosch
     * @param f quantitat comprada
     */
    public void updateProduct(float f){
        pClient = new ProductoClientSsl(usuario.getToken());
        producto.setCantidad(producto.getCantidad() - f);
        pClient.edit_JSON(producto, String.valueOf(producto.getId()));
        pClient.close();
    }
}
