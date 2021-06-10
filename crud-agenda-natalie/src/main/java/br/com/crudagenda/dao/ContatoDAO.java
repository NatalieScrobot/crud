package br.com.crudagenda.dao;

import br.com.crudagenda.infra.ConnectionFactory;
import br.com.crudagenda.model.Categoria;
import br.com.crudagenda.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContatoDAO implements IContatoDAO {

    @Override
    public Contato save(Contato contato) {
        try (var connection = ConnectionFactory.getConnection()) {

            var sql =
                    "INSERT INTO Contato (nome, sobrenome, datadenascimento, telefone, parentesco) " +
                    "VALUES (?, ?, ?, ?, ?)";

            var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getSobrenome());
            preparedStatement.setDate(3,java.sql.Date.valueOf(contato.getDataDeNascimento()));
            preparedStatement.setString(4, contato.getTelefone());
            preparedStatement.setString(5,contato.getParentesco().toString());

            preparedStatement.executeUpdate();

            var resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            var generatedId = resultSet.getLong("id");
            contato.setId(generatedId);

        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }

        return contato;
    }

    @Override
    public Contato update(long id, Contato contato) {
        try (var connection = ConnectionFactory.getConnection()) {
            var sql =
                    "UPDATE Contato" +
                    " SET nome=?, sobrenome=?, datadenascimento=?, telefone=?, parentesco=? " +
                    "WHERE id=" + id;

            var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getSobrenome());
            preparedStatement.setDate(3,java.sql.Date.valueOf(contato.getDataDeNascimento()));
            preparedStatement.setString(4, contato.getTelefone());
            preparedStatement.setString(5,contato.getParentesco().toString());

            preparedStatement.executeUpdate();

            var resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }

        return contato;
    }

    @Override
    public void delete(long id) {
        try (var connection = ConnectionFactory.getConnection()) {
            var sql =
                    "DELETE FROM Contato" +
                            " WHERE id=" + id;

            var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.executeUpdate();
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Contato> findAll() {
        var sql =
                "SELECT id, nome, sobrenome, datadenascimento, telefone, parentesco " +
                "FROM contato";

        var contatos = new ArrayList<Contato>();

        try (var connection = ConnectionFactory.getConnection()){
            var preparedStatement = connection.prepareStatement(sql);

            var rs = preparedStatement.executeQuery();

            while (rs.next()) {
                var id = rs.getLong("id");
                var nome = rs.getString("nome");
                var sobrenome = rs.getString("sobrenome");
                var data = rs.getDate("datadenascimento").toLocalDate();
                var telefone = rs.getString("telefone");
                var parentesco = Categoria.valueOf(rs.getString("parentesco"));

                var contato = new Contato(id, nome, sobrenome, data, telefone, parentesco);
                contatos.add(contato);
            }

        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }

        return contatos;
    }

    @Override
    public Optional<Contato> findById(long id) {
        var sql =
                "SELECT id, nome, sobrenome, datadenascimento, telefone, parentesco " +
                        "FROM contato " +
                        "WHERE id = ?";

        Contato contato = null;
        try (var connection = ConnectionFactory.getConnection()){
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            var rs = preparedStatement.executeQuery();

            while (rs.next()){
                var idContato = rs.getLong("id");
                var nome = rs.getString("nome");
                var sobrenome = rs.getString("sobrenome");
                var data = rs.getDate("datadenascimento").toLocalDate();
                var telefone = rs.getString("telefone");
                var parentesco = Categoria.valueOf(rs.getString("parentesco"));

                contato = new Contato(idContato, nome, sobrenome, data, telefone, parentesco);
            }

        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(contato);
    }
}
