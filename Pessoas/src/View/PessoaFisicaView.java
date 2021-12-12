package View;

import Controller.PessoaFisicaController;
import Model.PessoaFisica;
import Model.PessoaJuridica;

import javax.swing.*;

public class PessoaFisicaView { //basicamente pra vc pedir dados ao usuario, ou mostrar dados para o usuario
    PessoaFisicaController pessoaFisicaController = new PessoaFisicaController();
    public void inserePessoaFisica(){
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        String nome = JOptionPane.showInputDialog(null, "Insira o nome da pessoa ");
        String cpf = JOptionPane.showInputDialog(null, "Insira o cpf da pessoa");
        int Idade = Integer.valueOf(JOptionPane.showInputDialog(null, "Insira a idade da Pessoa :"));
        String endereco = JOptionPane.showInputDialog(null, "Insira o endereço da Pessoa : ");
        pessoaJuridica.setId(Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o Id da Pessoa Juridica :")));
        PessoaFisica pessoaFisica = new PessoaFisica(nome,endereco,cpf,Idade,pessoaJuridica);
        pessoaFisicaController.inserePessoaFisica(pessoaFisica);
    }
    public void listarPessoasFisicas(){
        String output = "";
        for(PessoaFisica pessoaFisica : pessoaFisicaController.listarPessoasFisicas()){
            output += "Nome da Pessoa : " + pessoaFisica.getNome() + "   Endereco da Pessoa :  " + pessoaFisica.getEndereco() +
                    "   Cpf da Pessoa : " + pessoaFisica.getCpf() + "   Idade da Pessoa:  " + pessoaFisica.getIdade()
                    + "  Id da PessoaJuridica :  " + pessoaFisica.getPessoaJuridica().getId()
                    + "\n\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }
    public void listarPessoasPorIdPessoaJuridica(){
        String output = "";
        int IdPessoaJuridica = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o Id da Pessoa Juridica"));
        for(PessoaFisica pessoaFisica : pessoaFisicaController.listarPessoasFisicas(IdPessoaJuridica)){
            output += "Nome da Pessoa : " + pessoaFisica.getNome() + "   Endereco da Pessoa :  " + pessoaFisica.getEndereco() +
                    "   Cpf da Pessoa : " + pessoaFisica.getCpf() + "   Idade da Pessoa:  " + pessoaFisica.getIdade()
                    + "  Id da PessoaJuridica :  " + pessoaFisica.getPessoaJuridica().getId()
                    + "\n\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }
    public void listarPessoa(){
        int idPessoaFisica = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o Id da Pessoa Fisica"));
        PessoaFisica pessoaFisica = pessoaFisicaController.listarPessoa(idPessoaFisica);
        String output = "Nome da Pessoa : " + pessoaFisica.getNome() + "   Endereco da Pessoa :  " + pessoaFisica.getEndereco() +
                "   Cpf da Pessoa : " + pessoaFisica.getCpf() + "   Idade da Pessoa:  " + pessoaFisica.getIdade()
                + "  Id da PessoaJuridica :  " + pessoaFisica.getPessoaJuridica().getId()
                + "\n\n";
        JOptionPane.showMessageDialog(null, output);
    }
}
