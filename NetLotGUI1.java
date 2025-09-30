package netmanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.IOException;

public class NetLotGUI1 extends javax.swing.JFrame {

    public NetLotGUI1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtMachine = new javax.swing.JTextField();

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        btnAdd = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        btnCalculate = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton(); // ✅ nút remove

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Net Management System");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel3.setText("Phone");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel4.setText("Machine");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Id", "Name", "Phone", "Machine"}
        ));
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setText("Add Client");
        btnAdd.addActionListener(evt -> addClient());

        btnDisplay.setText("Display Client");
        btnDisplay.addActionListener(evt -> displayClient());

        btnCalculate.setText("Calculate Fee");
        btnCalculate.addActionListener(evt -> calculateFee());

        btnFind.setText("Find Client");
        btnFind.addActionListener(evt -> findClient());

        btnList.setText("List Clients");
        btnList.addActionListener(evt -> listClients());

        btnExport.setText("Export File");
        btnExport.addActionListener(evt -> exportClients());

        btnRemove.setText("Remove Client"); // ✅ gán text
        btnRemove.addActionListener(evt -> removeClient()); // ✅ gắn sự kiện

        // layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtId)
                        .addComponent(txtName)
                        .addComponent(txtPhone)
                        .addComponent(txtMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(btnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(btnCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(btnList, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)) // ✅ thêm nút Remove
                    .addContainerGap(60, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDisplay))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCalculate))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFind))
                    .addGap(15)
                    .addComponent(btnList)
                    .addGap(15)
                    .addComponent(btnExport)
                    .addGap(15)
                    .addComponent(btnRemove) // ✅ thêm vào giao diện
                    .addGap(15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    // ========== FUNCTIONS ==========

    private void addClient() {
        if (txtId.getText().trim().equals("") ||
            txtName.getText().trim().equals("") ||
            txtPhone.getText().trim().equals("") ||
            txtMachine.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all data!");
            return;
        }
        String[] data = {txtId.getText(), txtName.getText(), txtPhone.getText(), txtMachine.getText()};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(data);
        JOptionPane.showMessageDialog(this, "Client added successfully!");
        txtId.setText(""); txtName.setText(""); txtPhone.setText(""); txtMachine.setText("");
    }

    private void displayClient() {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a client from the table!");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String info = "Id: " + model.getValueAt(row, 0) +
                      "\nName: " + model.getValueAt(row, 1) +
                      "\nPhone: " + model.getValueAt(row, 2) +
                      "\nMachine: " + model.getValueAt(row, 3);
        JOptionPane.showMessageDialog(this, info, "Client Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void calculateFee() {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a client!");
            return;
        }
        int hours = 2; // ví dụ: số giờ chơi
        int rate = 10000; // giá/giờ
        int fee = hours * rate;
        JOptionPane.showMessageDialog(this, "Fee for client: " + fee + " VND");
    }

    private void findClient() {
        String searchId = JOptionPane.showInputDialog(this, "Enter Client Id:");
        if (searchId == null || searchId.trim().equals("")) return;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (searchId.equals(model.getValueAt(i, 0).toString())) {
                jTable1.setRowSelectionInterval(i, i);
                JOptionPane.showMessageDialog(this, "Client found: " + model.getValueAt(i, 1));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Client not found!");
    }

    private void listClients() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No clients available!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < model.getRowCount(); i++) {
            sb.append(model.getValueAt(i, 0)).append(" - ")
              .append(model.getValueAt(i, 1)).append(" - ")
              .append(model.getValueAt(i, 2)).append(" - ")
              .append(model.getValueAt(i, 3)).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "All Clients", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exportClients() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No clients to export!");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Clients as CSV");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (FileWriter fw = new FileWriter(fileChooser.getSelectedFile() + ".csv")) {
                // Ghi header
                for (int i = 0; i < model.getColumnCount(); i++) {
                    fw.write(model.getColumnName(i) + (i == model.getColumnCount() - 1 ? "" : ","));
                }
                fw.write("\n");

                // Ghi dữ liệu
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        fw.write(model.getValueAt(i, j).toString() + (j == model.getColumnCount() - 1 ? "" : ","));
                    }
                    fw.write("\n");
                }

                JOptionPane.showMessageDialog(this, "Export successful!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
            }
        }
    }

    // ✅ HÀM REMOVE CLIENT
    private void removeClient() {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a client to remove!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to remove this client?",
                "Confirm Remove",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(row);
            JOptionPane.showMessageDialog(this, "Client removed successfully!");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new NetLotGUI1().setVisible(true);
        });
    }

    // Variables
    private javax.swing.JButton btnAdd, btnDisplay, btnCalculate, btnFind, btnList, btnExport, btnRemove; // ✅ thêm btnRemove
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtId, txtName, txtPhone, txtMachine;
}
