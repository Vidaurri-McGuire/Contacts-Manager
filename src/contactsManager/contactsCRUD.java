package contactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class contactsCRUD {
// JANUARY 3 ISSUE: DO WHILE IN STARTMENU();

    public static int startMenu() throws IOException {

        boolean userContinues = true;
        do {
            System.out.println(" 1. View contacts");
            System.out.println(" 2. Add a new contact");
            System.out.println(" 3. Search a contact by name.");
            System.out.println(" 4. Delete an existing contact.");
            System.out.println(" 5. Exit.");
            System.out.println(" Enter an option (1, 2, 3, 4 or 5): ");

            Scanner sc = new Scanner(System.in);
            int userOption = sc.nextInt();

            switch (userOption) {
                case 1 -> viewContacts();
                case 2 -> addContact();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                default -> System.out.println("Thank you for using our contacts app!");
            }
            System.out.println("Would you like to continue? (y/n)");
            String userResponse = sc.next();

            if (userResponse.equalsIgnoreCase("y")) {
                startMenu();
            }else{
                System.out.println("Thank you for using our contacts app!");
            }
            return userOption;

        }while(userContinues);

    }

    public static void viewContacts() throws IOException {

            Path contactsPath = Paths.get("src/contactsManager", "contacts.txt");
            List<String> contactsList = Files.readAllLines(contactsPath);
            for (int i = 0; i < contactsList.size(); i++) {
                System.out.println(contactsList.get(i));
            }

    }

    public static void addContact() throws IOException {
        Scanner sc = new Scanner(System.in);

        String firstName;
        String lastName;
        String phoneNumber;
        System.out.println("Enter first name");
        firstName = sc.nextLine();

        System.out.println("Enter last");
        lastName = sc.nextLine();

        System.out.println("Enter #");
        phoneNumber = sc.nextLine();

        Contact newContact = new Contact(firstName, lastName, phoneNumber );

        Files.write(
                Paths.get("src/contactsManager", "contacts.txt"),
                Arrays.asList(newContact.toString()),
                StandardOpenOption.APPEND);

        System.out.println("Contact added");
    }

     public static void searchContact() throws IOException {
         Scanner sc = new Scanner(System.in);

         String searchName;

         System.out.println("Please enter the first name of the contact you would like to find.");
         searchName = sc.nextLine();


             Path contactsPath = Paths.get("src/contactsManager", "contacts.txt");
             List<String> contactsList = Files.readAllLines(contactsPath);
             boolean contactFound = false;
                 for (String contact : contactsList) {
                         if (contact.contains(searchName)) {
                             contactFound = true;
                             System.out.println(contact);
                      }
                    }
                        if(!contactFound){
                        System.out.println("Sorry,contact not found");
                 }
            }



     public static void deleteContact() throws IOException {
         Scanner sc = new Scanner(System.in);

         System.out.println("Who would you like to delete?");
         String userInput = sc.nextLine();

         Path contactsPath = Paths.get("src/contactsManager", "contacts.txt");
         List<String> contactsList = Files.readAllLines(contactsPath);
         List<String> newList = new ArrayList<>();

         for(String contact : contactsList){
             if(contact.contains(userInput)){
                 newList.remove(contact);
                 continue;
             }
             newList.add(contact);
         }

         Files.write(Paths.get("src/contactsManager", "contacts.txt"), newList);

         System.out.println(userInput + " has been deleted!");

     }
}


