import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a verbe : ");
        String v = scanner.nextLine();

        boolean isGood =  Verbe.deleteEr(v);
        
        System.out.print(isGood);

	}

}

