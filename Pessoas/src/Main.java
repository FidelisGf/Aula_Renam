import DAO.PessoaFisicaDAO;
import DAO.PessoaJuridicaDAO;
import View.PessoaFisicaView;

public class Main {
    public static void main(String[] args) {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisicaView pessoaFisicaView = new PessoaFisicaView();
        pessoaFisicaView.listarPessoa();
    }
}
//Herança
//Orientação a Objeto
//Banco de Dados
//MVC

// M - Model
// V - View
// C - Controller

// D - DAO  - > A camada que vai acessar o Banco de dados ( Insere Dados , Pega Dados)


// Fazer uma pessoa fisica pertencer a uma Pessoa Juridica;