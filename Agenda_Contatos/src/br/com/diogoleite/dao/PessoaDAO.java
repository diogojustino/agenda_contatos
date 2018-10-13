/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.dao;

import br.com.diogoleite.model.entities.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author diogo_leite
 */
public class PessoaDAO {

    static {
        try {
            Connection connection = ConnectionDataBase.getInstance().getConnection();
            String sql = "CREATE TABLE IF NOT EXISTS pessoa(\n"
                    + "id integer PRIMARY KEY,\n"
                    + "nome text NOT NULL,\n"
                    + "sobrenome text,\n"
                    + "email text, \n"
                    + "url text,\n"
                    + "telefone_fixo text, \n"
                    + "telefone_celular\n"
                    + ");";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar banco de dados.");
        }

    }

    public void cadastrar(Pessoa pessoa) {
        ConnectionDataBase connectionDataBase = ConnectionDataBase.getInstance();
        Connection connection = connectionDataBase.getConnection();
        String sql = "INSERT INTO pessoa(nome, sobrenome, email, url, telefone_fixo, telefone_celular) values(?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getSobrenome());
            preparedStatement.setString(3, pessoa.getEmail());
            preparedStatement.setString(4, pessoa.getUrl());
            preparedStatement.setString(5, pessoa.getTelefoneFixo());
            preparedStatement.setString(6, pessoa.getTelefoneCelular());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar um novo Contato.");
        } finally {
            connectionDataBase.connectionClose();
        }

    }

    public void editar(Pessoa pessoa) {
        ConnectionDataBase connectionDataBase = ConnectionDataBase.getInstance();
        Connection connection = connectionDataBase.getConnection();
        String sql = "UPDATE pessoa set nome = ?, sobrenome = ?, email = ?, url = ?, telefone_fixo = ?, telefone_celular = ? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getSobrenome());
            preparedStatement.setString(3, pessoa.getEmail());
            preparedStatement.setString(4, pessoa.getUrl());
            preparedStatement.setString(5, pessoa.getTelefoneFixo());
            preparedStatement.setString(6, pessoa.getTelefoneCelular());
            preparedStatement.setLong(7, pessoa.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {

            throw new RuntimeException("Erro ao editar o Contato.");
        } finally {
            connectionDataBase.connectionClose();
        }

    }

    public void deletar(Pessoa pessoa) {
        ConnectionDataBase connectionDataBase = ConnectionDataBase.getInstance();
        Connection connection = connectionDataBase.getConnection();

        String sql = "DELETE from pessoa where id = ?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, pessoa.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException ex) {
           
            throw new RuntimeException("Erro ao deletar um Contato.");
        } finally {
            connectionDataBase.connectionClose();
        }

    }

    public List<Pessoa> buscarTodos() {
        ConnectionDataBase connectionDataBase = ConnectionDataBase.getInstance();
        Connection connection = connectionDataBase.getConnection();

        String sql = "SELECT * from pessoa";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Pessoa> pessoas = new ArrayList<>();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String email = resultSet.getString("email");
                String url = resultSet.getString("url");
                String telefoneFixo = resultSet.getString("telefone_fixo");
                String telefoneCelular = resultSet.getString("telefone_celular");
                Long id = resultSet.getLong("id");

                Pessoa pessoa = new Pessoa(nome, sobrenome, email, url, telefoneFixo, telefoneCelular);
                pessoa.setId(id);
                pessoas.add(pessoa);
            }
            Collections.sort(pessoas);
            statement.close();
            return pessoas;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar todos os Contato.");
        } finally {
            connectionDataBase.connectionClose();
        }

    }

    public Pessoa buscarPorId(Long id) {
        ConnectionDataBase connectionDataBase = ConnectionDataBase.getInstance();
        Connection connection = connectionDataBase.getConnection();

        String sql = "SELECT * FROM pessoa where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new RuntimeException("Pessoa não encontrada.");
            }
            Pessoa pessoa = new Pessoa();
            pessoa.setId(resultSet.getLong("id"));
            pessoa.setNome(resultSet.getString("nome"));
            pessoa.setSobrenome(resultSet.getString("sobrenome"));
            pessoa.setEmail(resultSet.getString("email"));
            pessoa.setUrl(resultSet.getString("url"));
            pessoa.setTelefoneCelular(resultSet.getString("telefone_celular"));
            pessoa.setTelefoneFixo(resultSet.getString("telefone_fixo"));
            
            preparedStatement.close();
            return pessoa;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar um Contato.");
        } finally {
            connectionDataBase.connectionClose();
        }

    }
}
