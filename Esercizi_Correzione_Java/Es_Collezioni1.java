import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GestioneStudenti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> studenti = new ArrayList<>();

        // Inserimento nomi
        String nome;
        do {
            System.out.print("Inserisci il nome dello studente (scrivi 'fine' per terminare): ");
            nome = input.nextLine();

            if (!nome.equalsIgnoreCase("fine")) {
                studenti.add(nome);
            }
        } while (!nome.equalsIgnoreCase("fine"));

        // Ordinamento alfabetico
        Collections.sort(studenti);

        // Stampa dei nomi ordinati
        System.out.println("\nElenco studenti in ordine alfabetico:");
        for (String studente : studenti) {
            System.out.println(studente);
        }

        // Numero totale di studenti
        System.out.println("\nTotale studenti inseriti: " + studenti.size());

        // Rimozione di uno studente
        System.out.print("Vuoi eliminare uno studente? (s/n): ");
        String risposta = input.nextLine();

        if (risposta.equalsIgnoreCase("s")) {
            System.out.print("Inserisci il nome dello studente da eliminare: ");
            String daRimuovere = input.nextLine();

            if (studenti.remove(daRimuovere)) {
                System.out.println("Studente rimosso.");
            } else {
                System.out.println("Studente non trovato.");
            }

            // Stampa elenco aggiornato
            System.out.println("\nElenco aggiornato:");
            for (String studente : studenti) {
                System.out.println(studente);
            }
        }

        input.close();
    }
}
