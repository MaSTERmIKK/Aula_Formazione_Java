import java.util.Scanner;

public class EserciziFunzioni {

    // Esercizio 1
    public static int somma(int a, int b) {
        return a + b;
    }

    // Esercizio 2 - Overloading
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b, double c) {
        return a * b * c;
    }

    // Esercizio 3 - Ricorsione
    public static int sommaNaturali(int n) {
        if (n == 1)
            return 1;
        return n + sommaNaturali(n - 1);
    }

    // Esercizio 4 - Passaggio per valore
    public static void modificaVariabile(int x) {
        x = x + 10;
        System.out.println("Variabile modificata nel metodo: " + x);
    }

    public static void modificaArray(int[] arr) {
        arr[0] = 999;
        System.out.println("Array modificato nel metodo: " + arr[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Somma di due numeri (Esercizio 1)");
            System.out.println("2. Moltiplicazioni con overload (Esercizio 2)");
            System.out.println("3. Somma ricorsiva dei numeri naturali (Esercizio 3)");
            System.out.println("4. Passaggio per valore e per riferimento (Esercizio 4)");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> {
                    System.out.print("Inserisci primo numero: ");
                    int a = scanner.nextInt();
                    System.out.print("Inserisci secondo numero: ");
                    int b = scanner.nextInt();
                    System.out.println("Risultato: " + somma(a, b));
                }
                case 2 -> {
                    System.out.println("1. Due interi");
                    System.out.println("2. Tre double");
                    int tipo = scanner.nextInt();
                    if (tipo == 1) {
                        System.out.print("Inserisci due interi: ");
                        int x = scanner.nextInt();
                        int y = scanner.nextInt();
                        System.out.println("Risultato: " + multiply(x, y));
                    } else {
                        System.out.print("Inserisci tre double: ");
                        double x = scanner.nextDouble();
                        double y = scanner.nextDouble();
                        double z = scanner.nextDouble();
                        System.out.println("Risultato: " + multiply(x, y, z));
                    }
                }
                case 3 -> {
                    System.out.print("Inserisci n: ");
                    int n = scanner.nextInt();
                    System.out.println("Somma ricorsiva: " + sommaNaturali(n));
                }
                case 4 -> {
                    int var = 5;
                    int[] array = {1, 2, 3};

                    System.out.println("Prima della modifica:");
                    System.out.println("Variabile: " + var);
                    System.out.println("Array: " + array[0]);

                    modificaVariabile(var);
                    modificaArray(array);

                    System.out.println("Dopo la modifica:");
                    System.out.println("Variabile: " + var); // rimane 5
                    System.out.println("Array: " + array[0]); // diventa 999
                }
                case 0 -> System.out.println("Uscita dal programma.");
                default -> System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        scanner.close();
    }
}
