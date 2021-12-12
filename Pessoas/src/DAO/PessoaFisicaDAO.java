package DAO;
import Connection.ConnectionFactory;
import Model.PessoaFisica;
import Model.PessoaJuridica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {
    private Connection connection; // vai acessar o banco

    public PessoaFisicaDAO() {
        this.connection = new ConnectionFactory().getConnection();
        CriarTabelaPessoaFisica();
    }

    private void CriarTabelaPessoaFisica(){ // query é vc fazer um ação no banco
        // quando vc criar essa tabela o primeiro Id vai ser 1
        // se vc tem o autoincrement , vc nao precisa passar um id para o banco, o banco adicionar 1 ao Id , resultando em 2
        try {
            String sql = "CREATE TABLE IF not exists PessoaFisica " +
                    "(IdPessoa BIGINT not NULL AUTO_INCREMENT, " +
                    " PRIMARY KEY (IdPessoa) , " +
                    " IdPessoaJuridica INT not NULL , " +
                    " NomePessoa VARCHAR(100), " +
                    " Idade INT , " +
                    " Endereco VARCHAR(100), " +
                    " Cpf VARCHAR(12)," +
                    " FOREIGN KEY (IdPessoaJuridica) REFERENCES PessoaJuridica(IdPessoaJ) ON DELETE CASCADE)";
            Statement statement = connection.createStatement();//
            statement.execute(sql);
            statement.close();
        }
        catch (SQLException e){
            throw  new RuntimeException();
        }
    }
    public void inserirPessoaFisica(PessoaFisica pessoaFisica){
        try {
            String sql = "INSERT INTO PessoaFisica " + "(NomePessoa, Idade, Endereco, Cpf, IdPessoaJuridica)" + "VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoaFisica.getNome());
            preparedStatement.setInt(2,pessoaFisica.getIdade());
            preparedStatement.setString(3, pessoaFisica.getEndereco());
            preparedStatement.setString(4, pessoaFisica.getCpf());
            preparedStatement.setInt(5, pessoaFisica.getPessoaJuridica().getId());
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public List<PessoaFisica> listarPessoasFisicas(){
        try {
            String sql = "SELECT * FROM PessoaFisica ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            return listar(resultSet);
        }catch (SQLException e){
            throw new RuntimeException();
        }

     }
     public List<PessoaFisica> listarPessoasFisicasPorIdPessoaJuridica(int idPessoaJuridica){
       try {
           String sql = "SELECT * FROM PessoaFisica WHERE IdPessoaJuridica = ? ";
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setInt(1, idPessoaJuridica);
           statement.execute();
           ResultSet resultSet = statement.executeQuery();
           return listar(resultSet);
       }catch (SQLException e){
           throw new RuntimeException();
       }
     }
    public List<PessoaFisica> listar(ResultSet resultSet){
        List<PessoaFisica> list = new ArrayList<>();
        PessoaFisica pessoaFisica;
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        try {
            while (resultSet.next()){
                pessoaFisica = new PessoaFisica();
                pessoaJuridica = new PessoaJuridica();
                pessoaFisica.setNome(resultSet.getString("NomePessoa"));
                pessoaFisica.setCpf(resultSet.getString("Cpf"));
                pessoaFisica.setIdade(resultSet.getInt("Idade"));
                pessoaFisica.setEndereco(resultSet.getString("Endereco"));
                pessoaJuridica.setId(resultSet.getInt("IdPessoaJuridica"));
                pessoaFisica.setPessoaJuridica(pessoaJuridica);
                list.add(pessoaFisica);
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public PessoaFisica listarPessoa(int IdPessoaFisica){
        PessoaFisica pessoaFisica = new PessoaFisica();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        try {
            String sql = "SELECT * FROM PessoaFisica WHERE IdPessoa = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, IdPessoaFisica);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                pessoaFisica.setNome(resultSet.getString("NomePessoa"));
                pessoaFisica.setCpf(resultSet.getString("Cpf"));
                pessoaFisica.setIdade(resultSet.getInt("Idade"));
                pessoaFisica.setEndereco(resultSet.getString("Endereco"));
                pessoaJuridica.setId(resultSet.getInt("IdPessoaJuridica"));
                pessoaFisica.setPessoaJuridica(pessoaJuridica);
            }
            return pessoaFisica;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
