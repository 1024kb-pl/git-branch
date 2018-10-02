package pl.maniaq;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public void createUser() {
        String name, lastname;
        Integer age;

        System.out.println("Type a name: ");
        name = scanner.next();

        System.out.println("Type a lastname: ");
        lastname = scanner.next();

        System.out.println("Type your age: ");
        age = scanner.nextInt();

        User user = new User(name, lastname, age);
        System.out.println("Utworzono Usera: " + user.toString());
    }

    public static void main(String[] args) {
	// write your code here
    }
}
