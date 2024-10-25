import java.util.*;
interface Purchaseable<T>
{
    void addItem(ArrayList<T> al,Scanner scanner);
    void removeItem(ArrayList<T>al,Scanner scanner);
    int totalPrice(int noOfQuantity,int priceOfItem);
    void viewAllElements(ArrayList<T>al);
}

class Electronics implements Purchaseable<Electronics>
{
    String name;
    int noOfQuantity;
    int priceOfItem;
    int totalPrice;
    Electronics(){}
    Electronics(String name,int noOfQuantity,int priceOfItem,int totalPrice)
    {
        this.name = name;
        this.noOfQuantity = noOfQuantity;
        this.priceOfItem = priceOfItem;
        this.totalPrice = totalPrice;
    }
    public void addItem(ArrayList<Electronics>al,Scanner scanner)
    {
        System.out.println("Enter name of Item:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter noOfQuantity:");
        int noOfQuantity = scanner.nextInt();
        System.out.println("Enter priceOfItem:");
        int priceOfItem = scanner.nextInt();
        int totalPrice = this.totalPrice(noOfQuantity,priceOfItem);
        al.add(new Electronics(name,noOfQuantity,priceOfItem,totalPrice));
    }
    public void removeItem(ArrayList<Electronics>al,Scanner scanner)
    {
        System.out.println("Enter name of Item you want to remove:");
        scanner.nextLine();
        String name = scanner.nextLine();
        Iterator<Electronics>iterator = al.iterator();
        boolean alreadyExists = false;
        while(iterator.hasNext())
        {
            Electronics e = (Electronics)iterator.next();
            if(name.equals(e.name))
            {
                alreadyExists = true;
                break;
            }
        }
        if(alreadyExists)
        {
            iterator.remove();
            System.out.println("Element removed successfully");
        }
        else 
            System.out.println("This element doesn't exists in the record and hence cannot be removed");

    }

    public void viewAllElements(ArrayList<Electronics>al)
    {
        System.out.println("All elements of ArrayList of Electronics:");
        Iterator<Electronics> iterator = al.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    public String toString()
    {
        return "[name="+name+", noOfQuantity="+noOfQuantity+", priceOfItem="+priceOfItem+", totalPrice="+totalPrice+"]";
    }
    public int totalPrice(int noOfQuantity,int priceOfItem)
    {
        return (noOfQuantity*priceOfItem);
    }
}

class Clothing implements Purchaseable<Clothing>
{
    Clothing(){}
    String name;
    int noOfQuantity;
    int priceOfItem;
    int totalPrice;
    Clothing(String name,int noOfQuantity,int priceOfItem,int totalPrice)
    {
        this.name = name;
        this.noOfQuantity = noOfQuantity;
        this.priceOfItem = priceOfItem;
        this.totalPrice = totalPrice;
    }
    public void addItem(ArrayList<Clothing>al,Scanner scanner)
    {
        System.out.println("Enter name of Item:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter noOfQuantity:");
        int noOfQuantity = scanner.nextInt();
        System.out.println("Enter priceOfItem:");
        int priceOfItem = scanner.nextInt();
        int totalPrice = this.totalPrice(noOfQuantity,priceOfItem);
        al.add(new Clothing(name,noOfQuantity,priceOfItem,totalPrice));
    }
    public void removeItem(ArrayList<Clothing>al,Scanner scanner)
    {
        System.out.println("Enter name of Item you want to remove:");
        scanner.nextLine();
        String name = scanner.nextLine();
        Iterator<Clothing>iterator = al.iterator();
        boolean alreadyExists = false;
        while(iterator.hasNext())
        {
            Clothing c = (Clothing)iterator.next();
            if(name.equals(c.name))
            {
                alreadyExists = true;
                break;
            }
        }
        if(alreadyExists)
        {
            iterator.remove();
            System.out.println("Element removed successfully");
        }
        else 
            System.out.println("This element doesn't exists in the record and hence cannot be removed");

    }
    public int totalPrice(int noOfQuantity,int priceOfItem)
    {
        return (noOfQuantity*priceOfItem);
    }

    public void viewAllElements(ArrayList<Clothing>al)
    {
        System.out.println("All elements of ArrayList of Clothing:");
        Iterator<Clothing> iterator = al.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    public String toString()
    {
        return "[name="+name+", noOfQuantity="+noOfQuantity+", priceOfItem="+priceOfItem+", totalPrice="+totalPrice+"]";
    }
}

class Books implements Purchaseable<Books> 
{
    Books(){}
    String name;
    int noOfQuantity;
    int priceOfItem;
    int totalPrice;
    Books(String name,int noOfQuantity,int priceOfItem,int totalPrice)
    {
        this.name = name;
        this.noOfQuantity = noOfQuantity;
        this.priceOfItem = priceOfItem;
        this.totalPrice = totalPrice;
    }
    public void addItem(ArrayList<Books>al,Scanner scanner)
    {
        System.out.println("Enter name of Item:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter noOfQuantity:");
        int noOfQuantity = scanner.nextInt();
        System.out.println("Enter priceOfItem:");
        int priceOfItem = scanner.nextInt();
        int totalPrice = this.totalPrice(noOfQuantity,priceOfItem);
        al.add(new Books(name,noOfQuantity,priceOfItem,totalPrice));
    }
    public void removeItem(ArrayList<Books>al,Scanner scanner)
    {
        System.out.println("Enter name of Item you want to remove:");
        scanner.nextLine();
        String name = scanner.nextLine();
        Iterator<Books>iterator = al.iterator();
        boolean alreadyExists = false;
        while(iterator.hasNext())
        {
            Books b = (Books)iterator.next();
            if(name.equals(b.name))
            {
                alreadyExists = true;
                break;
            }
        }
        if(alreadyExists)
        {
            iterator.remove();
            System.out.println("Element removed successfully");
        }
        else 
            System.out.println("This element doesn't exists in the record and hence cannot be removed");

    }
    public int totalPrice(int noOfQuantity,int priceOfItem)
    {
        return (noOfQuantity*priceOfItem);
    }

    public void viewAllElements(ArrayList<Books>al)
    {
        System.out.println("All elements of ArrayList of Books:");
        Iterator<Books> iterator = al.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    public String toString()
    {
        return "[name="+name+", noOfQuantity="+noOfQuantity+", priceOfItem="+priceOfItem+", totalPrice="+totalPrice+"]";
    }
}

class shoppingcartmanager
{
    static int giveresponse(Scanner scanner)
    {
        System.out.println("1.add Item 2.remove Item 3.View all Items\nEnter choice:");
        int ans = scanner.nextInt();
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Electronics>al1 = new ArrayList<>();
        ArrayList<Clothing>al2 = new ArrayList<>();
        ArrayList<Books>al3 = new ArrayList<>();

        int choice,ans;
        while(true)
        {
            System.out.println("1.Electronics 2.Clothing 3.Books 4.Exit\nEnter choice");
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    ans = shoppingcartmanager.giveresponse(scanner);
                    Electronics e = new Electronics();
                    if(ans == 1)
                    {
                        e.addItem(al1,scanner);
                    }
                    else if(ans == 2)
                    {
                        e.removeItem(al1,scanner);
                    }
                    else if(ans == 3)
                    {
                        e.viewAllElements(al1);
                    }
                    else 
                    {
                        System.out.println("You entered wrong input");
                    }
                    break;
                case 2:
                    ans = shoppingcartmanager.giveresponse(scanner);
                    Clothing c = new Clothing();
                    if(ans == 1)
                    {
                        c.addItem(al2,scanner);
                    }
                    else if(ans == 2)
                    {
                        c.removeItem(al2,scanner);
                    }
                    else if(ans == 3)
                    {
                        c.viewAllElements(al2);
                    }
                    else 
                    {
                        System.out.println("You entered wrong input");
                    }
                    break;
                case 3:
                    ans = shoppingcartmanager.giveresponse(scanner);
                    Books b = new Books();
                    if(ans == 1)
                    {
                        b.addItem(al3,scanner);
                    }
                    else if(ans == 2)
                    {
                        b.removeItem(al3,scanner);
                    }
                    else if(ans == 3)
                    {
                        b.viewAllElements(al3);
                    }
                    else 
                    {
                        System.out.println("You entered wrong input");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("You entered wrong input");
            }
        }
    }
}