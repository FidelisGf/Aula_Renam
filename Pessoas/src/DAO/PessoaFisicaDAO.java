package DAO;
import Connection.ConnectionFactory;
import Model.PessoaFisica;

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
                    " NomePessoa VARCHAR(100), " +
                    " Idade INT , " +
                    " Endereco VARCHAR(100), " +
                    " Cpf VARCHAR(12)) ";
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
            String sql = "INSERT INTO PessoaFisica " + "(NomePessoa, Idade, Endereco, Cpf)" + "VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoaFisica.getNome());
            preparedStatement.setInt(2,pessoaFisica.getIdade());
            preparedStatement.setString(3, pessoaFisica.getEndereco());
            preparedStatement.setString(4, pessoaFisica.getCpf());
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public List<PessoaFisica> listarPessoasFisicas(){
        List<PessoaFisica> list = new ArrayList<>();
        PessoaFisica pessoaFisica;
        try {
            String sql = "SELECT * FROM PessoaFisica";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                pessoaFisica = new PessoaFisica();
                pessoaFisica.setNome(resultSet.getString("NomePessoa"));
                pessoaFisica.setCpf(resultSet.getString("Cpf"));
                pessoaFisica.setIdade(resultSet.getInt("Idade"));
                pessoaFisica.setEndereco(resultSet.getString("Endereco"));
                list.add(pessoaFisica);
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

}
