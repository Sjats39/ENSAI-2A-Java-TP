import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        HashMap<String, String> userDatabase = loadUserDatabase(
                "/home/onyxia/ENSAI-2A-Java-TP/tp1/data/user_hashpwd.csv");
        Scanner scanner = new Scanner(System.in);
        String username;
        HashMap<String, Integer> nb_visited = new HashMap<String, Integer>();
        String password;
        Boolean moins_trois_essais = true;
        while (moins_trois_essais) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();

            // Check if the username exists in the user database
            if (userDatabase.containsKey(username)) {
                System.out.print("Enter password: ");
                password = scanner.nextLine();

                // Increment the visit count using computeIfAbsent and computeIfPresent
                nb_visited.computeIfAbsent(username, key -> 1); // If absent, set the initial value to 0
                nb_visited.computeIfPresent(username, (key, value) -> value + 1); // Increment visits

                if (password.equals(userDatabase.get(username))) {
                    System.out.println("Login successful!");
                    break;
                }
                if (nb_visited.get(username) > 3) {
                    moins_trois_essais = false;
                    System.out.println("Too many attempts");

                }
            }
        }

        // Close the scanner after input is done
        scanner.close();
    }

    /**
     * Loads a user database from a CSV file.
     * The CSV file is expected to have two columns: username and hashed password.
     * 
     * @param filename The path to the CSV file containing user data.
     * @return A HashMap where keys are usernames and values are hashed passwords.
     * 
     * @throws IOException If an error occurs while reading the file.
     */
    public static HashMap<String, String> loadUserDatabase(String filename) {
        HashMap<String, String> userDatabase = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userDatabase.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return userDatabase;
    }
}
