package contactsManager;

import java.io.IOException;
import java.util.Scanner;

public class updateContacts  {

    public static int startMenu(){

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

    public static int  allContacts() throws IOException {

//        FileReader fileReader = new FileReader("src/contactsManager", "contacts.txt");
        int people = 0;
        for (int i = 0 ;i < fileLines.size(); i++){
           people += i;
        }
        return people;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(startMenu());
        System.out.println(allContacts());



    }
}
