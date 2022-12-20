package UI;

import DAL.ManejadoraBBDD;
import DAL.ManejadoraEntidadesBBDD;
import Entidades.Persona;
import Entidades.Sorteo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Menus {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Descripcion: Metodo que te muestra las opciones del menu por pantalla y te pide que elijas una de ellas o pulses cualquier tecla para salir.
     * Precondiciones: ninguna
     * Postcondiciones: Devuelve la opcion elegida por el usuario
     *
     * @return opc
     */
    private int menu() {
        int opc;
        System.out.println("""
                Bienvenido a Loterias Pedro
                [1]. Iniciar sorteo
                [2]. Ver persona Mas afortunada
                [3]. Ver persona mas suertuda
                [4]. Numero mas repetido
                [5]. Reiniciar
                [0]. Salir
                Elige una opcion:""");
        opc = comprobarOpcion(sc.nextLine());
        return opc;
    }

    /**
     * Descripcion: Metodo que comprueba que la opcion introducido por teclado es realmente un numero.
     * Precondiciones: ninguna
     * Postcondiciones: ninguna
     *
     * @param opcionString
     * @return opcion
     */
    private static int comprobarOpcion(String opcionString) {
        int opcion = -1;
        try {
            opcion = Integer.parseInt(opcionString);
        } catch (NumberFormatException r) {
            System.err.println("Debe introducir un número");
        }

        return opcion;
    }

    /**
     * Descripcion: Metodo que te manda a las funcion elegida en el metodo menu()
     * Precondiciones: Ninguna
     * Postcondiciones: Ninguna
     *
     * @param
     */
    public void start() {
        var salir = false;
        while (!salir) {
            switch (menu()) {
                case 1 -> iniciarSorteo();
                case 2 -> personaAfortunada();
                case 3 -> personaSuertuda();
                case 4 -> numeroMasRepetido();
                case 5 -> reiniciar();
                case 0 -> salir = true;
            }
        }
        System.out.println("¡Vuelve pronto!");
    }


    public void iniciarSorteo() {
        int num1 = (int) (Math.random() * 100 + 0);
        int num2 = (int) (Math.random() * 100 + 0);
        int num3 = (int) (Math.random() * 100 + 0);

        ManejadoraEntidadesBBDD.getListadoPersonas();

    }

    /**
     * Descripcion: Metodo que comprueba dentro de una lista de personas cual tiene el atributo de saldo mas alto
     * Precondiciones: Ninguna
     * Postcondiciones: Ninguna
     */
    private void personaAfortunada() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas = ManejadoraEntidadesBBDD.getListadoPersonas();
        double mayorSaldo = 0;
        String nombreAfortunado = null;
        for (Persona persona : personas) {
            if (persona.getSaldo() > mayorSaldo) {
                mayorSaldo = persona.getSaldo();
                nombreAfortunado = persona.getNombre();
            }
        }
        System.out.println("La persona mas afortunada es" + nombreAfortunado);
    }

    /**
     * Descripcion: Metodo que comprueba dentro de una lista de personas cual ha ganado mas sorteos
     * Precondiciones: Ninguna
     * Postcondiciones: Ninguna
     */
    public void personaSuertuda() {

        ArrayList<Persona> personas = new ArrayList<>();
        personas = ManejadoraEntidadesBBDD.getListadoPersonas();
        double mayorSaldo = 0;
        String nombreAfortunado = null;
        for (Persona persona : personas) {
            //codigo
            }

        System.out.println("La persona mas suertuda es" + nombreAfortunado);
    }

    /**
     * Descripcion: Metodo que comprueba que nuemro se ha repetido mas veces en nuestra loteria
     * Precondiciones: Ninguna
     * Postcondiciones: Ninguna
     */
    public void numeroMasRepetido() {
        ArrayList<Sorteo> sorteos = new ArrayList<>();
        sorteos = ManejadoraEntidadesBBDD.getListadoSorteos();
        int[] numeros = new int[0];
        int i=0;
        for (Sorteo sorteo : sorteos) {
            numeros[i] = sorteo.getNum1();
            numeros[i+1] =sorteo.getNum2();
            numeros[i+2] =sorteo.getNum3();
            i= i+3;
        }

        HashMap<Integer, Integer> mapa = new HashMap<>();
        for (int x = 0; x < numeros.length; x++) {
            int numero = numeros[x];
            if (mapa.containsKey(numero)) {
                mapa.put(numero, mapa.get(numero) + 1);
            } else {
                mapa.put(numero, 1);
            }
        }
        int numeroRepetido = 0, veces = 0;
        for (HashMap.Entry<Integer, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > veces) {
                veces = entry.getValue();
                numeroRepetido = entry.getKey();
            }
        }
        System.out.printf("La numero mas repetido en la loteria es " + numeroRepetido + " porque se repite " + veces + " veces" );
    }


    /**
     * Descripcion: Metodo para reiniciar los datos de los sorteos y apuestas realizadas
     * Precondiciones: Ninguna
     * Postcondiciones: Ninguna
     */
    public void reiniciar() {
        System.out.println("""
                ¿Esta seguro que desea borrar los registros de los sorteos realizados hasta ahora?
                [1]. Si
                [2]. No
                Elige una opcion:""");
        if (comprobarOpcion(sc.nextLine()) == 1) {
            ManejadoraBBDD.borrarRegistros("Sorteos");
            ManejadoraBBDD.borrarRegistros("Apuestas");
            System.out.println("Borrado completado");
        } else {
            System.out.println("Operacion cancelada");
        }
    }
}
