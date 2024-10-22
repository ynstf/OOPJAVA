import java.util.Scanner;

public class MyClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a verb: ");
        String v = scanner.nextLine();

        Result result = Verbe.deleteEr(v);
        if (result.isValid) {
            Verbe.generateConj(result.verbRoot);
        }
    }
}