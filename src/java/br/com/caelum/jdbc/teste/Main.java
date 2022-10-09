/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/

package br.com.caelum.jdbc.teste;

import Util.ConnectionFactory;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Kelvin Angelus
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
    /*  
    Connection connection;
    
        //O construtor default de ConnectionFactory retorna um objeto ConnectionFactory
        //O método getConnection() do objeto ConnectionFactory é invocado
        connection = new ConnectionFactory().getConnection();
    
        //Se a conexão suceder
        System.out.println("Conexão aberta");
        connection.close();
   
    }  // TODO code application logic here 
*/
    
    //Cria um objeto de acesso aos dados
        ContatoDao dao = new ContatoDao();

        //Inserir a data neste novo contato
        Calendar c = Calendar.getInstance();
        c.set(1988, Calendar.JULY, 07);

        //Criar um novo contato
        Contato contato = new Contato(6L, "Lisa", "lisalorena@gmail.com", "Salvador", c);

        //System.out.println(contato.getDataCadastroFormatado());
        //dao.adiciona(contato);
    }
}
