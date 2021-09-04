/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4.proyectoparqueadero;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Roger Cabrera
 */
public class Retirar extends javax.swing.JFrame {

    Conexion conexion;

    public Retirar(Conexion conexion) {
        this.conexion = conexion;
        initComponents();
        setTitle("ParqUeadero SanmarqUino");
    }

    public void retirarAuto() {
        try {
            String placa = jTextFieldRetirarPlaca.getText().trim();
            int bandera = 0;
            int id = 0;
            String hora_entrada = ""; //Para que la hora de salida sea mayor a la hora de entrada
            String minuto_entrada = ""; //Para que los minutos de salida sean mayor a la hora de entrada
            PreparedStatement ps = this.conexion.getConexion().prepareStatement("select * from parqueo where placa=? and estado=?");
            ps.setString(1, placa);
            ps.setInt(2, 1);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                bandera++;
                id = rs.getInt(1);
                hora_entrada = rs.getString(7);
                minuto_entrada = rs.getString(8);
            }
            //Si la bandera es 0, no se encuentra la placa en el parqueo
            if (bandera == 0) {
                JOptionPane.showMessageDialog(null, "El vehícUlo con nro de placa "
                        + placa + " no se encUentra actUalmente parqUeado");
            } else {
                //Si la hora para retirar el auto es la misma a la hora de entrada
                //se compara los minutos
                if (Integer.parseInt(hora_entrada) == Integer.parseInt(this.jComboBoxHoraSalida.getSelectedItem().toString())) {
                    //Si el minuto de entrada es menor a la de salida, es valido y se retira el auto
                    if (Integer.parseInt(minuto_entrada) < Integer.parseInt(this.jComboBoxMinutoSalida.getSelectedItem().toString())) {
                        PreparedStatement ps1 = this.conexion.getConexion().prepareStatement("Update parqueo set estado=?, hora_salida=?, minuto_salida=? where id_parqueo=?");
                        ps1.setInt(1, 0);
                        ps1.setString(2, this.jComboBoxHoraSalida.getSelectedItem().toString());
                        ps1.setString(3, this.jComboBoxMinutoSalida.getSelectedItem().toString());
                        ps1.setInt(4, id);
                        ps1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "aUto retirado");
                    } else { //Si la hora y los minutos son iguales, datos erroneos
                        JOptionPane.showMessageDialog(null, "ingresar bien la hora de salida");
                    }

                } else { 
                    //Si la hora de entrada es menor a la de salida, es correcto y continúa                    
                        if (Integer.parseInt(hora_entrada) < Integer.parseInt(this.jComboBoxHoraSalida.getSelectedItem().toString())) {
                            PreparedStatement ps1 = this.conexion.getConexion().prepareStatement("Update parqueo set estado=?, hora_salida=?, minuto_salida=? where id_parqueo=?");
                            ps1.setInt(1, 0);
                            ps1.setString(2, this.jComboBoxHoraSalida.getSelectedItem().toString());
                            ps1.setString(3, this.jComboBoxMinutoSalida.getSelectedItem().toString());
                            ps1.setInt(4, id);
                            ps1.executeUpdate();
                            JOptionPane.showMessageDialog(null, "aUto retirado");
                        }
                     else { //Si la hora de entrada es mayor a la de salida, error
                        JOptionPane.showMessageDialog(null, "ingresar bien la hora de salida");
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldRetirarPlaca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxHoraSalida = new javax.swing.JComboBox<>();
        jComboBoxMinutoSalida = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("   Parqueadero Sanmarquino");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g4/proyectoparqueadero/Icono (3).png"))); // NOI18N
        jLabel4.setMaximumSize(new java.awt.Dimension(200, 205));

        jLabel1.setText("Retirar un Vehículo");

        jLabel6.setText("Placa");

        jTextFieldRetirarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRetirarPlacaActionPerformed(evt);
            }
        });

        jLabel8.setText("Hora de salida");

        jComboBoxHoraSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00", "01", "02", "03", "04", "05", "06" }));
        jComboBoxHoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHoraSalidaActionPerformed(evt);
            }
        });

        jComboBoxMinutoSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        jComboBoxMinutoSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMinutoSalidaActionPerformed(evt);
            }
        });

        jButton1.setText("Retirar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jComboBoxHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxMinutoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldRetirarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldRetirarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxMinutoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldRetirarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRetirarPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRetirarPlacaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Menu abrir = new Menu();
        abrir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jTextFieldRetirarPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete el campo");
        } else {
            retirarAuto();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxHoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHoraSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxHoraSalidaActionPerformed

    private void jComboBoxMinutoSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMinutoSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMinutoSalidaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxHoraSalida;
    private javax.swing.JComboBox<String> jComboBoxMinutoSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldRetirarPlaca;
    // End of variables declaration//GEN-END:variables
}
