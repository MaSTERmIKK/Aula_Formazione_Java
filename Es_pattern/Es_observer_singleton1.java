import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Investitore {
    void notifica(String azione, double valore);
}

// Implementazione concreta 1
class InvestitorePrivato implements Investitore {
    private String nome;

    public InvestitorePrivato(String nome) {
        this.nome = nome;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Privato " + nome + ": Nuovo valore di " + azione + " è " + valore + "€");
    }
}

// Implementazione concreta 2
class InvestitoreBancario implements Investitore {
    private String istituto;

    public InvestitoreBancario(String istituto) {
        this.istituto = istituto;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Banca " + istituto + ": Nuovo valore di " + azione + " è " + valore + "€");
    }
}

// Classe Subject implementata come Singleton
class AgenziaBorsa {
    private static AgenziaBorsa istanza; // istanza Singleton
    private List<Investitore> investitori;

    private AgenziaBorsa() {
        investitori = new ArrayList<>();
    }

    public static AgenziaBorsa getIstanza() {
        if (istanza == null) {
            istanza = new AgenziaBorsa();
        }
        return istanza;
    }

    public void registraInvestitore(Investitore i) {
        investitori.add(i);
    }

    public void rimuoviInvestitore(Investitore i) {
        investitori.remove(i);
    }

    public void aggiornaValoreAzione(String azione, double valore) {
        System.out.println("\n[Aggiornamento] " + azione + " ora vale " + valore + "€");
        for (Investitore i : investitori) {
            i.notifica(azione, valore);
        }
    }
}

// Main per testare tutto
public class NotificheBorsa {
    public static void main(String[] args) {
        // Otteniamo l’unica istanza della borsa
        AgenziaBorsa borsa = AgenziaBorsa.getIstanza();

        // Creiamo investitori
        Investitore i1 = new InvestitorePrivato("Mario");
        Investitore i2 = new InvestitoreBancario("Banca Intesa");

        // Registrazione
        borsa.registraInvestitore(i1);
        borsa.registraInvestitore(i2);

        // Aggiornamenti
        borsa.aggiornaValoreAzione("AAPL", 152.3);
        borsa.aggiornaValoreAzione("GOOGL", 2890.1);
    }
}
