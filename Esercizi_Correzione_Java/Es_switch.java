import java.util.Scanner;

public class PreventivoAssicurazione {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double prezzoBase = 500.0;
        double prezzoFinale = prezzoBase;

        // Input utente
        System.out.print("Inserisci età del conducente: ");
        int eta = input.nextInt();

        if (eta < 18) {
            System.out.println("Non sei idoneo per l'assicurazione.");
            return;
        } else if (eta <= 25) {
            prezzoFinale *= 1.20;
        } else if (eta > 50) {
            prezzoFinale *= 0.90;
        }

        System.out.print("Inserisci anni di esperienza alla guida: ");
        int esperienza = input.nextInt();
        if (esperienza < 2) {
            prezzoFinale *= 1.30;
        }

        System.out.print("Inserisci numero di incidenti negli ultimi 5 anni: ");
        int incidenti = input.nextInt();
        if (incidenti > 4) {
            System.out.println("Non sei idoneo per l'assicurazione.");
            return;
        } else if (incidenti == 1) {
            prezzoFinale *= 1.15;
        } else if (incidenti >= 2) {
            prezzoFinale *= 1.30;
        }

        System.out.print("Seleziona il pacchetto (base/intermedio/premium): ");
        String pacchetto = input.next().toLowerCase();

        switch (pacchetto) {
            case "intermedio":
                prezzoFinale *= 1.20;
                break;
            case "premium":
                prezzoFinale *= 1.50;
                break;
            case "base":
                // Nessuna modifica
                break;
            default:
                System.out.println("Pacchetto non valido.");
                return;
        }

        // Output finale
        System.out.printf("Prezzo finale dell'assicurazione: %.2f €%n", prezzoFinale);
        input.close();
    }
}
