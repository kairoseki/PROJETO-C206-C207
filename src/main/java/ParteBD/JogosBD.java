package ParteBD;

import Projeto.partePOO.Jogos;

import java.sql.SQLException;
import java.util.ArrayList;

public class JogosBD extends ConnectionBD {

    boolean sucesso = false;


    //DATA ACESS OBJECT
    public boolean inserirJogo(Jogos jogos) {
        connectToDB();
        String sql = "INSERT INTO Jogos (NomeJ,GeneroJ,DataJ,StatusJ) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogos.getNome());
            pst.setString(2, jogos.getGenero());
            pst.setInt(3, jogos.getDataLancamento());
            pst.setInt(4, jogos.getStatus());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (Exception exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }
    public boolean deletarJogo(int id) {
        connectToDB();
        String sql = "DELETE FROM Jogos where idJogos=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Jogos> buscarJogos() {
        ArrayList<Jogos> listaDeJogos = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM Jogos";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Jogos: ");
            while (rs.next()) {
                Jogos jogoaux = new Jogos();
                jogoaux.setNome(rs.getString("NomeJ"));
                jogoaux.setGenero((rs.getString("GeneroJ")));
                jogoaux.setDataLancamento((rs.getInt("DataJ")));
                jogoaux.setStatus((rs.getInt("StatusJ")));
                System.out.println("Nome do Jogo = " + jogoaux.getNome());
                System.out.println("Genero = " + jogoaux.getGenero());
                System.out.println("Data de Lancamento = " + jogoaux.getDataLancamento());
                System.out.println("Status = " + jogoaux.getStatus());
                System.out.println("--------------------------------");
                listaDeJogos.add(jogoaux);
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return listaDeJogos;
    }
    public boolean atualizarStatusJogo(int id,Jogos jogos) {
        connectToDB();
        String sql = "UPDATE Jogos SET StatusJ = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, jogos.getStatus());
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

}