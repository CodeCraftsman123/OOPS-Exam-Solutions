import java.util.*;
class main8
{
    static void sum(int[] arrayElements)
    {
        int sum = 0;
        for(int element:arrayElements)
            sum += element;
        System.out.println("Addition of all array Elements:"+sum); 
    }

    static void max(int[] arrayElements)
    {
        int max = arrayElements[0];
        for(int num:arrayElements)
        {
            if(num>max)
                max = num;
        }
        System.out.println("Maximum number:"+max);
    }

    static void min(int[] arrayElements)
    {
        int min = arrayElements[0];
        for(int num:arrayElements)
        {
            if(num<min)
                min = num;
        }
        System.out.println("Minimum number:"+min);
    }

    static void sort(int... arrayElements1)
    {
        //Bubble sort
        for(int i =0 ; i< arrayElements1.length ; i++)
        {
            for(int j = 0 ; j < (arrayElements1.length - 1); j++)
            {
                if(arrayElements1[j]>arrayElements1[j+1])
                {
                    int temp = arrayElements1[j];
                    arrayElements1[j] = arrayElements1[j+1];
                    arrayElements1[j+1] = temp;
                }
            }
        }
    }

    static void reverse(int... copyOfArrayElements2)
    {
        for(int i = 0 ; i< (copyOfArrayElements2.length / 2);i++)
        {
            int temp = copyOfArrayElements2[i];
            copyOfArrayElements2[i] = copyOfArrayElements2[copyOfArrayElements2.length - i - 1];
            copyOfArrayElements2[copyOfArrayElements2.length-i-1] = temp;
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int size = scanner.nextInt();

        int[] arrayElements = new int[size];

        System.out.println("Enter elements:");
        for(int i = 0 ; i < size ;i++)
        {
            arrayElements[i] = scanner.nextInt();
        }

        main8.sum(arrayElements);

        main8.max(arrayElements);

        main8.min(arrayElements);

        int[] copyOfArrayElements1 = Arrays.copyOf(arrayElements,arrayElements.length);
        main8.sort(copyOfArrayElements1);

        System.out.println("\nOriginal Array:"+Arrays.toString(arrayElements)+"\nSorted Array:"+Arrays.toString(copyOfArrayElements1));

        int[] copyOfArrayElements2 = Arrays.copyOf(arrayElements,arrayElements.length);
        
        main8.reverse(copyOfArrayElements2);

        System.out.println("\nOrginial Array:"+Arrays.toString(arrayElements)+"\nReversed Array:"+Arrays.toString(copyOfArrayElements2));


        scanner.close();
    }
}