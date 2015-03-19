/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.isw;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Loucry
 */
public class Controlador extends javax.swing.JFrame {
    protected static boolean admin;
    
    public void Error (String Mensaje){
        IError Ventana = new IError();
        Ventana.setVisible(true);
        Ventana.Mensaje.setText(Mensaje);
    }
    
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
            java.util.logging.Logger.getLogger(IInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FileReader fr = null; 
                BufferedReader br = null;
                Scanner in = null;
                String path = ("src/files/ciudadesVzla.txt");
                try {
                    fr = new FileReader (path);
                    br = new BufferedReader(fr);
                    in = new Scanner (fr);
                }catch (FileNotFoundException e){
                    System.out.println ("File Not Found");
                }finally{
                    // En el finally cerramos el fichero, para asegurarnos
                    // que se cierra tanto si todo va bien como si salta 
                    // una excepcion.
                    try{
                        if( null != in ){   
                            in.close();     
                        }
                        if( null != br ){   
                            br.close();     
                        }
                        if( null != fr ){   
                            fr.close();     
                        }
                    }catch (IOException e2){ 
                    }
                }
                String NombresLista [] = new String [4];
                NombresLista[0] = "Oriente";
                NombresLista[1] = "Occidente";
                NombresLista[2] = "Los Andes";
                NombresLista[3] = "Guayana";
                Lista Listas[] = new Lista [4];
                for (int i = 0; i < 4; i++){
                    Listas [i] = new Lista(NombresLista[i]);
                }
                
                
                
                new IInicio().setVisible(true);
                
            }
        });
    }
}
