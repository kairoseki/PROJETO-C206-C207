package ParteBD;


import Projeto.partePOO.Filmes;
import Projeto.partePOO.Jogos;

import java.sql.SQLException;
import java.util.ArrayList;

public class FilmesBD extends ConnectionBD {

    boolean sucesso = false;


    //DATA ACESS OBJECT
    public boolean inserirFilmes(Filmes filmes) {
        connectToDB();
        String sql = "INSERT INTO Filmes (NomeF,GeneroF,DataF,StatusF) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, filmes.getNome());
            pst.setString(2, filmes.getGenero());
            pst.setInt(3, filmes.getDataLancamento());
            pst.setInt(4, filmes.getStatus());
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
    public boolean deletarFilme(int id) {
        connectToDB();
        String sql = "DELETE FROM Filmes where idFilmes=?";

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

    public ArrayList<Filmes> buscarFilmes() {
        ArrayList<Filmes> listaDeFilmes = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM Filmes";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Filmes: ");
            while (rs.next()) {
                Filmes filmeaux = new Filmes();
                filmeaux.setNome(((rs.getString("NomeF"))));
                filmeaux.setGenero((rs.getString("GeneroF")));
                filmeaux.setDataLancamento((rs.getInt("DataF")));
                filmeaux.setStatus((rs.getInt("StatusF")));
                System.out.println("Nome do Filme = " + filmeaux.getNome());
                System.out.println("Genero = " + filmeaux.getGenero());
                System.out.println("Data de Lancamento = " + filmeaux.getDataLancamento());
                System.out.println("Status = " + filmeaux.getStatus());
                System.out.println("--------------------------------");
                listaDeFilmes.add(filmeaux);
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

        return listaDeFilmes;
    }
    public boolean atualizarStatusFilme(int id, Filmes filmes) {
        connectToDB();
        String sql = "UPDATE Filmes SET StatusF = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, filmes.getStatus());
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