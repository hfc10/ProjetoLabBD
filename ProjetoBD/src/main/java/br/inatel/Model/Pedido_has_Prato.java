package br.inatel.Model;

public class Pedido_has_Prato {

    private int pedidoIdPedido;
    private int pratoIdPrato;
    private int quantidade;

    public Pedido_has_Prato(int pedidoIdPedido, int pratoIdPrato, int quantidade) {
        this.pedidoIdPedido = pedidoIdPedido;
        this.pratoIdPrato = pratoIdPrato;
        this.quantidade = quantidade;
    }

    public int getPedidoIdPedido() {
        return pedidoIdPedido;
    }

    public int getPratoIdPrato() {
        return pratoIdPrato;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
