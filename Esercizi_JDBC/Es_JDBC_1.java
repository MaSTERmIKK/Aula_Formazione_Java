import java.sql.*;
import java.util.Scanner;

public class FilmRentalApp {

    // Credenziali database
    static final String URL = "jdbc:mysql://localhost:3306/sakila"; // o il nome del DB
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Mostra i 10 film PIÙ noleggiati");
            System.out.println("2. Mostra i 10 film MENO noleggiati");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    mostraFilm(true); // più noleggiati
                    break;
                case 2:
                    mostraFilm(false); // meno noleggiati
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);
        scanner.close();
    }

    // Metodo per mostrare film ordinati
    public static void mostraFilm(boolean piuNoleggiati) {
        String order = piuNoleggiati ? "DESC" : "ASC";
        String sql = """
            SELECT f.title, COUNT(r.rental_id) AS numero_noleggi
            FROM film f
            JOIN inventory i ON f.film_id = i.film_id
            JOIN rental r ON i.inventory_id = r.inventory_id
            GROUP BY f.title
            ORDER BY numero_noleggi """ + order + """
            LIMIT 10
        """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\nFilm\t\t\tNoleggi");
            System.out.println("-------------------------------");

            while (rs.next()) {
                String titolo = rs.getString("title");
                int conteggio = rs.getInt("numero_noleggi");
                System.out.printf("%-30s %d\n", titolo, conteggio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
