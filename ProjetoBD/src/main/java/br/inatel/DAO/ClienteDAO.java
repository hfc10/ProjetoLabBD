package br.inatel.DAO;
import br.inatel.Model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends ConnectionDAO{

    public boolean insertUser(Cliente user){
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO cliente (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getCpf());
            pst.setString(3, user.getTelefone());
            pst.setString(4, user.getEmail());

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

    public boolean updateUser(int id, Cliente user){
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE cliente SET nome = ?, CPF = ?, telefone = ?, email = ? WHERE idCliente = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getCpf());
            pst.setString(3, user.getTelefone());
            pst.setString(4, user.getEmail());
            pst.setInt(5, id);
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

    public boolean deleteUser(int id){
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
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

    public ArrayList<Cliente> selectUser() {
        connectToDb();

        ArrayList<Cliente> users = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de usuários:");
            while (rs.next()) {
                Cliente userAux = new Cliente(rs.getInt("idCliente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"));
                System.out.println("Nome: " + userAux.getNome() + " CPF: " + userAux.getCpf());
                System.out.println("Telefone: " + userAux.getTelefone() + " Email: " + userAux.getEmail());
                System.out.println("--------------------");
                users.add(userAux);
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
        return users;
    }
}

