package UI;

import java.util.Scanner;

public class Main {

    /**
     * AUTOR: PEDRO CORNEJO CARVAJAL
     *
     * **/
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Menus menu = new Menus();
        menu.start();
    }
}