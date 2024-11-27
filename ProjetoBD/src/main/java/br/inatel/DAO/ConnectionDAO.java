package br.inatel.DAO;

import java.sql.*;

public abstract class ConnectionDAO {

    public Connection con; //conexão
    public PreparedStatement pst; //declaração(query) preparada - código em sql
    public Statement st; //declaração(query) - código em sql
    public ResultSet rs; //resposta do banco

    String database = "Restaurante"; //nome do BD
    String user = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost:3306/" + database
            + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    public void connectToDb() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }

    protected void closeConnections() {
        try {
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet fechado com sucesso.");
            }
            if (st != null) {
                st.close();
                System.out.println("Statement fechado com sucesso.");
            }
            if (pst != null) {
                pst.close();
                System.out.println("PreparedStatement fechado com sucesso.");
            }
            if (con != null) {
                con.close();
                System.out.println("Conexão com o banco de dados fechada com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }

}

