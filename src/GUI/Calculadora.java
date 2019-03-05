/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Herramientas.Operaciones;
import Herramientas.expresionRegular;
import Objetos.Complejo;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author abam_
 */
public class Calculadora extends javax.swing.JFrame {

    /**
     * Creates new form Calculadora
     */
    //expresionRegular x = new expresionRegular();
    Graficadora G = new Graficadora();
    Complejo ans = new Complejo(0,0);
    Complejo ans1 = new Complejo(0,0);
    boolean focused;
    char op = '+';
    
    public Calculadora() {
        initComponents();
        graficar();
        real.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                focused = true;
            }

            @Override
            public void focusLost(FocusEvent fe) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        imaginario.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                focused = false;
            }

            @Override
            public void focusLost(FocusEvent fe) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
        
        
    }
    
    public void mostrar(){
        real.setText("");
        imaginario.setText("");
        if(ans.getImg()==0&&ans.getRe()==0) Pol.setText("0");
        else Pol.setText(""+ans.modulo()+"( cos("+ans.formaPolar()+")+ i sen("+ans.formaPolar()+") )");
        if(ans.getImg()>=0)Rec.setText("( "+ans.getRe()+" + "+ans.getImg()+"i )");
        else Rec.setText("( "+ans.getRe()+" "+ans.getImg()+"i )");
    }
    
    public void graficar(){
        Graficadora G = new Graficadora();
        G.addVector(ans.getRe(), ans.getImg());
        ChartPanel panel = new ChartPanel(G.Chart);        
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panel);   
        jPanel1.validate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        real = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        igual = new javax.swing.JButton();
        cero = new javax.swing.JButton();
        uno = new javax.swing.JButton();
        dos = new javax.swing.JButton();
        tres = new javax.swing.JButton();
        cuatro = new javax.swing.JButton();
        cinco = new javax.swing.JButton();
        uno5 = new javax.swing.JButton();
        siete = new javax.swing.JButton();
        ocho = new javax.swing.JButton();
        nueve = new javax.swing.JButton();
        mas = new javax.swing.JButton();
        menos = new javax.swing.JButton();
        por = new javax.swing.JButton();
        imaginario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ce = new javax.swing.JButton();
        entre = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Pol = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Rec = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        real.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        real.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                realKeyTyped(evt);
            }
        });
        getContentPane().add(real, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 45, 106, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 650, 360));

        igual.setText("=");
        igual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                igualActionPerformed(evt);
            }
        });
        getContentPane().add(igual, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 297, 220, 50));

        cero.setText("0");
        cero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceroActionPerformed(evt);
            }
        });
        getContentPane().add(cero, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 240, 51, 51));

        uno.setText("1");
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });
        getContentPane().add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 183, 51, 50));

        dos.setText("2");
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });
        getContentPane().add(dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 183, 50, 51));

        tres.setText("3");
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });
        getContentPane().add(tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 183, 50, 50));

        cuatro.setText("4");
        cuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroActionPerformed(evt);
            }
        });
        getContentPane().add(cuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 127, 50, 50));

        cinco.setText("5");
        cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cincoActionPerformed(evt);
            }
        });
        getContentPane().add(cinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 127, 50, 50));

        uno5.setText("6");
        uno5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno5ActionPerformed(evt);
            }
        });
        getContentPane().add(uno5, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 127, 50, 50));

        siete.setText("7");
        siete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sieteActionPerformed(evt);
            }
        });
        getContentPane().add(siete, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 71, 50, 50));

        ocho.setText("8");
        ocho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ochoActionPerformed(evt);
            }
        });
        getContentPane().add(ocho, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 71, 50, 50));

        nueve.setText("9");
        nueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueveActionPerformed(evt);
            }
        });
        getContentPane().add(nueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 71, 50, 50));

        mas.setText("+");
        mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masActionPerformed(evt);
            }
        });
        getContentPane().add(mas, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 71, 50, 50));

        menos.setText("-");
        menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosActionPerformed(evt);
            }
        });
        getContentPane().add(menos, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 127, 50, 50));

        por.setText("x");
        por.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porActionPerformed(evt);
            }
        });
        getContentPane().add(por, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 183, 50, 51));

        imaginario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        imaginario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                imaginarioKeyTyped(evt);
            }
        });
        getContentPane().add(imaginario, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 45, 106, -1));

        jLabel1.setText("i");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 48, -1, -1));

        ce.setText("CE");
        ce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceActionPerformed(evt);
            }
        });
        getContentPane().add(ce, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 240, 50, 51));

        entre.setText("/");
        entre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entreActionPerformed(evt);
            }
        });
        getContentPane().add(entre, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 240, 50, 51));

        jButton1.setText("Z'");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 51, 50));

        jButton3.setText("Raíz");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 351, -1, 50));

        jLabel2.setText("Con n=");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 369, 80, -1));

        jTextField1.setText("1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 366, 30, -1));

        jLabel3.setText("Resultado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel4.setText("Forma Polar: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        Pol.setText("0(cos(0)+isen(0))");
        getContentPane().add(Pol, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, -1, -1));

        jLabel6.setText("Forma Rectangular: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        Rec.setText("(0+0i)");
        getContentPane().add(Rec, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        jLabel5.setText("Im");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 20, -1, -1));

        jLabel7.setText("Re");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, -1, -1));

        jButton4.setText("(-)");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 240, 51, 50));

        jButton5.setText("Graficar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void igualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_igualActionPerformed
        ans1.setRe(Float.parseFloat(real.getText()));
        ans1.setImg(Float.parseFloat(imaginario.getText()));
        switch(op){
            case '+':
                ans = Operaciones.suma(ans, ans1);
                break;
            case '-':
                ans = Operaciones.resta(ans, ans1);
                break;
            case '*':
                ans = Operaciones.multiplicacion(ans, ans1);
                break;
            case '/':
                ans = Operaciones.division(ans, ans1);
                break;
        }
        mostrar();
        
    }//GEN-LAST:event_igualActionPerformed

    private void realKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_realKeyTyped
        // TODO add your handling code here:
        /*char validar = evt.getKeyChar();
        boolean sumita = false;
        System.out.println(validar);
        /*if (validar == '+') {
            siete.doClick();
        }
        if(Character.isDigit(validar) || validar == 'i' || validar == '+' || validar == '-' || validar == ' '){
            
        }else{
            evt.consume();
        }
        switch(validar){
            case '+':
                ans.setRe(Float.parseFloat(real.getText()));
                ans.setImg(Float.parseFloat(imaginario.getText()));
                break;
            case '-':
                ans.setRe(Float.parseFloat(real.getText()));
                ans.setImg(Float.parseFloat(imaginario.getText()));
                break;
            case '*':
                ans.setRe(Float.parseFloat(real.getText()));
                ans.setImg(Float.parseFloat(imaginario.getText()));
                break;
            case '/':
                ans.setRe(Float.parseFloat(real.getText()));
                ans.setImg(Float.parseFloat(imaginario.getText()));
                break;
        }*/
        //System.out.println(ans.getRe()+" "+ans.getImg()+"i");
        
    }//GEN-LAST:event_realKeyTyped

    private void sieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sieteActionPerformed
        if(focused)real.setText(real.getText()+"7");
        else imaginario.setText(imaginario.getText()+"7");
        
    }//GEN-LAST:event_sieteActionPerformed

    private void ceroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceroActionPerformed
        if(focused)real.setText(real.getText()+"0");
        else imaginario.setText(imaginario.getText()+"0");
    }//GEN-LAST:event_ceroActionPerformed

    private void menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosActionPerformed
        if(ans.getRe()==0 && ans.getImg()==0){
            //System.out.println("AHH");
            ans.setImg(Float.parseFloat(imaginario.getText()));
            ans.setRe(Float.parseFloat(real.getText()));
        }else{
            ans1.setImg(Float.parseFloat(imaginario.getText()));
            ans1.setRe(Float.parseFloat(real.getText()));
             ans = Operaciones.resta(ans, ans1);
                    
        }
        //System.out.println(ans.getRe()+" "+ ans.getImg());
        op = '-';
         
        mostrar();
        
    }//GEN-LAST:event_menosActionPerformed

    private void imaginarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imaginarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_imaginarioKeyTyped

    private void masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masActionPerformed
        if(ans.getRe()==0 && ans.getImg()==0){
            //System.out.println("AHH");
            ans.setImg(Float.parseFloat(imaginario.getText()));
            ans.setRe(Float.parseFloat(real.getText()));
        }else{
            ans1.setImg(Float.parseFloat(imaginario.getText()));
            ans1.setRe(Float.parseFloat(real.getText()));
             ans = Operaciones.suma(ans, ans1);
                    
        }
         op = '+';
        //System.out.println(ans.getRe()+" "+ ans.getImg());
        mostrar();
        
        
        
        
    }//GEN-LAST:event_masActionPerformed

    private void porActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porActionPerformed
        if(ans.getRe()==0 && ans.getImg()==0){
            //System.out.println("AHH");
            ans.setImg(Float.parseFloat(imaginario.getText()));
            ans.setRe(Float.parseFloat(real.getText()));
        }else{
            ans1.setImg(Float.parseFloat(imaginario.getText()));
            ans1.setRe(Float.parseFloat(real.getText()));
             ans = Operaciones.multiplicacion(ans, ans1);
                    
        }
        //System.out.println(ans.getRe()+" "+ ans.getImg());
        op = 'x';
        mostrar();
         
    }//GEN-LAST:event_porActionPerformed

    private void entreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entreActionPerformed
        if(ans.getRe()==0 && ans.getImg()==0){
            //System.out.println("AHH");
            ans.setImg(Float.parseFloat(imaginario.getText()));
            ans.setRe(Float.parseFloat(real.getText()));
        }else{
            ans1.setImg(Float.parseFloat(imaginario.getText()));
            ans1.setRe(Float.parseFloat(real.getText()));
             ans = Operaciones.division(ans, ans1);
                    
        }
        //System.out.println(ans.getRe()+" "+ ans.getImg());
        op = '/';
        mostrar();
         
    }//GEN-LAST:event_entreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(ans.getRe()==0 && ans.getImg()==0){
            //System.out.println("AHH");
            ans.setImg(Float.parseFloat(imaginario.getText()));
            ans.setRe(Float.parseFloat(real.getText()));}
        ans.setImg(-1*ans.getImg());
        mostrar();
         
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceActionPerformed
        ans = new Complejo(0,0);
        ans1= new Complejo(0,0);
        mostrar();
        graficar();
        
    }//GEN-LAST:event_ceActionPerformed

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
        if(focused)real.setText(real.getText()+"1");
        else imaginario.setText(imaginario.getText()+"1");
    }//GEN-LAST:event_unoActionPerformed

    private void dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosActionPerformed
        if(focused)real.setText(real.getText()+"2");
        else imaginario.setText(imaginario.getText()+"2");
    }//GEN-LAST:event_dosActionPerformed

    private void tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresActionPerformed
        if(focused)real.setText(real.getText()+"3");
        else imaginario.setText(imaginario.getText()+"3");
    }//GEN-LAST:event_tresActionPerformed

    private void cuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatroActionPerformed
        if(focused)real.setText(real.getText()+"4");
        else imaginario.setText(imaginario.getText()+"4");
    }//GEN-LAST:event_cuatroActionPerformed

    private void cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cincoActionPerformed
        if(focused)real.setText(real.getText()+"5");
        else imaginario.setText(imaginario.getText()+"5");
    }//GEN-LAST:event_cincoActionPerformed

    private void uno5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno5ActionPerformed
        if(focused)real.setText(real.getText()+"6");
        else imaginario.setText(imaginario.getText()+"6");
    }//GEN-LAST:event_uno5ActionPerformed

    private void ochoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ochoActionPerformed
        if(focused)real.setText(real.getText()+"8");
        else imaginario.setText(imaginario.getText()+"8");
    }//GEN-LAST:event_ochoActionPerformed

    private void nueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueveActionPerformed
        if(focused)real.setText(real.getText()+"9");
        else imaginario.setText(imaginario.getText()+"9");
    }//GEN-LAST:event_nueveActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(focused)real.setText(real.getText()+"-");
        else imaginario.setText(imaginario.getText()+"-");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        graficar();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pol;
    private javax.swing.JLabel Rec;
    private javax.swing.JButton ce;
    private javax.swing.JButton cero;
    private javax.swing.JButton cinco;
    private javax.swing.JButton cuatro;
    private javax.swing.JButton dos;
    private javax.swing.JButton entre;
    private javax.swing.JButton igual;
    private javax.swing.JTextField imaginario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton mas;
    private javax.swing.JButton menos;
    private javax.swing.JButton nueve;
    private javax.swing.JButton ocho;
    private javax.swing.JButton por;
    private javax.swing.JTextField real;
    private javax.swing.JButton siete;
    private javax.swing.JButton tres;
    private javax.swing.JButton uno;
    private javax.swing.JButton uno5;
    // End of variables declaration//GEN-END:variables
}
