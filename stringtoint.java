//Take array input from user without telling him the size and then convert it in int array and find shortest amongst it
import java.util.Scanner;
class stringtoint
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array elements separated by ,:");
        String elementsInString = scanner.nextLine();
        String[] arrayElementsInString = elementsInString.split(",");
        int length = arrayElementsInString.length;
        int[] intArray = new int[length];
        int i = 0;

        for(String element: arrayElementsInString)
        {
            intArray[i] = Integer.parseInt(element.trim());
            i++;
        }

        System.out.println("Array Elements in intArray:");
        for(int element:intArray)
            System.out.print(element+"  ");

        scanner.close();
    }
}