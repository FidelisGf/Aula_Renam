package Model;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private int Id;

    public Pessoa(String nome, String endereco, int id) {
        this.nome = nome;
        this.endereco = endereco;
        Id = id;
    }


    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Pessoa() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", Id=" + Id +
                '}';
    }
}
