package Model;
//
public class PessoaFisica extends Pessoa{// extends
    private String Cpf;
    private int Idade;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String endereco, int id, String cpf) {
        super(nome, endereco, id);
        Cpf = cpf;
    }

    public PessoaFisica(String nome, String endereco, int id, String cpf, int idade) {
        super(nome, endereco, id);
        Cpf = cpf;
        Idade = idade;
    }

    public PessoaFisica(String nome, String endereco, String cpf, int idade) {
        super(nome, endereco);
        Cpf = cpf;
        Idade = idade;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public PessoaFisica(String nome, String endereco, int id) {
        super(nome, endereco, id);
    }

    public PessoaFisica(String nome, String endereco) {
        super(nome, endereco);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "Cpf='" + Cpf + '\'' +
                ", Idade=" + Idade +
                '}';
    }
}
