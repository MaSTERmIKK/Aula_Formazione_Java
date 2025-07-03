// Import necessari
import java.util.*;

// Classe base
class Astronauta {
    protected String nome;
    protected String email;
    protected float creditoOssigeno;

    public Astronauta(String nome, String email) {
        this.nome = nome;
        this.email = email;
        rigeneraOssigeno();
    }

    public void rigeneraOssigeno() {
        this.creditoOssigeno = 50 + (float)(Math.random() * 50); // Tra 50 e 100
    }

    public void stampaDati() {
        System.out.printf("Nome: %s | Email: %s | Ossigeno: %.2f\n", nome, email, creditoOssigeno);
    }
}

// Classe contenitore
class StazioneSpaziale {
    public static ArrayList<String> esperimenti = new ArrayList<>();
    public static ArrayList<Integer> valutazioni = new ArrayList<>();
}

// Classe derivata Scienziato
class Scienziato extends Astronauta {
    private int esperimentiInseriti = 0;

    public Scienziato(String nome, String email) {
        super(nome, email);
    }

    public void aggiungiEsperimento(String titolo) {
        StazioneSpaziale.esperimenti.add(titolo);
        esperimentiInseriti++;
        System.out.println("Esperimento aggiunto.");
        if (esperimentiInseriti == 3) {
            System.out.println("Hai raggiunto il ruolo di Scienziato Capo.");
        }
    }

    public boolean isCapo() {
        return esperimentiInseriti >= 3;
    }

    public void stampaEsperimenti() {
        System.out.println("Lista degli esperimenti:");
        for (String esp : StazioneSpaziale.esperimenti) {
            System.out.println("- " + esp);
        }
    }
}

// Classe derivata Ispettore
class Ispettore extends Astronauta {
    private int valutazioniInserite = 0;

    public Ispettore(String nome, String email) {
        super(nome, email);
    }

    public void aggiungiValutazione(int voto) {
        if (voto < 1 || voto > 5) {
            System.out.println("Valutazione non valida. Inserire un numero da 1 a 5.");
            return;
        }
        StazioneSpaziale.valutazioni.add(voto);
        valutazioniInserite++;
        System.out.println("Valutazione inserita.");
        if (valutazioniInserite == 3) {
            System.out.println("Hai raggiunto il ruolo di Ispettore Esperto.");
        }
    }

    public boolean isEsperto() {
        return valutazioniInserite >= 3;
    }

    public void stampaValutazioni() {
        System.out.println("Lista delle valutazioni:");
        for (int val : StazioneSpaziale.valutazioni) {
            System.out.println("- " + val);
        }
    }
}

// Classe principale
public class MissioneSpaziale {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("\n=== Menu ===");
            System.out.print("Inserisci il tuo nome: ");
            String nome = input.nextLine();
            System.out.print("Inserisci la tua email: ");
            String email = input.nextLine();

            System.out.print("Qual è il tuo pianeta preferito? ");
            String pianeta = input.nextLine().toLowerCase();

            Astronauta user;
            boolean isScienziato = pianeta.contains("marte") || pianeta.contains("terra");

            if (isScienziato) {
                user = new Scienziato(nome, email);
            } else {
                user = new Ispettore(nome, email);
            }

            boolean sessione = true;
            while (sessione) {
                System.out.println("\n1. Visualizza dati\n2. Rigenera ossigeno\n3. Interagisci con profilo\n4. Esci");
                System.out.print("Scelta: ");
                int scelta = Integer.parseInt(input.nextLine());

                switch (scelta) {
                    case 1:
                        user.stampaDati();
                        break;
                    case 2:
                        user.rigeneraOssigeno();
                        System.out.println("Ossigeno rigenerato.");
                        break;
                    case 3:
                        if (user instanceof Scienziato) {
                            Scienziato s = (Scienziato) user;
                            System.out.print("Titolo esperimento da aggiungere: ");
                            String exp = input.nextLine();
                            s.aggiungiEsperimento(exp);
                            if (s.isCapo()) {
                                System.out.print("Stampare tutti gli esperimenti? (s/n): ");
                                if (input.nextLine().equalsIgnoreCase("s")) {
                                    s.stampaEsperimenti();
                                }
                            }
                        } else if (user instanceof Ispettore) {
                            Ispettore i = (Ispettore) user;
                            System.out.print("Inserisci una valutazione (1-5): ");
                            int voto = Integer.parseInt(input.nextLine());
                            i.aggiungiValutazione(voto);
                            if (i.isEsperto()) {
                                System.out.print("Stampare tutte le valutazioni? (s/n): ");
                                if (input.nextLine().equalsIgnoreCase("s")) {
                                    i.stampaValutazioni();
                                }
                            }
                        }
                        break;
                    case 4:
                        sessione = false;
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                }
            }

            System.out.print("Vuoi ripetere con un nuovo astronauta? (s/n): ");
            if (!input.nextLine().equalsIgnoreCase("s")) {
                continua = false;
            }
        }
        input.close();
        System.out.println("Programma terminato.");
    }
}
