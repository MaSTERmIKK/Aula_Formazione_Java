import java.util.ArrayList;

// Classe Auto
class Auto {
    String targa;
    String modello;

    Auto(String targa, String modello) {
        this.targa = targa;
        this.modello = modello;
    }

    // Metodo per visualizzare l'auto
    void stampaInfo() {
        System.out.println("Targa: " + targa + ", Modello: " + modello);
    }
}

// Classe Officina
class Officina {
    ArrayList<Auto> listaAuto = new ArrayList<>();

    // Aggiunge un'auto alla lista
    void aggiungiAuto(Auto auto) {
        listaAuto.add(auto);
    }

    // Stampa tutte le auto
    void stampaAutoPresenti() {
        for (Auto a : listaAuto) {
            a.stampaInfo();
        }
    }
}

// Main
public class GestioneOfficina {
    public static void main(String[] args) {
        Officina officina = new Officina();

        // Aggiunta di almeno due auto diverse
        officina.aggiungiAuto(new Auto("AB123CD", "Fiat Panda"));
        officina.aggiungiAuto(new Auto("EF456GH", "Ford Focus"));

        // Stampa dell'elenco delle auto
        officina.stampaAutoPresenti();
    }
}
