package contactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class contactsCRUD {

    public static int startMenu() throws IOException {




            System.out.println(" 1. View contacts");
            System.out.println(" 2. Add a new contact");
            System.out.println(" 3. Search a contact by name.");
            System.out.println(" 4. Delete an existing contact.");
            System.out.println(" Enter an option (1, 2, 3 or 4): ");

            Scanner sc = new Scanner(System.in);
            int userOption = sc.nextInt();

        // switch/case that allows us to call methods from userOption
            switch (userOption) {
                case 1 -> viewContacts();
                case 2 -> addContact();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                default -> System.out.println("Thank you for using our contacts app!");
                }

            System.out.println("\nWould you like to continue? (y/n)");
            String userResponse = sc.next();

            if (userResponse.equalsIgnoreCase("y")) {
                startMenu();
            }else{
                System.out.println("Thank you for using our contacts app!");
            }
            return userOption;

    }

    public static void viewContacts() throws IOException {

        Path contactsPath = Paths.get("src/contactsManager", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);

    // for loop to iterate through contacts list and print all objects in contactsList
        for (int i = 0; i < contactsList.size(); i++) {
            System.out.println(contactsList.get(i));
        }
    }

    public static void addContact() throws IOException {
        Scanner sc = new Scanner(System.in);

    // initializing contact properties
        String firstName;
        String lastName;
        String phoneNumber;

    // user prompts
        System.out.println("\nEnter first name:");
        firstName = sc.nextLine();

        System.out.println("Enter last name:");
        lastName = sc.nextLine();

        System.out.println("Enter phone #:");
        phoneNumber = sc.nextLine();

    // initializing new contact
        Contact newContact = new Contact(firstName, lastName, phoneNumber );

    // appending new contact to .txt file
        Files.write(
                Paths.get("src/contactsManager", "contacts.txt"),
                Collections.singletonList(newContact.toString()),
                StandardOpenOption.APPEND);

        System.out.println("\nContact added!");
    }

     public static void searchContact() throws IOException {
         Scanner sc = new Scanner(System.in);

         String searchName;

         System.out.println("Please enter the first name, last name or phone number of the contact you would like to find.");
         searchName = sc.nextLine();

             Path contactsPath = Paths.get("src/contactsManager", "contacts.txt");
             List<String> contactsList = Files.readAllLines(contactsPath);

             boolean contactFound = false;

            // enhanced for/each loop to run through our contactsList and return the user search
                 for (String contact : contactsList) {
                     if (contact.contains(searchName)) {
                         contactFound = true;
                         System.out.println(contact);
                        }
                    }

                // if user searches for contact that doesn't exist
                    if(!contactFound){
                    System.out.println("Sorry,contact not found");
                 }
            }

     public static void deleteContact() throws IOException {
         Scanner sc = new Scanner(System.in);

         System.out.println("Enter first or last name of contact to delete");
         String userInput = sc.nextLine();

         Path contactsPath = Paths.get("src/contactsManager", "contacts.txt");
         List<String> contactsList = Files.readAllLines(contactsPath);
         List<String> newList = new ArrayList<>();

         boolean contactDeleted = false;

     // enhanced for/each loop to run through contactsList & search for userInput
         for(String contact : contactsList){
             if(contact.contains(userInput)){
                 contactDeleted = true;
                 newList.remove(contact);
                 continue;
             }
             newList.add(contact);
            }

         // if statement prints message in case contact is not in .txt file
             if(!contactDeleted){
                 System.out.println("Sorry, contact not found.");
             }else{
                 Files.write(Paths.get("src/contactsManager", "contacts.txt"), newList);
                 System.out.println(userInput + " has been deleted!");
             }
        }
     }



