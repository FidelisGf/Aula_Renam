package View;

import Controller.PessoaFisicaController;
import Model.PessoaFisica;
import javax.swing.*;

public class PessoaFisicaView { //basicamente pra vc pedir dados ao usuario, ou mostrar dados para o usuario
    PessoaFisicaController pessoaFisicaController = new PessoaFisicaController();
    public void inserePessoaFisica(){
        String nome = JOptionPane.showInputDialog(null, "Insira o nome da pessoa ");
        String cpf = JOptionPane.showInputDialog(null, "Insira o cpf da pessoa");
        int Idade = Integer.valueOf(JOptionPane.showInputDialog(null, "Insira a idade da Pessoa :"));
        String endereco = JOptionPane.showInputDialog(null, "Insira o endereço da Pessoa : ");
        PessoaFisica pessoaFisica = new PessoaFisica(nome,endereco,cpf,Idade);
        pessoaFisicaController.inserePessoaFisica(pessoaFisica);
    }
    public void listarPessoasFisicas(){
        String output = "";
        for(PessoaFisica pessoaFisica : pessoaFisicaController.listarPessoasFisicas()){
            output += "Nome da Pessoa : " + pessoaFisica.getNome() + "   Endereco da Pessoa :  " + pessoaFisica.getEndereco() +
                    "   Cpf da Pessoa : " + pessoaFisica.getCpf() + "   Idade da Pessoa:  " + pessoaFisica.getIdade() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }
}
