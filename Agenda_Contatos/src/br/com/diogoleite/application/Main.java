/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.application;

import br.com.diogoleite.facade.PessoaFacade;
import br.com.diogoleite.model.entities.Pessoa;
import br.com.diogoleite.util.InputUtil;
import br.com.diogoleite.util.Menu;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author diogo_leite
 */
public class Main {

    private static final PessoaFacade pessoaFacade = new PessoaFacade();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Menu.boasVindas();
        Thread.sleep(3000);
        byte opcao;
        do {
            Menu.menuPrincipal();
            opcao = InputUtil.nextByte();
            switch (opcao) {
                case 1:
                    try {
                        System.out.println("-------- Novo Contato --------");
                        Pessoa pessoa = criarPessoa();
                        pessoaFacade.cadastrar(pessoa);
                        System.out.println("Cadastrado com sucesso.");

                    } catch (RuntimeException runtimeExceptino) {
                        System.err.println(runtimeExceptino.getMessage());
                    } finally {
                        Thread.sleep(2000);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("----- Contatos -----");

                    try {
                        List<Pessoa> pessoas = pessoaFacade.buscarTodos();

                        for (Pessoa pessoa : pessoas) {
                            System.out.println(pessoa);
                            System.out.println("--------------------");
                        }

                    } catch (RuntimeException ex) {
                        System.err.println("Erro inesperado na base de dados.");
                    } finally {
                        System.out.println("tecle enter para continuar");
                        InputUtil.nextLine();
                    }
                    System.out.println("--------------------");
                    break;
                case 0:
                    Menu.encerramento();
                    break;
            }
        } while (opcao != 0);
    }

    public static Pessoa criarPessoa() throws RuntimeException {
        System.out.println("Componentes com * são obrigatorios");
        System.out.println("Nome *: ");
        String nome = InputUtil.nextLine().trim().toUpperCase();
        System.out.println("Sobrenome: ");
        String sobrenome = InputUtil.nextLine().trim().toUpperCase();
        System.out.println("Email: ");
        String email = InputUtil.nextLine().trim().toUpperCase();
        System.out.println("URL: ");
        String url = InputUtil.nextLine().trim();
        System.out.println("Telefone Fixo : ");
        String telefoneFixo = InputUtil.nextLine().trim().toUpperCase();
        System.out.println("Telefone Celular *: ");
        String telefoneCelular = InputUtil.nextLine().trim().toUpperCase();

        Pessoa pessoa = new Pessoa(nome, sobrenome, email, url, telefoneFixo, telefoneCelular);
        return pessoa;
    }
}
