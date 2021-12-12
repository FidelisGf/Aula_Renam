package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.*;
import Model.PessoaFisica;
import Model.PessoaJuridica;

public class PessoaJuridicaDAO {
    private Connection connection;

    public PessoaJuridicaDAO() {
        this.connection = new ConnectionFactory().getConnection();
        CriarTabelaPessoaJuridca();
    }
    //conceito de chave estrangeira
    private void CriarTabelaPessoaJuridca(){ // query é vc fazer um ação no banco
        // quando vc criar essa tabela o primeiro Id vai ser 1
        // se vc tem o autoincrement , vc nao precisa passar um id para o banco, o banco adicionar 1 ao Id , resultando em 2
        try {
            String sql = "CREATE TABLE IF not exists PessoaJuridica " +
                    "(IdPessoaJ INT not NULL AUTO_INCREMENT, " +
                    " PRIMARY KEY (IdPessoaJ) , " +
                    " NomeEmpresa VARCHAR(100), " +
                    " Endereco VARCHAR(100), " +
                    " Cnpj VARCHAR(15)) ";
            Statement statement = connection.createStatement();//
            statement.execute(sql);
            statement.close();
        }
        catch (SQLException e){
            throw  new RuntimeException();
        }
    }
    public void inserirPessoaJuridica(PessoaJuridica pessoaJuridica){
        try {
            String sql = "INSERT INTO PessoaJuridica " + "(NomeEmpresa,Endereco,Cnpj)" + "VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoaJuridica.getNome());
            preparedStatement.setString(2, pessoaJuridica.getEndereco());
            preparedStatement.setString(3, pessoaJuridica.getCnpj());
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public List<PessoaJuridica> listarPessoasFisicas(){
        List<PessoaJuridica> list = new ArrayList<>();
        PessoaJuridica pessoaJuridica;
        try {
            String sql = "SELECT * FROM  PessoaJuridica";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setNome(resultSet.getString("NomeEmpresa"));
                pessoaJuridica.setCnpj(resultSet.getString("Cnpj"));
                pessoaJuridica.setEndereco(resultSet.getString("Endereco"));
                list.add(pessoaJuridica);
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
