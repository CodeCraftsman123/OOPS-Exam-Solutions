import java.util.*;
class Books
{
    String title,author;
    long ISBN;
    String avaibility;
    Books(String title,String author,long ISBN, String avaibility)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.avaibility = avaibility;
    }

    public String toString()
    {
        return "[title="+title+" ,author="+author+" ,ISBN="+ISBN+" ,avaibility="+avaibility+"]";
    }
}

class main21
{
    static void addNewbook(ArrayList<Books>al,Scanner scanner)
    {
        System.out.println("Enter title of the book");
        String title = scanner.nextLine();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter ISBN number:");
        long ISBN = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter availibility:");
        String avaibility = scanner.nextLine();
        al.add(new Books(title,author,ISBN,avaibility));
    }

    static void borrowingBook(ArrayList<Books>al,Scanner scanner)
    {
        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();
        Iterator<Books> iterator = al.iterator();
        boolean bookExists = false;
        while(iterator.hasNext())
        {
            Books b = (Books)iterator.next();
            if(title.equals(b.title))
            {
                bookExists = true;
                break;
            }
        }
        iterator.remove();
        if(bookExists)
        {
            System.out.println("Book given to you successfully");
        }
        else 
        {
            System.out.println("This book cannot be given to you as it doesn't exists");
        }
    }

    static void returningBook(ArrayList<Books>al,Scanner scanner)
    {
        System.out.println("Enter title of the book");
        String title = scanner.nextLine();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter ISBN number:");
        long ISBN = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter availibility:");
        String avaibility = scanner.nextLine();
        al.add(new Books(title,author,ISBN,avaibility));
    }

    static void searchingForBook(ArrayList<Books>al,Scanner scanner)
    {
        System.out.println("Enter title of the book to search for:");
        String title = scanner.nextLine();
        Iterator<Books>iterator = al.iterator();
        boolean alreadyExists = false;
        while(iterator.hasNext())
        {
            Books b = (Books)iterator.next();
            if(title.equals(b.title))
            {
                System.out.println("Book info:"+b);
                alreadyExists = true;
                break;
            }
        }
        if(!alreadyExists)
            System.out.println("This book doesn't exists in library");
    }

    static void availableBook(ArrayList<Books>al)
    {
        Iterator<Books> iterator = al.iterator();
        while(iterator.hasNext())
        {
            Books b = (Books)iterator.next();
            System.out.print(b+" ");
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Books>al = new ArrayList<>();
        
    }
}