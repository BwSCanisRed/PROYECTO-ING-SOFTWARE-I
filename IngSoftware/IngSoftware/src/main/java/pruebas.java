
import java.util.Scanner;

public class pruebas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("El nombre ingresado es: " + nombre);

        scanner.close();
    }
}