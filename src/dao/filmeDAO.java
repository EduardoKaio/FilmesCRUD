package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Filme;

public class filmeDAO {

    public ArrayList<Filme> buscarTodos() {
        String sql = "SELECT * FROM filme";

        // Responsável em guardar o resultado
        ResultSet resultado = null;

        ArrayList<Filme> lista = new ArrayList<Filme>();

        Connection conn = FabricaConexao.getConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            resultado = ps.executeQuery();

            while (resultado.next()) {
                //Antes a gente estava imprimindo.
                // Agora estamos guardando no arrayList
                Filme a = new Filme();
                a.setId(resultado.getInt("id_filme"));
                a.setNome(resultado.getString("nome"));
                a.setGenero(resultado.getString("genero"));
                a.setClassificacao(resultado.getString("classificacao"));
                a.setAno(resultado.getString("ano"));
                a.setDuracao(resultado.getString("duracao"));

                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FabricaConexao.fecharConexao(conn);

        return lista;
    }

    public Filme getById(Integer id) throws ClassNotFoundException {
        if (id == null || id < 0) {
            throw new IllegalArgumentException();
        }
        String sql = "SELECT * FROM pessoa WHERE id=?";
        ResultSet resultado = null;
        Filme filme = null;
        try (Connection conn = FabricaConexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            resultado.next();
            Filme a = new Filme();
            a.setId(resultado.getInt("id_filme"));
            a.setNome(resultado.getString("nome"));
            a.setGenero(resultado.getString("genero"));
            a.setClassificacao(resultado.getString("classificacao"));
            a.setAno(resultado.getString("ano"));
            a.setDuracao(resultado.getString("duracao"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaConexao.fecharConexao(resultado);
        }
        return filme;
    }

    /**
     * Recebe um aluno para cadastar
     *
     * @param aluno
     * @return
     */
    public boolean create(Filme filme) {

        try {
            String comando = "INSERT INTO filme (nome, genero,classificacao,ano,duracao) VALUES"
                    + " (?, ?, ?, ?, ?)";

            Connection conn = FabricaConexao.getConnection();
            //revisor DE  SQL
            
            PreparedStatement ps = conn.prepareStatement(comando);
            // substituindo as ?
            ps.setString(1, filme.getNome());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getClassificacao());
            ps.setString(4, filme.getAno());
            ps.setString(5, filme.getDuracao());

            //inserindo no banco.
            int linhasAfetadas = ps.executeUpdate();
            FabricaConexao.fecharConexao(conn);

            if (linhasAfetadas > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Filme filme) {

        String sql = "UPDATE filme SET nome = ?, genero = ?, classificacao = ?, ano=?, "
                + "duracao=? WHERE filme.id_filme = ?";

        try {
            Connection conn = FabricaConexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, filme.getNome());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getClassificacao());
            ps.setString(4, filme.getAno());
            ps.setString(5, filme.getDuracao());
            ps.setInt(6, filme.getId());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Integer id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException();
        }
        String sql = "DELETE FROM filme WHERE filme.id_filme = ?";
        try {
            Connection conn = FabricaConexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
