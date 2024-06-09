/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * Aquesta classe representa el joc del tres en ratlla (tic-tac-toe). 
 * Gestiona la lògica del joc, incloent-hi els moviments dels jugadors i el tauler de joc.
 *
 * @author Lluc
 * @version 09.06.2024
 */
public class TicTacToe {

    /**
     * El punt d'entrada principal del programa. Inicialitza el tauler de joc i
     * gestiona el bucle principal del joc. Conté la crida de funcions.
     *
     * @param args els arguments de la línia de comandes
     */
    public static void main(String[] args) {
        int[][] tauler = new int[3][3];
        imprimirTauler(tauler);
        iniciJoc(tauler);
        System.out.println("");
        System.out.println("");
        imprimirTauler(tauler);
        while (true) {
            tirJugador(tauler);
            imprimirTauler(tauler);
            tirContrincant(tauler);
            imprimirTauler(tauler);
        }

    }

    /**
     * Inicialitza el tauler de joc a "-3", que indica que les cel·les estan
     * buides. S'inicialitza el tauler de joc a "-N", on N és la
     * llargada/amplada del tauler El tauler conté "-N" si és una casella buida,
     * "0" si és una casella amb la fitxa del contrincant i "1" si és una
     * casella amb la fitxa del jugador És a dir, aquest mètode marca totes les
     * cel·les del tauler com a buides.
     *
     * @param taulerJoc el tauler de joc a inicialitzar
     */
    public static void iniciJoc(int[][] taulerJoc) {
        for (int i = 0; i < taulerJoc.length; i++) {
            for (int j = 0; j < taulerJoc.length; j++) {
                taulerJoc[i][j] = -3;
            }
        }
    }

    /**
     * Imprimeix el tauler de joc a la consola. Mostra les cel·les buides com a
     * '_', les fitxes del contrincant com a 'O' i les fitxes del jugador com a
     * 'X'. L'amplada del tauler ha de ser igual a la seva llargada (tauler
     * quadrat).
     *
     * @param taulerJoc el tauler de joc a imprimir
     */
    public static void imprimirTauler(int[][] taulerJoc) {
        System.out.println("  1 2 3 ");
        for (int i = 0; i < taulerJoc.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < taulerJoc.length; j++) {
                System.out.print(crossOrCircle(taulerJoc[i][j]) + " ");
            }
            System.out.print("| " + (i + 1));
            System.out.println("");
        }
    }

    /**
     * Converteix el valor enter d'una cel·la del tauler en un caràcter
     * corresponent.
     *
     * @param i el valor de la cel·la del tauler
     * @return '_' si la cel·la està buida, 'O' si conté una fitxa del
     * contrincant, 'X' si conté una fitxa del jugador
     */
    public static char crossOrCircle(int i) {
        if (i == -3) {
            return '_';
        }
        return (i == 0) ? 'O' : 'X';
    }

    /**
     * Converteix coordenades bidimensionals a una única coordenada
     * unidimensional.
     *
     * @param x la coordenada x (columna)
     * @param y la coordenada y (fila)
     * @return la coordenada unidimensional corresponent
     */
    private static int bidimensionalToUnidimensional(int x, int y) {
        return (y - 1) * 3 + x;
    }

    /**
     * Realitza el moviment del contrincant generant coordenades aleatòries fins
     * a trobar una cel·la buida.
     *
     * @param taulerJoc el tauler de joc
     */
    public static void tirContrincant(int[][] taulerJoc) {
        System.out.println("");
        System.out.println("TIR CONTRINCANT");

        int random_x;
        int random_y;

        Random rand = new Random();

        do {
            random_x = rand.nextInt(3);
            random_y = rand.nextInt(3);
        } while (taulerJoc[random_x][random_y] != -3);

        taulerJoc[random_x][random_y] = 0; // 0 = 'O', és a dir, la màquina        
    }

    /**
     * Realitza el moviment del jugador llegint les coordenades de la consola.
     *
     * @param taulerJoc el tauler de joc
     */
    public static void tirJugador(int[][] taulerJoc) {
        System.out.println("");
        System.out.println("TIR JUGADOR");

        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream  
        System.out.print("[X] Entra la columna (1-3)");
        int x = sc.nextInt();
        System.out.print("[Y] Entra la fila (1-3)");
        int y = sc.nextInt();

        taulerJoc[y - 1][x - 1] = 1; // 1 = 'X', és a dir, el jugador 
    }

    /**
     * Revisa totes les files, columnes i diagonals (D) del tauler per determinar si un jugador ha guanyat.
     *
     * El tauler ha de tenir una llargada/amplada fixa, que anomenem "N". Un
     * jugador guanya quan aconsegueix tenir N caselles seguides en qualsevol
     * fila, columna o diagonal. El contrincant guanya quan la suma dels valors
     * d'una fila, columna o diagonal dóna exactament 0. El jugador guanya quan
     * la suma dels valors d'una fila, columna o diagonal dóna exactament N.
     *
     * @param taulerJoc que representa les cel·les del tauler de joc, de mida
     * NxN.
     * @return "-1" si no guanya ningú; "0" si guanya el contrincant; i "1" si
     * guanya el jugador
     */
    public static int determinarGuanyador(int[][] taulerJoc) {
        //TODO
        throw new UnsupportedOperationException();
    }

}
