package contactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class updateContacts {

    public static int startMenu() {

        System.out.println(" 1. View contacts");
        System.out.println(" 2. Add a new contact");
        System.out.println(" 3. Search a contact by name.");
        System.out.println(" 4. Delete an existing contact.");
        System.out.println(" 5. Exit.");
        System.out.println(" Enter an option (1, 2, 3, 4 or 5): ");

        Scanner sc = new Scanner(System.in);
        int userOption = sc.nextInt();
        return userOption;

    }


    public static void main(String[] args) throws IOException {
//            System.out.println(startMenu());
        FileReader fileReader = new FileReader("src/contactsManager", "contacts.txt");
            Files.write(
                    Paths.get("src/contactsManager", "contacts.txt"),
                    Arrays.asList("Ryan McGuire 123-4567"),
                    StandardOpenOption.APPEND);

        Path contactsPath = Paths.get("src/contactsManager", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);
        for (int i = 0; i < contactsList.size(); i++) {
            System.out.println(contactsList.get(i));
        }
    }
}


