// import java.util.*;

// class main11
// {
//     static boolean armStrongNo(int noInInt,int length)
//     {
//         int[] array = new int[length];
//         int copyOfNoInInt = noInInt;
//         for(int i = 0;i < length ; i++)
//         {
//             array[i] = noInInt % 10;
//             noInInt = noInInt / 10;
//         }

//         // for(int i = 0;i < (length/2) ;i++)
//         // {
//         //     int temp = array[i];
//         //     array[i] = array[length-i-1];
//         //     array[length-i-1]=temp;
//         // }
//         int sum = 0;
//         for(int i = 0;i < length ;i++)
//         {
//             sum += Math.pow(array[i],length);
//         }
//         if(sum==copyOfNoInInt)
//             return true;

//         return false;
//     }
//     public static void main(String[] args)
//     {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter Number:");
//         String noInString = scanner.nextLine();
//         noInString = noInString.replace(" ","");
//         int noInInt = Integer.parseInt(noInString);
//         int length = noInString.length();
//         if(main11.armStrongNo(noInInt,length))
//             System.out.println("The given number is ArmStrong number");
//         else 
//             System.out.println("The given number is not an ArmStrong number");
//     }
// }


import java.util.Scanner;
class main11
{
    public static void main(String[] args)
    {
        // Scanner scanner = new Scanner(System.in);
        // String numInString = scanner.nextLine();
        // numInString = numInString.replace(" ","");
        // int num = Integer.parseInt(numInString);
        // int copyOfNum = num;
        // int sum=0;
        // while(num > 0)
        // {
        //     sum = sum+(int)Math.pow((num%10),numInString.length()); 
        //     num = num / 10;
        // }
        // if(copyOfNum == sum)
        //     System.out.println("The given number is ArmStrong number");
        // else  
        //     System.out.println("The given number is not an ArmStrong number");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String1:");
        String myString1 = scanner.nextLine();
        myString1 = myString1.replace(" ","");
        System.out.println("Enter String2:");
        String myString2 = scanner.nextLine();
        myString2 = myString2.replace(" ","");

        if(myString1.length() == myString2.length())
        {
            char[] ch1 = myString1.toCharArray();
            char[] ch2 = myString2.toCharArray();
            boolean[] array = new boolean[myString1.length()];
            boolean ans = true;
            for(int i = 0; i < myString1.length() ; i++)
                array[i] = false;
            for(int i = 0 ; i < myString1.length();i++)
            {
                for(int j = 0 ; j < myString2.length() ; j++)
                {
                    if(ch1[i] == ch2[j])
                    {
                        array[i] = true;
                        ch1[i] = ' ';
                        ch2[j] = ' ';
                        break;
                    }
                }
            }
            for(int i = 0 ; i < myString1.length();i++)
            {
                if(array[i] == false)
                    ans = false;
            }

            if(ans)
                System.out.println("The given Strings are anagram");
            else 
                System.out.println("The given Strings are not anagram");
        }
        else 
        {
            System.out.println("The given Strings are not Anagram");
        }
        scanner.close();
    }
}