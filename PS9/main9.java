import java.util.*;
class main9
{
    public static void main(String[] args)
    {
    //     Scanner scanner = new Scanner(System.in);

    //     String string1 = "Prasad";

    //     String string2 = "Kamble";

    //    String string3 = string1.concat(string2);
    //    System.out.println("After performing concat operation:"+string3);
       
    //    int lengthOfString1 = string1.length();
    //    int lengthOfString2 = string2.length();
    //     System.out.println("The length of "+string1+":"+lengthOfString1+"\nThe length of "+string2+":"+lengthOfString2);

    //     String string4 = string1.toUpperCase();
    //     String string5 = string2.toLowerCase();

    //     System.out.println("\nUppercase:"+string4+"\nLowercase:"+string5);

    //     boolean contains = string1.contains("sad");
    //     if(contains)
    //         System.out.println("string1 contains substring");
    //     else 
    //         System.out.println("string1 doesn't contains substring");

    //     string1 = string1.replaceAll("sad","happy");
        
    //     System.out.println(string1);


        // scanner.close();






        String originalString = "Hello, World, hi, hello, World, World";
        String substringToReplace = "World";
        String newString = "Java";

        int index = originalString.indexOf(substringToReplace);
        int lastIndex  = 0;
        StringBuffer finalString = new StringBuffer();
        while(index!=-1)
        {
            finalString.append(originalString.substring(lastIndex,index));
            finalString.append(newString);
            lastIndex = index + substringToReplace.length();
            index = originalString.indexOf(substringToReplace,lastIndex);
        }
        System.out.println(finalString);





































































    }
}