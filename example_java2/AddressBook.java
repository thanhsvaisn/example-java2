package addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choose;

        do {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choose = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()

            switch (choose) {
                case 1:
                    addContact(scanner, contacts);
                    break;
                case 2:
                    findContactByName(scanner, contacts);
                    break;
                case 3:
                    displayContacts(contacts);
                    break;
                case 4:
                    System.out.println("Exiting the Address Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choose != 4);

        scanner.close();
    }

    static void addContact(Scanner scanner, HashMap<String, Contact> contacts) {
        System.out.print("Enter contact's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact's phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = new Contact(name, phoneNumber);
        contacts.put(name, newContact);
        System.out.println("Contact added successfully!");

    }

    static void findContactByName(Scanner scanner, HashMap<String, Contact> contacts) {
        System.out.print("Enter name to find contact: ");
        String nameToFind = scanner.nextLine();

        Contact foundContact = contacts.get(nameToFind);
        if (foundContact != null) {
            System.out.println("Phone number of " + nameToFind + " is " + foundContact.getPhoneNumber());
        } else {
            System.out.println("Contact not found!");
        }
    }

    static void displayContacts(HashMap<String, Contact> contacts) {
        System.out.println("\nAddress Book");
        System.out.printf("%-15s %-15s\n", "Contact Name" , "Phone number");
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();
            System.out.printf("%-15s %-15s\n" , contact.getName() , contact.getPhoneNumber());
        }
    }
}