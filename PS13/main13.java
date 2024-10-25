import java.util.*;
public class main13 {
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        // int position = 3;

        // for(int i = 0 ; i < position ; i++)
        // {
        //     int lastelement = array[array.length - 1];
        //     for(int j = (array.length - 2); j >= 0 ;j--)
        //     {
        //        array[j+1] = array[j];
        //     }
        //     array[0] = lastelement;
        // }

        // System.out.println("After rotation:"+Arrays.toString(array));

    //     int[] copyOfArray = Arrays.copyOf(array,array.length);

    //     for(int i = 0;i < copyOfArray.length;i++)
    //     {
    //         if(copyOfArray[i]!=0)
    //         {
    //             for(int j = i+1;j < copyOfArray.length ; j++)
    //             {
    //                 if(copyOfArray[i] == copyOfArray[j])
    //                 {
    //                     copyOfArray[j] = 0;
    //                 }
    //             }
    //         }
    //     }
    //     int index = 0;
    //     for(int i = 0;i < copyOfArray.length ;i++)
    //     {
    //         if(copyOfArray[i]!=0)
    //         {
    //             array[index++] = copyOfArray[i];
    //         }
    //     }
    //     for(int i = index ; i < copyOfArray.length ; i++)
    //     {
    //         array[i] = 0;
    //     }

    //     System.out.println("After removing duplicates:"+Arrays.toString(array));

        int indexForEvenElements = 0,indexForOddElements = 0;
        int[] evenArray = new int[array.length];
        int[] oddArray = new int[array.length];
        for(int i = 0;i<array.length;i++)
        {
            if(array[i]%2 == 0)
                evenArray[indexForEvenElements++] = array[i]; 
            else 
                oddArray[indexForOddElements++] = array[i];
        }
        int index = 0;
        for(;index < indexForEvenElements ; index++)
        {
            array[index] = evenArray[index];
        }
        for(int i = 0;i<indexForOddElements ; i++)
        {
            array[index++] = oddArray[i];
        }
        System.out.println("Array with even numbers before odd numbers:"+Arrays.toString(array));
    }
}
