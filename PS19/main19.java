import java.util.*;

class invalidEmailException extends Exception
{
    invalidEmailException(String exception)
    {
        super(exception);
    }
}
class main19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter emailaddress:");
        String myString = scanner.nextLine();

        boolean booleanForDot = myString.contains(".");
        boolean booleanForAtTheRate = myString.contains("@");

        if(booleanForDot && booleanForAtTheRate)
        {
            int indexOfDot = myString.indexOf(".");
            int indexOfAtTheRate = myString.indexOf("@");
            if(indexOfDot<indexOfAtTheRate)
            {
                try 
                {
                    throw new invalidEmailException("Error: Invalid email address!Please enter a valid email address");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            else 
            {
                System.out.println("Thank you for registration");
            }
        }
        else 
        {
            try 
            {
                throw new invalidEmailException("Error: Invalid email address!Please enter a valid email address");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }
}