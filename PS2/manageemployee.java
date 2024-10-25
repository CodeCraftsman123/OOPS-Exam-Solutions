import java.util.Scanner;
class employee 
{
    String name;
    int employeeID;
    long hourlyRate;
    employee(String name,int employeeID,long hourlyRate)
    {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
    }
    
}

class fulltimeemployes extends employee 
{
    long salary;
    String benefits;
    fulltimeemployes(String name,int employeeID,long hourlyRate,long salary,String benefits)
    {
        super(name,employeeID,hourlyRate);
        this.salary = salary;
        this.benefits = benefits;
    }
    public String toString()
    {
        return "[name="+name + ", employeeID="+employeeID+", hourlyRate="+hourlyRate+", Salary="+salary+", benefits:"+benefits+"]" ;
    }
}

class parttimeemployee extends employee 
{
    int noOfHoursWorked;
    long overTimeRate;
    parttimeemployee(String name,int employeeID,long hourlyRate,int noOfHoursWorked,long overTimeRate)
    {
        super(name,employeeID,hourlyRate);
        this.noOfHoursWorked = noOfHoursWorked;
        this.overTimeRate = overTimeRate;
    }

    public String toString()
    {
        return "[name="+name+", employeeID="+employeeID+", hourlyRate="+hourlyRate+", noOfHoursWorked="+noOfHoursWorked+", overTimeRate="+overTimeRate+"]";
    }
}



public class manageemployee {
    static void takeFullEmployeesInput(fulltimeemployes[] fte,Scanner scanner,int noOfFullTimeEmployees)
    {
    for(int i = 0;i<noOfFullTimeEmployees;i++)
        {
            System.out.println("Enter information of fulltimeemployee "+ (i+1));
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter employeeID:");
            int employeeID = scanner.nextInt();
            System.out.println("Enter hourlyRate:");
            long hourlyRate = scanner.nextLong();
            System.out.println("Enter salary:");
            long salary = scanner.nextLong();
            System.out.println("Enter benefits:");
            scanner.nextLine();
            String benefits = scanner.nextLine();
            fte[i] = new fulltimeemployes(name,employeeID,hourlyRate,salary,benefits);
        } 
    }
    static void takePartEmployeesInput(parttimeemployee[] pte,Scanner scanner,int noOfPartTimeEmployees)
    {
        for(int i = 0;i<noOfPartTimeEmployees ; i++)
        {
            System.out.println("Enter information of parttimeemployee "+(i+1));
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter employeeID:");
            int employeeID = scanner.nextInt();
            System.out.println("Enter hourlyRate:");
            long hourlyRate = scanner.nextLong();
            System.out.println("Enter number of hours worked:");
            int noOfHoursWorked = scanner.nextInt();
            System.out.println("Enter overTimeRate:");
            long overTimeRate = scanner.nextLong();
            pte[i] = new parttimeemployee(name,employeeID,hourlyRate,noOfHoursWorked,overTimeRate);
            scanner.nextLine();
        }     
    }

    static void watchData(fulltimeemployes[] fte,parttimeemployee[] pte,Scanner scanner)
    {
        System.out.println("1.To watch data of fulltime employee\n2.To watch data of parttime employee\nEnter choice:");
        int viewInfo = scanner.nextInt();
        System.out.println("Enter employeeID of the person of which you want to see data:");
        int employeeID = scanner.nextInt();
        if(viewInfo == 1)
        {
            boolean alreadyExists = false;
            for(fulltimeemployes fe : fte)
            {
                if(fe.employeeID == employeeID)
                {
                    alreadyExists = true;
                    System.out.println(fe.toString());
                }
            }
            if(!alreadyExists)
                System.out.println("Employee with EmployeeID "+ employeeID +"doesn't exists in fulltime employee");
        }
        else if(viewInfo == 2)
        {
            boolean alreadyExists = false;
            for(parttimeemployee pe :pte)
            {
                if(pe.employeeID == employeeID)
                {
                    alreadyExists = true;
                    System.out.println(pe.toString());
                }
            }
            if(!alreadyExists)
                System.out.println("Employee with EmployeeID "+employeeID+"doesn't exists in parttime employee");
        }
        else 
        {
            System.out.println("You entered wrong input");
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of fulltimeemployees:");
        int noOfFullTimeEmployees = scanner.nextInt();
        fulltimeemployes[] fte = new fulltimeemployes[noOfFullTimeEmployees];
        scanner.nextLine();
        manageemployee.takeFullEmployeesInput(fte,scanner,noOfFullTimeEmployees);
        
        System.out.println("Enter total number part-time employees:");
        int noOfPartTimeEmployees = scanner.nextInt();
        parttimeemployee[] pte = new parttimeemployee[noOfPartTimeEmployees];
        scanner.nextLine();
        manageemployee.takePartEmployeesInput(pte,scanner,noOfPartTimeEmployees);

        while(true)
        {
            System.out.println("1.View data\n2.Exit\nEnter choice:");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    manageemployee.watchData(fte,pte,scanner);
                    break;
                case 2:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have entered wrong input");
            }
        }   
    }
}
