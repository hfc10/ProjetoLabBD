package br.inatel.Model;
import java.util.Date;

public class Pedido {

    int idPedido;
    private int mesaIdMesa;
    private int clienteIdCliente;
    private String data;


    public Pedido(int idPedido, int mesaIdMesa, int clienteIdCliente, String data) {
        this.idPedido = idPedido;
        this.mesaIdMesa = mesaIdMesa;
        this.clienteIdCliente = clienteIdCliente;
        this.data = data;
    }


    public int getMesaIdMesa() {
        return mesaIdMesa;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public String getData() {
        return data;
    }

    public int getIdPedido() {
        return idPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", mesaIdMesa=" + mesaIdMesa +
                ", clienteIdCliente=" + clienteIdCliente +
                ", data='" + data + '\'' +
                '}';
    }
}
