package contactsManager;

public class Contact {
    // Declaring string variables
    private String firstName;
    private String lastName;
    private String phoneNumber;


    public Contact(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    // First | Last | Phone #: output
    public String toString(){return this.firstName + " | " + this.lastName + " | Phone #: " + this.phoneNumber;}

    // Getters & Setters
    public String getFirstName() {return firstName; }

    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}

    public void setLastName(String lastName){this.lastName = lastName;}

    public String getPhoneNumber(){return phoneNumber;}

    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
}
