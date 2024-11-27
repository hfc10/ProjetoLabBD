package br.inatel.Model;

public class Prato {

    private int idPrato;
    private String nome;
    private double preco;

    public Prato(int idPrato, String nome, double preco) {
        this.idPrato = idPrato;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getIdPrato() {
        return idPrato;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "idPrato=" + idPrato +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
