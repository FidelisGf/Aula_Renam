package Model;
//
public class PessoaFisica extends Pessoa{// extends
    private String Cpf;
    private int Idade;
    private PessoaJuridica pessoaJuridica;

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

    public PessoaFisica(String nome, String endereco, int id, String cpf, int idade, PessoaJuridica pessoaJuridica) {
        super(nome, endereco, id);
        Cpf = cpf;
        Idade = idade;
        this.pessoaJuridica = pessoaJuridica;
    }

    public PessoaFisica(String nome, String endereco, String cpf, int idade, PessoaJuridica pessoaJuridica) {
        super(nome, endereco);
        Cpf = cpf;
        Idade = idade;
        this.pessoaJuridica = pessoaJuridica;
    }

    public PessoaFisica(String cpf, int idade, PessoaJuridica pessoaJuridica) {
        Cpf = cpf;
        Idade = idade;
        this.pessoaJuridica = pessoaJuridica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
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
