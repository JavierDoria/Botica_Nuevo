/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sise.botica;
import com.formdev.flatlaf.FlatDarkLaf;
import com.sise.botica.ui.Login;
import javax.swing.UIManager;
/**
 *
 * @author jjjja
 */
//clase main del proyecto
public class Main {
    public static void main(String[] args) {
    try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLaf Dark".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            Login login = new Login(); 
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

