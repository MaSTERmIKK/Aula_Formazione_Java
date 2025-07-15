import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Display {
    void aggiorna(float temperatura);
}

// Classe Subject (Osservato)
class StazioneMeteo {
    private List<Display> displayRegistrati;
    private float temperatura;

    public StazioneMeteo() {
        displayRegistrati = new ArrayList<>();
    }

    // Aggiunge un observer
    public void aggiungiDisplay(Display d) {
        displayRegistrati.add(d);
    }

    // Rimuove un observer
    public void rimuoviDisplay(Display d) {
        displayRegistrati.remove(d);
    }

    // Imposta una nuova temperatura e notifica tutti gli observer
    public void setTemperatura(float nuovaTemperatura) {
        this.temperatura = nuovaTemperatura;
        notificaDisplay();
    }

    // Notifica tutti gli observer
    private void notificaDisplay() {
        for (Display d : displayRegistrati) {
            d.aggiorna(temperatura);
        }
    }
}

// Implementazione concreta di Display: Console
class DisplayConsole implements Display {
    public void aggiorna(float temperatura) {
        System.out.println("Display Console - Temperatura aggiornata: " + temperatura + "°C");
    }
}

// Implementazione concreta di Display: Mobile
class DisplayMobile implements Display {
    public void aggiorna(float temperatura) {
        System.out.println("Display Mobile - Temperatura aggiornata: " + temperatura + "°C");
    }
}

// Classe principale con il main
public class OsservatoreMeteo {
    public static void main(String[] args) {
        StazioneMeteo meteo = new StazioneMeteo();

        Display display1 = new DisplayConsole();
        Display display2 = new DisplayMobile();

        meteo.aggiungiDisplay(display1);
        meteo.aggiungiDisplay(display2);

        meteo.setTemperatura(22.5f);  // prima notifica
        meteo.setTemperatura(25.0f);  // seconda notifica
    }
}
