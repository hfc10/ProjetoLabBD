package br.inatel.DAO;
import br.inatel.Model.Mesa;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDAO extends ConnectionDAO {

    public boolean insertMesa(Mesa mesa) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO mesa (numero, capacidade) VALUES (?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, mesa.getNumero());
            pst.setInt(2, mesa.getCapacidade());
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

    public boolean updateMesa(int id, Mesa mesa) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE mesa SET numero = ?, capacidade = ? WHERE idMesa = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, mesa.getNumero());
            pst.setInt(2, mesa.getCapacidade());
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

    public boolean deleteMesa(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM mesa WHERE idMesa = ?";
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

    public ArrayList<Mesa> selectMesas() {
        connectToDb();

        ArrayList<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM mesa";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de mesas:");
            while (rs.next()) {
                Mesa mesaAux = new Mesa(rs.getInt("idMesa"), rs.getInt("numero"), rs.getInt("capacidade"));
                System.out.println("Número: " + mesaAux.getNumero() + " Capacidade: " + mesaAux.getCapacidade());
                System.out.println("--------------------");
                mesas.add(mesaAux);
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
        return mesas;
    }
}