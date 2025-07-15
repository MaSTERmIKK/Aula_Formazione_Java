// FAÇADE + SINGLETON + STRATEGY

// Subsystem 1: BIOS
class Bios {
    public void inizializza() {
        System.out.println("BIOS: inizializzazione...");
    }
}

// Subsystem 2: HardDisk
class HardDisk {
    public void carica() {
        System.out.println("HardDisk: caricamento sistema operativo...");
    }
}

// Subsystem 3: Sistema Operativo con Strategy per il boot
interface BootStrategy {
    void avvia();
}

class WindowsBoot implements BootStrategy {
    public void avvia() {
        System.out.println("Sistema Operativo: Avvio di Windows...");
    }
}

class LinuxBoot implements BootStrategy {
    public void avvia() {
        System.out.println("Sistema Operativo: Avvio di Linux...");
    }
}

class SistemaOperativo {
    private BootStrategy strategia;

    public void setBootStrategy(BootStrategy strategia) {
        this.strategia = strategia;
    }

    public void avvia() {
        if (strategia != null) {
            strategia.avvia();
        } else {
            System.out.println("Nessuna strategia di avvio selezionata.");
        }
    }
}

// FAÇADE + SINGLETON
class ComputerFacade {
    private static ComputerFacade istanza;
    private Bios bios;
    private HardDisk disco;
    private SistemaOperativo so;

    private ComputerFacade() {
        bios = new Bios();
        disco = new HardDisk();
        so = new SistemaOperativo();
    }

    public static ComputerFacade getInstance() {
        if (istanza == null) {
            istanza = new ComputerFacade();
        }
        return istanza;
    }

    public void setBootStrategy(BootStrategy strategia) {
        so.setBootStrategy(strategia);
    }

    public void accendiComputer() {
        bios.inizializza();
        disco.carica();
        so.avvia();
    }
}

// MAIN
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ComputerFacade pc = ComputerFacade.getInstance();

        System.out.println("Seleziona sistema operativo: 1 = Windows, 2 = Linux");
        int scelta = input.nextInt();

        if (scelta == 1) {
            pc.setBootStrategy(new WindowsBoot());
        } else {
            pc.setBootStrategy(new LinuxBoot());
        }

        pc.accendiComputer();
        input.close();
    }
}
