/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Reporting_Agency_AdminPanel;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Position;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.Organization.ReportOrganization;
import UI_GoogleMap.Organization_Postion_Panel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author purva
 */
public class ReportingAgency_Organization_ManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportingAgency_Organization_ManagementPanel
     */
    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private Enterprise enterprise;
    private EcoSystem system;
    private Position position;

    public ReportingAgency_Organization_ManagementPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.enterprise = enterprise;
        this.organizationDirectory = enterprise.getOrganizationDirectory();

        populateCombo();
        populateTable();

    }

    private void populateCombo() {
        organizationJComboBox.removeAllItems();
        organizationJComboBox.addItem(Organization.Type.ReportingAgency);
        //  }
    }

    public void populateLatLong(Position position) {
        this.position = position;
        latLongTextField.setText(position.getLatitude() + "," + position.getLongitude());
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();

        model.setRowCount(0);

        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {

                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof ReportOrganization) {
                        ReportOrganization org = (ReportOrganization) organization;
                        Object[] row = new Object[3];
                        row[0] = enterprise.getName();
                        row[1] = org.getReport();
                        row[2] = org.getPosition();

                        model.addRow(row);
                    }
                }
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        backJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        orgNameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        latLongTextField = new javax.swing.JTextField();
        locationBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Organization Name", "Org Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 60, 480, 92));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Organization Type:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        organizationJComboBox.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(102, 0, 102));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 150, -1));

        backJButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(102, 0, 102));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        addJButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        addJButton.setForeground(new java.awt.Color(102, 0, 102));
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Manage Agency Organizations");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 380, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/icons/Home_48px.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Organization Name:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        orgNameTextField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        orgNameTextField.setForeground(new java.awt.Color(102, 0, 102));
        add(orgNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 150, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Set Location:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        latLongTextField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        latLongTextField.setForeground(new java.awt.Color(102, 0, 102));
        add(latLongTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 150, -1));

        locationBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        locationBtn.setForeground(new java.awt.Color(102, 0, 102));
        locationBtn.setText("Set Location");
        locationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationBtnActionPerformed(evt);
            }
        });
        add(locationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/icons/587596-636367491488700134-16x9.jpg"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 730, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
           if(orgNameTextField.getText().equals(o.getName())){
                JOptionPane.showMessageDialog(null,"Organisation Already Exists", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        Type type = (Type) organizationJComboBox.getSelectedItem();
        organizationDirectory.createOrganization(type, orgNameTextField.getText(), position);
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed
    
    private void locationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationBtnActionPerformed
        // TODO add your handling code here:
        Organization_Postion_Panel muajp = new Organization_Postion_Panel(userProcessContainer);
       userProcessContainer.add("Organization_Postion_Panel", muajp);
       CardLayout layout = (CardLayout) userProcessContainer.getLayout();
      layout.next(userProcessContainer);
    }//GEN-LAST:event_locationBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField latLongTextField;
    private javax.swing.JButton locationBtn;
    private javax.swing.JTextField orgNameTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
