package br.inatel.DAO;
import br.inatel.Model.Pedido_has_Prato;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pedido_has_PratoDAO extends ConnectionDAO{

    public boolean insertItens(Pedido_has_Prato pedidoHasPrato) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Pedido_has_Prato (Pedido_idPedido, Prato_idPrato, quantidade) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pedidoHasPrato.getPedidoIdPedido());
            pst.setInt(2, pedidoHasPrato.getPratoIdPrato());
            pst.setInt(3, pedidoHasPrato.getQuantidade());
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean updateItens(int id, Pedido_has_Prato itens) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Pedido_has_Prato SET quantidade = ? WHERE Pedido_idPedido = ? AND Prato_idPrato = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, itens.getQuantidade());
            pst.setInt(2, itens.getPedidoIdPedido());
            pst.setInt(3, itens.getPratoIdPrato());


            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deleteItens(int id, int id2) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM Pedido_has_Prato WHERE Pedido_idPedido = ? AND Prato_idPrato = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, id2);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Pedido_has_Prato> selectItens() {
        connectToDb();

        ArrayList<Pedido_has_Prato> Itens = new ArrayList<>();
        String sql = "SELECT * FROM Pedido_has_Prato";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Itens");
            while (rs.next()) {
                Pedido_has_Prato itens1 = new Pedido_has_Prato(rs.getInt("Pedido_idPedido"), rs.getInt("Prato_idPrato"), rs.getInt("quantidade"));
                System.out.println("Id do pedido:  " + itens1.getPedidoIdPedido() + " Id do prato: " + itens1.getPratoIdPrato() +" Quantidade: " + itens1.getQuantidade());
                System.out.println("--------------------");
                Itens.add(itens1);
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return Itens;
    }
}
