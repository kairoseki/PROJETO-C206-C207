package ParteBD;

import java.sql.*;


public abstract class ConnectionBD {
    Connection con; //conexão
    PreparedStatement pst; //declaração preparada
    Statement st; //query/declaração
    ResultSet rs; // resultado retornado

    String database = "BDprojeto";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
    String user = "root";
    String password = "IHcd05042002-";

    public void connectToDB() {
        try {
            this.con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão deu certo!" + con);
        } catch (Exception exc) {
            if (exc instanceof SQLException) {
                System.out.println(((SQLException) exc).getSQLState());
            }

            System.out.println("Erro, infelizmente:/ : " + exc.getMessage());
            System.exit(1);
        }
    }


}