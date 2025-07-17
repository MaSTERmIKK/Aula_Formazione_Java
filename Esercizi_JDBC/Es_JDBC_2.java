import java.sql.*;
import java.util.Scanner;

public class GestioneClienti {

    static final String URL = "jdbc:mysql://localhost:3306/sakila";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n===== MENU CLIENTI =====");
            System.out.println("1. Clienti con nome che inizia per A");
            System.out.println("2. Numero clienti per città");
            System.out.println("3. 5 clienti più recenti");
            System.out.println("4. Tutti i clienti ordinati per data di registrazione");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> clientiPerLettera('A');
                case 2 -> contaClientiPerCitta();
                case 3 -> clientiPiuRecenti();
                case 4 -> clientiOrdinatiPerData();
                case 0 -> System.out.println("Uscita dal programma.");
                default -> System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);
        scanner.close();
    }

    // 1. Clienti il cui nome inizia con una lettera
    public static void clientiPerLettera(char lettera) {
        String sql = "SELECT first_name, last_name FROM customer WHERE first_name LIKE ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lettera + "%");
            ResultSet rs = stmt.executeQuery();

            System.out.println("\nClienti con nome che inizia per " + lettera + ":");
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Conta clienti per città
    public static void contaClientiPerCitta() {
        String sql = """
            SELECT ci.city, COUNT(c.customer_id) AS numero_clienti
            FROM customer c
            JOIN address a ON c.address_id = a.address_id
            JOIN city ci ON a.city_id = ci.city_id
            GROUP BY ci.city
            ORDER BY numero_clienti DESC
            """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\nNumero clienti per città:");
            while (rs.next()) {
                System.out.printf("%-20s %d\n", rs.getString("city"), rs.getInt("numero_clienti"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Mostra i 5 clienti più recenti
    public static void clientiPiuRecenti() {
        String sql = "SELECT first_name, last_name, create_date FROM customer ORDER BY create_date DESC LIMIT 5";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n5 clienti più recenti:");
            while (rs.next()) {
                System.out.printf("%s %s - %s\n",
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getTimestamp("create_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Mostra tutti i clienti ordinati per data
    public static void clientiOrdinatiPerData() {
        String sql = "SELECT first_name, last_name, create_date FROM customer ORDER BY create_date ASC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\nClienti ordinati per data di registrazione:");
            while (rs.next()) {
                System.out.printf("%s %s - %s\n",
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getTimestamp("create_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
