// Interfaccia comune
interface IVeicolo {
    void Avvia();
    void MostraTipo();
}

// Classi concrete
class Auto implements IVeicolo {
    public void Avvia() {
        System.out.println("Avvio dell'auto");
    }

    public void MostraTipo() {
        System.out.println("Tipo: Auto");
    }
}

class Moto implements IVeicolo {
    public void Avvia() {
        System.out.println("Avvio della moto");
    }

    public void MostraTipo() {
        System.out.println("Tipo: Moto");
    }
}

class Camion implements IVeicolo {
    public void Avvia() {
        System.out.println("Avvio del camion");
    }

    public void MostraTipo() {
        System.out.println("Tipo: Camion");
    }
}

// Classe Factory
class VeicoloFactory {
    public static IVeicolo CreaVeicolo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "auto":
                return new Auto();
            case "moto":
                return new Moto();
            case "camion":
                return new Camion();
            default:
                System.out.println("Tipo di veicolo non riconosciuto.");
                return null;
        }
    }
}

// Main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci tipo di veicolo (auto, moto, camion): ");
        String tipo = input.nextLine();

        IVeicolo v = VeicoloFactory.CreaVeicolo(tipo);

        if (v != null) {
            v.Avvia();
            v.MostraTipo();
        }

        input.close();
    }
}
