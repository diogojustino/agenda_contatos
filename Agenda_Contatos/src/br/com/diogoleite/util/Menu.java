/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.util;

/**
 *
 * @author diogo_leite
 */
public class Menu {
    public static void boasVindas(){
        System.out.println(" ------Agenda Contatos-------");
        System.out.println("|Autor: Diogo Leite          |");
        System.out.println("|Descrição: Software simples |");
        System.out.println("|de agenda de contatos       |");
        System.out.println("|Version: 1.0                |");
        System.out.println(" ----------------------------");
    }
    
    public static void menuPrincipal(){
        limparTela();
        System.out.println(" ----- MENU PRINCIPAL -------");
        System.out.println("| 1 - Adicionar Contato      |");
        System.out.println("| 2 - Editar Contato         |");
        System.out.println("| 3 - Deletar Contato        |");
        System.out.println("| 4 - Listar Contatos        |");
        System.out.println("| 0 - Sair                   |");
        System.out.println(" ----------------------------");
        System.out.print("Opção >> ");
    }
    public static void encerramento(){
        limparTela();
        System.out.println(" -----------------------------");
        System.out.println("| Muito Obrigado por utilizar |");
        System.out.println("|    a agenda de contatos     |");
        System.out.println("|    -----------------------  |");
        System.out.println("|   | AUTOR: DIOGO LEITE    | |");
        System.out.println("|   | GITHUB: @diogojustino | |");
        System.out.println("|    -----------------------  |");
        System.out.println(" -----------------------------");
        
    }
    private static void limparTela(){
        for(int index = 0; index < 100; index++){
            System.out.println();
        }
    }
}
