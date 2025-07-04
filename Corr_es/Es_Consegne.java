// Import
import java.util.*;

// Classe astratta VeicoloConsegna
abstract class VeicoloConsegna {
    protected String targa;
    protected float caricoMassimo;

    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    public abstract void consegnaPacco(String destinazione);

    public void stampaInfo() {
        System.out.println("Targa: " + targa + " | Carico massimo: " + caricoMassimo + " kg");
    }
}

// Interfaccia Tracciabile
interface Tracciabile {
    void tracciaConsegna(String codiceTracking);
}

// Classe Furgone
class Furgone extends VeicoloConsegna implements Tracciabile {
    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    public void consegnaPacco(String destinazione) {
        System.out.println("Furgone con targa " + targa + " in consegna a " + destinazione);
    }

    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracciamento via strada: codice " + codiceTracking);
    }
}

// Classe Drone
class Drone extends VeicoloConsegna implements Tracciabile {
    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    public void consegnaPacco(String destinazione) {
        System.out.println("Drone con identificativo " + targa + " in volo verso " + destinazione);
    }

    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracciamento automatico drone: codice " + codiceTracking);
    }
}

// Classe principale
public class ConsegnaManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();

        veicoli.add(new Furgone("AB123CD", 1500));
        veicoli.add(new Drone("DR-001", 10));

        for (VeicoloConsegna v : veicoli) {
            v.stampaInfo();
            v.consegnaPacco("Via Roma 25");
            if (v instanceof Tracciabile) {
                ((Tracciabile) v).tracciaConsegna("TRK" + new Random().nextInt(9999));
            }
            System.out.println("---");
        }

        input.close();
    }
}
