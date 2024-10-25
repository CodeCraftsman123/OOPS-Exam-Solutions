//Take an int array input from user and then find length of each element and display it
import java.util.Scanner;
class problem2 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements you want in an array:");
        int length = scanner.nextInt();
        int[] array = new int[length];
        System.out.println("Enter elements of an array seperated by space:");

        for(int i = 0 ; i < length ; i++)
            array[i] = scanner.nextInt();

        String[] arrayElements = new String[length];

        int i = 0;
        for(int element:array)
        {
            arrayElements[i] = Integer.toString(element).trim();
            i++;
        }
        System.out.println("No of elements in each element in array:");

        for(String element:arrayElements)
            System.out.print(element.length()+" ");

        scanner.close();
    }
}