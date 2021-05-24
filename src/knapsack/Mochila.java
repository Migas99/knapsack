package knapsack;

import java.util.Random;

public class Mochila {

    private Item[] items;
    private int cargaMax;

    public Mochila(Item[] items, int cargaMax) {
        this.items = items;
        this.cargaMax = cargaMax;
    }

    public Mochila(int nItems, int cargaMax) {
        this.cargaMax = cargaMax;
        this.items = new Item[nItems];
        Random random = new Random();
        int peso, valor;
        for (int i = 0; i < this.items.length; i++) {
            peso = random.nextInt(this.cargaMax) + 1;
            valor = (random.nextInt(this.cargaMax) + 1) * 3;
            this.items[i] = new Item(peso, valor);
        }
    }

    public void knapsack() {
        int[][] matrix = new int[this.items.length + 1][this.cargaMax + 1];

        for (int i = 0; i <= this.cargaMax; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 1; i <= this.items.length; i++) {
            for (int j = 0; j <= this.cargaMax; j++) {
                if (this.items[i - 1].getPeso() > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - this.items[i - 1].getPeso()] + this.items[i - 1].getValor());
                }
            }
        }
        
        System.out.println("-----------------Solucao-------------------------");
        System.out.println("ITEMS GUARDADOS:");
        int res = matrix[this.items.length][this.cargaMax];
        int w = this.cargaMax;
        for (int i = this.items.length; i > 0 && res > 0; i--) {
            if (res == matrix[i - 1][w]) {
                continue;
            } else {
                System.out.println("Item: " + i + " " + items[i - 1].print());
                res = res - this.items[i - 1].getValor();
                w = w - this.items[i - 1].getPeso();
            }
        }
        System.out.println("\n");
        System.out.println("Valor Maximo: " + matrix[this.items.length][this.cargaMax]);
        System.out.println("-------------------------------------------------");
    }

    public void printAll() {
        System.out.println("--------------Todos os Items---------------------");
        for (int i = 0; i < this.items.length; i++) {
            System.out.println("Item: " + (i + 1) + "  " + items[i].print());
        }
        System.out.println("\n");
        System.out.println("Carga Maxima: " + this.cargaMax);
        System.out.println("-------------------------------------------------");
    }
}
