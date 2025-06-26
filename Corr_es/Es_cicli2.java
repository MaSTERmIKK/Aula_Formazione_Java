import java.util.Scanner;

public class ValutazioneVoti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numeroVoti = 0;

        // Validazione numero voti con while
        while (numeroVoti <= 0) {
            System.out.print("Quanti voti vuoi inserire? ");
            numeroVoti = input.nextInt();
            if (numeroVoti <= 0) {
                System.out.println("Inserisci un numero positivo.");
            }
        }

        int votiValidi = 0;

        // Inserimento voti con for
        for (int i = 0; i < numeroVoti; i++) {
            System.out.print("Inserisci voto n°" + (i + 1) + ": ");
            int voto = input.nextInt();

            // Verifica validità voto
            if (voto >= 0 && voto <= 30) {
                votiValidi++;

                if (voto >= 18 && voto < 24) {
                    System.out.println("Sufficiente");
                } else if (voto >= 24) {
                    System.out.println("Buono o Ottimo");
                } else {
                    System.out.println("Insufficiente");
                }

            } else {
                System.out.println("Voto non valido");
            }
        }

        System.out.println("Totale voti validi inseriti: " + votiValidi);

        input.close();
    }
}
