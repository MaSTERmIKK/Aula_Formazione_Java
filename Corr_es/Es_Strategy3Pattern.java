// Import necessari
import java.util.*;

// STRATEGY: Interfaccia per metodi di pagamento
interface MetodoPagamento {
    void paga(double importo);
}

class CartaCredito implements MetodoPagamento {
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + " euro con Carta di Credito.");
    }
}

class PayPal implements MetodoPagamento {
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + " euro tramite PayPal.");
    }
}

// CONTEXT per Strategy
class PagamentoContext {
    private MetodoPagamento metodo;

    public void setMetodo(MetodoPagamento metodo) {
        this.metodo = metodo;
    }

    public void eseguiPagamento(double importo) {
        metodo.paga(importo);
        GestorePagamenti.getInstance().notificaUtenti("Pagamento di " + importo + " euro eseguito.");
    }
}

// OBSERVER: interfaccia
interface Notificabile {
    void aggiorna(String messaggio);
}

// DECORATOR: base per personalizzazione
abstract class NotificabileDecorator implements Notificabile {
    protected Notificabile decorato;

    public NotificabileDecorator(Notificabile decorato) {
        this.decorato = decorato;
    }
}

class EmojiDecorator extends NotificabileDecorator {
    public EmojiDecorator(Notificabile decorato) {
        super(decorato);
    }
    public void aggiorna(String messaggio) {
        decorato.aggiorna(messaggio + " ✨");
    }
}

class TimestampDecorator extends NotificabileDecorator {
    public TimestampDecorator(Notificabile decorato) {
        super(decorato);
    }
    public void aggiorna(String messaggio) {
        String data = new Date().toString();
        decorato.aggiorna("[" + data + "] " + messaggio);
    }
}

class MaiuscoloDecorator extends NotificabileDecorator {
    public MaiuscoloDecorator(Notificabile decorato) {
        super(decorato);
    }
    public void aggiorna(String messaggio) {
        decorato.aggiorna(messaggio.toUpperCase());
    }
}

// Utente che riceve notifiche
class Utente implements Notificabile {
    private String nome;

    public Utente(String nome) {
        this.nome = nome;
    }

    public void aggiorna(String messaggio) {
        System.out.println(nome + " ha ricevuto notifica: " + messaggio);
    }
}

// SINGLETON: gestore notifiche e pagamenti
class GestorePagamenti {
    private static GestorePagamenti istanza;
    private List<Notificabile> utenti = new ArrayList<>();

    private GestorePagamenti() {}

    public static GestorePagamenti getInstance() {
        if (istanza == null) {
            istanza = new GestorePagamenti();
        }
        return istanza;
    }

    public void aggiungiUtente(Notificabile u) {
        utenti.add(u);
    }

    public void notificaUtenti(String messaggio) {
        for (Notificabile u : utenti) {
            u.aggiorna(messaggio);
        }
    }
}

// MAIN
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Crea utenti
        Notificabile u1 = new Utente("Alice");
        Notificabile u2 = new EmojiDecorator(new Utente("Bob"));
        Notificabile u3 = new MaiuscoloDecorator(new TimestampDecorator(new Utente("Chiara")));

        GestorePagamenti gestore = GestorePagamenti.getInstance();
        gestore.aggiungiUtente(u1);
        gestore.aggiungiUtente(u2);
        gestore.aggiungiUtente(u3);

        // Scegli metodo di pagamento
        System.out.println("Scegli metodo di pagamento: 1 = Carta di Credito, 2 = PayPal");
        int scelta = input.nextInt();
        System.out.print("Inserisci importo: ");
        double importo = input.nextDouble();

        PagamentoContext context = new PagamentoContext();
        if (scelta == 1) {
            context.setMetodo(new CartaCredito());
        } else {
            context.setMetodo(new PayPal());
        }

        context.eseguiPagamento(importo);
        input.close();
    }
}
