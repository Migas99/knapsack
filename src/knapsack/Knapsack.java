package knapsack;

import java.util.Random;
import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {

        Mochila mochila;
        Scanner scan = new Scanner(System.in);
        System.out.println("Deseja introduzir os valores ou usar aleatórios?");
        System.out.println("Se desejar intrudozir os valores introduza 1, se quer usar valores aleatórios introduza 2.");
        int resposta;
        boolean loop = false;

        do {
            resposta = scan.nextInt();
            if (resposta == 1) {
                System.out.println("Escolheu a opção de introduzir os valores.");
                loop = true;
            } else {
                if (resposta == 2) {
                    System.out.println("Escolheu a opção se introduzir valores aleatórios.");
                    loop = true;
                } else {
                    System.out.println("Introduziu uma resposta inválida.");
                }
            }
        } while (loop == false);

        if (resposta == 1) {
            System.out.print("Indique a carga máxima da mochila: ");
            int cargaMax = scan.nextInt();

            System.out.print("Indique o número de items na mochila: ");
            Item[] items = new Item[scan.nextInt()];

            for (int i = 0; i < items.length; i++) {
                items[i] = new Item();
                System.out.print("Indique o valor do item " + (i + 1) + ": ");
                items[i].setValor(scan.nextInt());
                System.out.print("Indique o peso do item " + (i + 1) + ": ");
                items[i].setPeso(scan.nextInt());
            }

            mochila = new Mochila(items, (int) cargaMax);

        } else {
            Random random = new Random();
            mochila = new Mochila((random.nextInt(99) + 1), (random.nextInt(99) + 1));
        }
        mochila.printAll();
        double tempoInicio = System.nanoTime();
        mochila.knapsack();
        double tempoFim = System.nanoTime();
        System.out.println("Tempo de execuçao: " + ((tempoFim - tempoInicio) / 1000000) + " ms");
    }
}
