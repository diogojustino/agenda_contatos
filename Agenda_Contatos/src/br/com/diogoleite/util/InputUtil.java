/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.util;

import java.util.Scanner;

/**
 *
 * @author diogo_leite
 */
public class InputUtil {

    private static final Scanner input = new Scanner(System.in);

    public static byte nextByte() {
        do {
            try {
                return input.nextByte();
            } catch (RuntimeException runTimeException) {
                input.nextLine();
                System.err.println("Digite apenas números.");
            } finally {
                input.nextLine();
            }
        } while (true);
    }

    public static long nextLong() {
        do{
            try {
                return input.nextLong();
            } catch (RuntimeException runtimeException) {
                input.nextLine();
                System.err.println("Digite apenas números.");
            } finally {
                input.nextLine();
            }
        }while(true);
        
    }

    public static String next() {
        String valor = input.next();
        input.nextLine();
        return valor;
    }

    public static String nextLine() {
        return input.nextLine();
    }
}
