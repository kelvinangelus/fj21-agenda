package br.com.caelum.jdbc.dao;

//Esta classe gerencia a conexão e
//insere Contatos no banco de dados

import Util.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoDao {
    //Uma instância de conexão com o banco de dados
    private Connection connection = null;

    //Construtor
    public ContatoDao() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Exercício página 145
    public ContatoDao(Connection connection){ //Injeta a dependência Connection
        this.connection = connection;
    }

    public void adiciona(Contato contato){
        String sql = "insert into contatos " +
                "(nome, email, endereco, dataNascimento)" +
                " values(?,?,?,?)";

        try{
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            //Seta os valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

            //Executa a consulta
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Este método retorna uma lista com os contatos
    public List<Contato> getLista(){
        try{
            List<Contato> contatos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from contatos"); // where nome like 'c%'

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                //criando o objeto Contato
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                //Montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                //Adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close(); //Fecha o resultSet
            stmt.close(); //Fecha o preparedStatement
            return contatos;

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            throw new RuntimeException(e); //Exercício 2.15 - 2
        }
    }

    //Pesquisa por um contato pelo id. Exercício 2.15 - 4
    public Contato pesquisar(int id){
        List<Contato> contatos;
        contatos = getLista();

        for(Contato contato : contatos){
            if (contato.getId() == id){
                return contato;
            }
        }
        return null;

    }

    public void altera(Contato contato) throws SQLException {
        String SQL = "update contatos set nome = ?, email = ?," +
                "endereco = ?, dataNascimento = ? where id = ?"; //, dataNascimento = ?

        PreparedStatement stmt = connection.prepareStatement(SQL);
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getEndereco());

        //dataNascimento é do tipo Calendar.
        //dataSQL: objeto de java.sql.Date. Date(dataSQL) converte o valor
        //passado em milisegundos para um formato aceito para o tipo Date
        //usado no SQL (onde as horas, minutos e segundos são 0)
        
        long data_milisegundos = contato.getDataNascimento().getTimeInMillis();
        Date dataSQL = new Date(data_milisegundos); //Nova instância de java.sql.Date. Construtor recebe um long
        stmt.setDate(4, dataSQL); //Espera um java.sql.Date
        
        
        stmt.setLong(5, contato.getId()); //stmt.setLong(5, contato.getId());

        stmt.execute(); //Executa a consulta SQL no banco
        stmt.close();
    }

    public void apagar (long id) throws SQLException {
        //Contato contato;

        String SQL = "delete from contatos where id = ?";

        PreparedStatement stmt = connection.prepareStatement(SQL);

        stmt.setLong(1, id);

        stmt.execute();
        stmt.close();

    }

    public void exibe() {
        List<Contato> contatos = getLista();

        if(contatos.isEmpty()){
            System.out.println("Não há contatos para exibir");
        }else{
            for (Contato contato : contatos) {
                System.out.println("id: " + contato.getId());
                System.out.println("nome: " + contato.getNome());
                System.out.println("email: " + contato.getEmail());
                System.out.println(("endereco: " + contato.getEndereco()));

                //Exercício opcional 1 pag 29
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String result = formatter.format(contato.getDataNascimento().getTime());
                System.out.println("Nascimento: " +  result + "\n");
            }
        }
    }

    public void remover(Contato contato){
        String SQL = "delete from contatos where id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(SQL);
            stmt.setLong(1, contato.getId());

            stmt.execute();
            stmt.close();
        }catch(SQLException e) {
            new RuntimeException(e);
        }
    }
}
