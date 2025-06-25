import java.util.Scanner;

public class ControlloAccesso {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Richiesta dei dati all'utente
        System.out.print("Inserisci la tua età: ");
        int eta = input.nextInt();

        System.out.print("Hai un biglietto valido? (true/false): ");
        boolean bigliettoValido = input.nextBoolean();

        System.out.print("Sei accompagnato da un adulto? (true/false): ");
        boolean accompagnato = input.nextBoolean();

        System.out.print("Hai l'opzione 'Salta la fila'? (true/false): ");
        boolean saltaFila = input.nextBoolean();

        // Verifica delle condizioni di accesso
        boolean accessoConsentito = (eta >= 14 && bigliettoValido) || (eta < 14 && accompagnato && bigliettoValido);

        if (accessoConsentito) {
            if (saltaFila) {
                System.out.println("Accesso consentito con priorità");
            } else {
                System.out.println("Accesso consentito");
            }
        } else {
            System.out.println("Accesso negato");
        }

        input.close();
    }
}
