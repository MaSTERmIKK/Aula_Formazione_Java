// Import
import java.util.*;

// Classe astratta Hamburger
abstract class Hamburger {
    protected String nome;

    public Hamburger(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void prepara();
}

// Sottoclasse Cheeseburger
class Cheeseburger extends Hamburger {
    public Cheeseburger() {
        super("Cheeseburger");
    }

    public void prepara() {
        System.out.println("Preparazione Cheeseburger: pane, carne, formaggio, ketchup");
    }
}

// Sottoclasse VegBurger
class VegBurger extends Hamburger {
    public VegBurger() {
        super("VegBurger");
    }

    public void prepara() {
        System.out.println("Preparazione VegBurger: pane integrale, burger vegetale, insalata, pomodoro");
    }
}

// Sottoclasse DoubleBacon
class DoubleBacon extends Hamburger {
    public DoubleBacon() {
        super("DoubleBacon");
    }

    public void prepara() {
        System.out.println("Preparazione DoubleBacon: pane, doppia carne, bacon, cheddar, maionese");
    }
}

// Classe principale
public class Hamburgeria {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Hamburger> ordini = new ArrayList<>();
        Map<String, Integer> contatori = new HashMap<>();

        boolean continua = true;
        while (continua) {
            System.out.println("\n=== MENU HAMBURGERIA ===");
            System.out.println("1. Cheeseburger");
            System.out.println("2. VegBurger");
            System.out.println("3. DoubleBacon");
            System.out.println("4. Visualizza ordini e prepara");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            int scelta = Integer.parseInt(input.nextLine());

            Hamburger ordine = null;
            switch (scelta) {
                case 1:
                    ordine = new Cheeseburger();
                    break;
                case 2:
                    ordine = new VegBurger();
                    break;
                case 3:
                    ordine = new DoubleBacon();
                    break;
                case 4:
                    System.out.println("\n=== PREPARAZIONE ORDINI ===");
                    for (Hamburger h : ordini) {
                        h.prepara();
                    }
                    continue;
                case 5:
                    continua = false;
                    continue;
                default:
                    System.out.println("Scelta non valida.");
                    continue;
            }

            if (ordine != null) {
                ordini.add(ordine);
                String nome = ordine.getNome();
                contatori.put(nome, contatori.getOrDefault(nome, 0) + 1);
                System.out.println("Ordine aggiunto: " + nome);

                if (contatori.get(nome) == 3) {
                    System.out.println("Ordine frequente: " + nome + " (3 volte)");
                }
            }
        }

        System.out.println("Chiusura hamburgeria. A presto.");
        input.close();
    }
}
