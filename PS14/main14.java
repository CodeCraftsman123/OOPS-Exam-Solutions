import java.util.*;
class main14
{
    static void takeinput(int[] array,Scanner scanner)
    {
        
        for(int i = 0 ; i < array.length ; i++)
        {
            array[i] = scanner.nextInt();
        }
    }

    static int[] findIntersection(int[] array1,int[] array2)
    {
        Boolean[] answers;
        if(array1.length>array2.length)
        {
            answers = new Boolean[array2.length];
            for(int i = 0 ; i < array2.length ; i++)
            {
                answers[i] = false;
            }
            for(int i = 0; i < array2.length ; i++ )
            {
                for(int j = 0;j < array1.length ; j++)
                {
                    if(array2[i] == array1[j])
                    {
                        answers[i] = true;
                        break;
                    }
                }
            }

            int numberOftrue = 0 ;
            for(int i = 0;i < array2.length ; i++)
            {
                if(answers[i] == true)
                    numberOftrue++;
            }
            if(numberOftrue == 0)
                return new int[]{};
            
            int[] intersectionArray = new int[numberOftrue];
            int indexForIntersectionArray = 0;
            for(int i = 0; i < array2.length ; i++)
            {
                if(answers[i] == true)
                    intersectionArray[indexForIntersectionArray++] = array2[i];
            }
            return intersectionArray;
        }
        else 
        {
            answers = new Boolean[array1.length];
            for(int i = 0;i < array1.length ; i++)
                answers[i] = false;
            for(int i = 0 ; i < array1.length ;i++)
            {
                for(int j = 0;j < array2.length ; j++)
                {
                    if(array1[i] == array2[j])
                    {
                        answers[i] = true;
                        break;
                    }
                }
            }
            int numberOfTrue = 0 ;
            for(int i = 0 ; i < array1.length;i++)
                if(answers[i] == true)
                    numberOfTrue++;

            if(numberOfTrue == 0)
                return new int[]{};
                
            int[] interSectionArray = new int[numberOfTrue];
            int indexForInterSectionArray = 0;
            
            for(int i = 0 ; i < array1.length ; i++)
                if(answers[i] == true)
                    interSectionArray[indexForInterSectionArray++] = array1[i];
                    
            return interSectionArray;
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array1:");
        int size1 = scanner.nextInt();
        System.out.println("Enter size of array2:");
        int size2 = scanner.nextInt();
        int[] array1 = new int[size1];
        int[] array2 = new int[size2];
        System.out.println("Enter array1 elements:");
        main14.takeinput(array1,scanner);
        System.out.println("Enter array2 elements:");
        main14.takeinput(array2,scanner);

        int[] interSectionArray = main14.findIntersection(array1,array2);
        System.out.println("\nIntersection of two arrays:"+Arrays.toString(interSectionArray));

    }
}