
package Ultilitario;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conecao_com_banco {
    
    public  Statement stm;
    public  ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/agenda";
    private String usuario = "postgres";
    private String senha = "Hi<aki>08";
    public  Connection conn;
    
    public void conexao(){
        try {
              System.setProperty("jdbc.Drivers", driver);
              
            conn = DriverManager.getConnection(caminho, usuario, senha);
            
            JOptionPane.showMessageDialog(null, "Conectado");
            System.out.println("Conectado");
            
        } catch (SQLException ex) {
            Logger.getLogger(Conecao_com_banco.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null, "Erro ao  \n"+ ex.getMessage());
        }
    }
   


    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conecao_com_banco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar");
        }
    }
    
    
    
}
