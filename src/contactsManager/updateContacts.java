package contactsManager;

import java.util.Scanner;

public class updateContacts {

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

    public static void main(String[] args){
        System.out.println(startMenu());
    }
}
