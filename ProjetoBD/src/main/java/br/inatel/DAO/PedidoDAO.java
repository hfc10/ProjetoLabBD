package br.inatel.DAO;
import br.inatel.Model.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO extends ConnectionDAO {

    public boolean insertPedido(Pedido pedido) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO pedido (Mesa_idMesa, Cliente_idCliente, data) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pedido.getMesaIdMesa());
            pst.setInt(2, pedido.getClienteIdCliente());
            pst.setString(3, pedido.getData());
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

    public boolean updatePedido(int id, Pedido pedido) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE pedido SET Mesa_idMesa = ?, Cliente_idCliente = ?, Data = ?, WHERE idPedido = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pedido.getMesaIdMesa());
            pst.setInt(2, pedido.getClienteIdCliente());
            pst.setString(3, pedido.getData());
            pst.setInt(4, id);
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

    public boolean deletePedido(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM pedido WHERE idPedido = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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

    public ArrayList<Pedido> selectPedido() {
        connectToDb();

        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de pedidos:");
            while (rs.next()) {
                Pedido pedidoaux = new Pedido(rs.getInt("IdPedido"), rs.getInt("Mesa_idMesa"), rs.getInt("Cliente_idCliente"), rs.getString("data"));
                System.out.println("ID da Mesa: " + pedidoaux.getMesaIdMesa() + " ID do Cliente: " + pedidoaux.getClienteIdCliente() + " Data: " + pedidoaux.getData());
                System.out.println("--------------------");
                pedidos.add(pedidoaux);
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
        return pedidos;
    }
}
