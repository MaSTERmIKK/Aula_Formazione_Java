import java.util.Scanner;

public class LoginSistema {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String passwordCorretta = "java123";
        int tentativi = 0;
        boolean accessoRiuscito = false;

        // Ciclo while per massimo 3 tentativi
        while (tentativi < 3) {
            System.out.print("Inserisci la password: ");
            String password = input.nextLine();

            if (password.equals(passwordCorretta)) {
                accessoRiuscito = true;
                break; // esce dal ciclo se la password è corretta
            } else {
                System.out.println("Password errata.");
                tentativi++;
            }
        }

        // Se login riuscito, chiedi conferma con do-while
        if (accessoRiuscito) {
            char scelta;
            do {
                System.out.print("Vuoi accedere al sistema? (s/n): ");
                scelta = input.nextLine().toLowerCase().charAt(0);
            } while (scelta != 's' && scelta != 'n');

            if (scelta == 's') {
                System.out.println("Accesso al sistema effettuato.");
            } else {
                System.out.println("Accesso annullato.");
            }
        } else {
            System.out.println("Accesso bloccato. Troppi tentativi.");
        }

        input.close();
    }
}
