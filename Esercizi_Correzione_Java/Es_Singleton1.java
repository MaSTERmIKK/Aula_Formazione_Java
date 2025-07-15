import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger_Singleton {
    // Campo statico privato per la singola istanza
    private static Logger istanza;

    // Costruttore privato per impedire istanziazione esterna
    private Logger() {}

    // Metodo statico pubblico che restituisce l’unica istanza
    public static Logger getIstanza() {
        if (istanza == null) {
            istanza = new Logger();
        }
        return istanza;
    }

    // Metodo per scrivere un messaggio con data e ora
    public void scriviMessaggio(String messaggio) {
        String dataOra = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + dataOra + "] " + messaggio);
    }
}


//----------------------------------------------------------

public class Main {
    public static void main(String[] args) {
        // Primo punto del codice
        Logger logger1 = Logger.getIstanza();
        logger1.scriviMessaggio("Inizio programma");

        // Secondo punto del codice
        Logger logger2 = Logger.getIstanza();
        logger2.scriviMessaggio("Seconda operazione completata");

        // Verifica che è la stessa istanza
        if (logger1 == logger2) {
            System.out.println("Conferma: logger1 e logger2 sono la stessa istanza.");
        } else {
            System.out.println("Errore: le istanze non coincidono.");
        }
    }
}
