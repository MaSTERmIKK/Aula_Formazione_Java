public class DatabaseManager {
    // Istanza Singleton privata
    private static DatabaseManager istanza;

    // Contatore interno delle connessioni
    private int connectionCount;

    // Costruttore privato
    private DatabaseManager() {
        connectionCount = 0;
    }

    // Metodo statico pubblico per ottenere l'unica istanza
    public static DatabaseManager getInstance() {
        if (istanza == null) {
            istanza = new DatabaseManager();
        }
        return istanza;
    }

    // Metodo che simula la connessione al database
    public void connect() {
        connectionCount++;
        System.out.println("Connessione stabilita. Connessioni attive: " + connectionCount);
    }

    // Metodo che restituisce il numero totale di connessioni effettuate
    public int getConnectionCount() {
        return connectionCount;
    }
}


//-------------------------------------------

public class Main {
    public static void main(String[] args) {
        // Primo utilizzo
        DatabaseManager db1 = DatabaseManager.getInstance();
        db1.connect();
        db1.connect();

        // Secondo utilizzo (altro punto del codice)
        DatabaseManager db2 = DatabaseManager.getInstance();
        db2.connect();

        // Dimostrazione che l'oggetto è lo stesso
        if (db1 == db2) {
            System.out.println("Conferma: db1 e db2 sono la stessa istanza.");
        } else {
            System.out.println("Errore: le istanze non coincidono.");
        }

        // Stampa totale connessioni
        System.out.println("Connessioni totali: " + db1.getConnectionCount());
    }
}
