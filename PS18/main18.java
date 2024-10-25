import java.util.*;
class main18
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string:");
        String myString = scanner.nextLine();
        myString = myString.replace(" ","");
        HashSet<Character>hs = new HashSet<>();
        char[] ch = myString.toCharArray();
        if(myString.length() >= 1)
        {
            int globalMax = 0,localMax = 0;

            for(int i = 0;i < myString.length();i++)
            {
                for(int j=i;j < myString.length();j++)
                {
                    if(hs.contains(ch[j]))
                    {
                        if(globalMax<localMax)
                            globalMax = localMax;
                        hs.clear();
                        localMax = 0;
                    }
                    else 
                    {
                        hs.add(ch[j]);
                        localMax++;
                    }
                }
            }
            if(localMax>globalMax)
                globalMax = localMax;
            System.out.println("Substring with maximum number of characters without repetation:"+globalMax);
        }
        else{
            System.out.println("Length is zero so no substring");
        }

    }
}