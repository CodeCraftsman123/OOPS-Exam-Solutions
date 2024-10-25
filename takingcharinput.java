import java.util.Scanner;
class takingcharinput
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter character:");

        char character = scanner.next().charAt(0);

        System.out.print("The character you entered:"+character);

        scanner.close();
    }
}