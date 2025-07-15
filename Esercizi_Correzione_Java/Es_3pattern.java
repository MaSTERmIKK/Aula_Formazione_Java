import java.util.ArrayList;
import java.util.List;

// Interfaccia base per hamburger (Component)
interface Hamburger {
    String getDescrizione();
    double getPrezzo();
}

// Classe base concreta
class BaseBurger implements Hamburger {
    public String getDescrizione() {
        return "Hamburger base";
    }

    public double getPrezzo() {
        return 3.50;
    }
}

// Classe astratta Decorator
abstract class HamburgerDecorator implements Hamburger {
    protected Hamburger hamburger;

    public HamburgerDecorator(Hamburger h) {
        this.hamburger = h;
    }
}

// Decoratore Formaggio
class FormaggioDecorator extends HamburgerDecorator {
    public FormaggioDecorator(Hamburger h) {
        super(h);
    }

    public String getDescrizione() {
        return hamburger.getDescrizione() + ", Formaggio";
    }

    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.50;
    }
}

// Decoratore Bacon
class BaconDecorator extends HamburgerDecorator {
    public BaconDecorator(Hamburger h) {
        super(h);
    }

    public String getDescrizione() {
        return hamburger.getDescrizione() + ", Bacon";
    }

    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.80;
    }
}

// INTERFACCIA OBSERVER
interface OsservatoreOrdine {
    void notificaOrdine(Hamburger h);
}

// SINGLETON + OBSERVER: gestore ordini
class GestoreOrdini implements OsservatoreOrdine {
    private static GestoreOrdini istanza;
    private List<Hamburger> ordini;

    private GestoreOrdini() {
        ordini = new ArrayList<>();
    }

    public static GestoreOrdini getInstance() {
        if (istanza == null) {
            istanza = new GestoreOrdini();
        }
        return istanza;
    }

    public void notificaOrdine(Hamburger h) {
        ordini.add(h);
        System.out.println("[GESTORE] Ordine registrato: " + h.getDescrizione() + " - Prezzo: €" + h.getPrezzo());
    }

    public void stampaRiepilogo() {
        System.out.println("\n=== Riepilogo Ordini ===");
        for (Hamburger h : ordini) {
            System.out.println("- " + h.getDescrizione() + " (€" + h.getPrezzo() + ")");
        }
    }
}

// MAIN con logica applicativa
public class OrdineHamburger {
    public static void main(String[] args) {
        // Creazione hamburger con formaggio e bacon
        Hamburger ordine1 = new BaseBurger();
        ordine1 = new FormaggioDecorator(ordine1);
        ordine1 = new BaconDecorator(ordine1);

        // Creazione hamburger solo con bacon
        Hamburger ordine2 = new BaseBurger();
        ordine2 = new BaconDecorator(ordine2);

        // Recupero singleton del gestore ordini
        GestoreOrdini gestore = GestoreOrdini.getInstance();

        // Notifica (observer)
        gestore.notificaOrdine(ordine1);
        gestore.notificaOrdine(ordine2);

        // Riepilogo
        gestore.stampaRiepilogo();
    }
}
