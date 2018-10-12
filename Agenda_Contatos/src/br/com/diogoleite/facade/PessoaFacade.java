/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.facade;

import br.com.diogoleite.dao.PessoaDAO;
import br.com.diogoleite.model.entities.Pessoa;
import java.util.List;

/**
 *
 * @author diogo_leite
 */
public class PessoaFacade {
    private final PessoaDAO pessoaDAO;
    public PessoaFacade(){
        pessoaDAO = new PessoaDAO();
    }
    public void cadastrar(Pessoa pessoa) throws RuntimeException{
        pessoaDAO.cadastrar(pessoa);
    }
    
    public List<Pessoa> buscarTodos() throws RuntimeException{
        return pessoaDAO.buscarTodos();
    }
}
