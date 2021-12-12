package Controller;

import DAO.PessoaFisicaDAO;
import Model.PessoaFisica;

import java.util.List;

public class PessoaFisicaController {
    PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

    public void inserePessoaFisica(PessoaFisica pessoaFisica){
        pessoaFisicaDAO.inserirPessoaFisica(pessoaFisica);
    }
    public List<PessoaFisica> listarPessoasFisicas(){
        return pessoaFisicaDAO.listarPessoasFisicas();
    }
    public List<PessoaFisica> listarPessoasFisicas(int idPessoaJuridica){
        return pessoaFisicaDAO.listarPessoasFisicasPorIdPessoaJuridica(idPessoaJuridica);
    }
    public PessoaFisica listarPessoa(int idPessoaFisica){
        return pessoaFisicaDAO.listarPessoa(idPessoaFisica);
    }

}
