package br.inatel.DAO;
import br.inatel.Model.Prato;
import java.sql.SQLException;
import java.util.ArrayList;

public class PratoDAO extends ConnectionDAO {

    public boolean insertPrato(Prato prato) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO prato (nome, preco) VALUES (?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, prato.getNome());
            pst.setDouble(2, prato.getPreco());
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

    public boolean updatePrato(int id, Prato prato) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE prato SET nome = ?, preco = ? WHERE idPrato = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, prato.getNome());
            pst.setDouble(2, prato.getPreco());
            pst.setInt(3, id);
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

    public boolean deletePrato(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM prato WHERE idPrato = ?";
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

    public ArrayList<Prato> selectPratos() {
        connectToDb();

        ArrayList<Prato> pratos = new ArrayList<>();
        String sql = "SELECT * FROM prato";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Pratos:");
            while (rs.next()) {
                Prato pratoAux = new Prato(rs.getInt("idPrato"), rs.getString("nome"), rs.getDouble("preco"));
                System.out.println("Nome: " + pratoAux.getNome() + " Preço: " + pratoAux.getPreco());
                System.out.println("--------------------");
                pratos.add(pratoAux);
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
        return pratos;
    }
}