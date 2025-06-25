import java.util.Scanner;

public class GaraSportiva {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input dati dell'atleta
        System.out.print("Inserisci età: ");
        int eta = input.nextInt();

        System.out.print("Inserisci il tuo miglior tempo sui 100 metri (in secondi): ");
        double tempo = input.nextDouble();

        System.out.print("Inserisci il tuo peso (in kg): ");
        double peso = input.nextDouble();

        System.out.print("Inserisci la tua altezza (in metri): ");
        double altezza = input.nextDouble();

        // Calcolo del BMI con Math.pow
        double bmi = peso / Math.pow(altezza, 2);

        // Verifica delle condizioni con operatori logici
        boolean etaValida = (eta >= 18 && eta <= 40);
        boolean tempoValido = (tempo < 12);
        boolean bmiValido = (bmi < 25);

        if (etaValida && tempoValido && bmiValido) {
            System.out.println("Ammesso alla gara");
        } else {
            System.out.println("Non ammesso alla gara");
        }

        input.close();
    }
}
