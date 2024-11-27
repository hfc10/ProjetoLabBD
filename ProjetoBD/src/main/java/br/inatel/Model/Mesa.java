package br.inatel.Model;

public class Mesa {

    private int idMesa;
    private int numero;
    private int capacidade;

    // Construtor
    public Mesa(int idMesa, int numero, int capacidade) {
        this.idMesa = idMesa;
        this.numero = numero;
        this.capacidade = capacidade;
    }


    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getIdMesa() {
        return idMesa;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "idMesa=" + idMesa +
                ", numero=" + numero +
                ", capacidade=" + capacidade +
                '}';
    }
}