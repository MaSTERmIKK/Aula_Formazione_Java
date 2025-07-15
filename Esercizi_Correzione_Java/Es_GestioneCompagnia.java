import java.util.ArrayList;

// Classe Aereo
class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        setNumeroPosti(numeroPosti); // usa il setter per validazione
        this.codice = codice;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        }
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void stampaInfo() {
        System.out.println("Aereo: " + modello + ", Posti: " + numeroPosti + ", Codice: " + codice);
    }
}

// Classe Pilota
class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        setOreVolo(oreVolo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        }
    }

    public void stampaInfo() {
        System.out.println("Pilota: " + nome + ", Brevetto: " + numeroBrevetto + ", Ore volo: " + oreVolo);
    }
}

// Classe CompagniaAerea
class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta = new ArrayList<>();
    private ArrayList<Pilota> piloti = new ArrayList<>();

    public CompagniaAerea(String nome) {
        this.nome = nome;
    }

    public void aggiungiAereo(Aereo a) {
        flotta.add(a);
    }

    public void aggiungiPilota(Pilota p) {
        piloti.add(p);
    }

    public void stampaInfo() {
        System.out.println("Compagnia Aerea: " + nome);
        System.out.println("Flotta:");
        for (Aereo a : flotta) {
            a.stampaInfo();
        }
        System.out.println("Piloti:");
        for (Pilota p : piloti) {
            p.stampaInfo();
        }
    }
}

// Main
public class GestioneCompagnia {
    public static void main(String[] args) {
        CompagniaAerea compagnia = new CompagniaAerea("SkyWings");

        Aereo a1 = new Aereo("Boeing 737", 150, "SW001");
        Aereo a2 = new Aereo("Airbus A320", 180, "SW002");

        Pilota p1 = new Pilota("Mario Rossi", "BRV123", 2000);
        Pilota p2 = new Pilota("Laura Bianchi", "BRV456", 1500);

        compagnia.aggiungiAereo(a1);
        compagnia.aggiungiAereo(a2);
        compagnia.aggiungiPilota(p1);
        compagnia.aggiungiPilota(p2);

        compagnia.stampaInfo();
    }
}
