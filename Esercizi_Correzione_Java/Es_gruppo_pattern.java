// Import necessari
import java.util.*;

// Interfaccia Observer
interface Osservatore {
    void ricevi(String messaggio);
}

// Classe astratta Decorator per Osservatore
abstract class OsservatoreDecorator implements Osservatore {
    protected Osservatore decorato;

    public OsservatoreDecorator(Osservatore decorato) {
        this.decorato = decorato;
    }
}

// Decoratore: aggiunge timestamp
class TimestampDecorator extends OsservatoreDecorator {
    public TimestampDecorator(Osservatore decorato) {
        super(decorato);
    }

    public void ricevi(String messaggio) {
        String msg = "[" + new Date() + "] " + messaggio;
        decorato.ricevi(msg);
    }
}

// Decoratore: messaggio in maiuscolo
class UppercaseDecorator extends OsservatoreDecorator {
    public UppercaseDecorator(Osservatore decorato) {
        super(decorato);
    }

    public void ricevi(String messaggio) {
        decorato.ricevi(messaggio.toUpperCase());
    }
}

// Implementazione concreta di un utente
class Utente implements Osservatore {
    private String nome;

    public Utente(String nome) {
        this.nome = nome;
    }

    public void ricevi(String messaggio) {
        System.out.println(nome + " ha ricevuto: " + messaggio);
    }
}

// Singleton NotificationManager
class NotificationManager {
    private static NotificationManager istanza;
    private List<Osservatore> osservatori = new ArrayList<>();

    private NotificationManager() {}

    public static NotificationManager getInstance() {
        if (istanza == null) {
            istanza = new NotificationManager();
        }
        return istanza;
    }

    public void aggiungiOsservatore(Osservatore o) {
        osservatori.add(o);
    }

    public void rimuoviOsservatore(Osservatore o) {
        osservatori.remove(o);
    }

    public void inviaNotifica(String messaggio) {
        for (Osservatore o : osservatori) {
            o.ricevi(messaggio);
        }
    }
}

// Classe Main
public class Main {
    public static void main(String[] args) {
        NotificationManager manager = NotificationManager.getInstance();

        // Utenti base
        Osservatore u1 = new Utente("Mario");
        Osservatore u2 = new Utente("Lucia");

        // Utenti decorati
        Osservatore u3 = new TimestampDecorator(new Utente("Anna"));
        Osservatore u4 = new UppercaseDecorator(new Utente("Paolo"));
        Osservatore u5 = new UppercaseDecorator(new TimestampDecorator(new Utente("Luca")));

        manager.aggiungiOsservatore(u1);
        manager.aggiungiOsservatore(u2);
        manager.aggiungiOsservatore(u3);
        manager.aggiungiOsservatore(u4);
        manager.aggiungiOsservatore(u5);

        manager.inviaNotifica("Sistema in manutenzione domani alle 9.");

        System.out.println("-- Rimuovo Lucia --");
        manager.rimuoviOsservatore(u2);

        manager.inviaNotifica("Aggiornamento completato con successo.");
    }
}
