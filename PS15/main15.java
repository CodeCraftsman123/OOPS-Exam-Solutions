abstract class Employee 
{
    String name;
    int employeeID;
    float extraHoursWorked;
    int rateOfExtraHour;
    int bonus;
    abstract int calculateSalary();

    Employee(String name,int employeeID,float extraHoursWorked,int rateOfExtraHour,int bonus)
    {
        this.name = name;
        this.employeeID = employeeID;
        this.extraHoursWorked = extraHoursWorked;
        this.rateOfExtraHour = rateOfExtraHour;
        this.bonus = bonus;
    }
}

class partTimeEmployee extends Employee 
{
    
    float noOfHoursWorked;
    int hourlyRate;

    partTimeEmployee(String name,int employeeID,float extraHoursWorked,int rateOfExtraHour,int bonus,float noOfHoursWorked,int hourlyRate)
    {
        super(name,employeeID,extraHoursWorked,rateOfExtraHour,bonus);
        this.noOfHoursWorked = noOfHoursWorked;
        this.hourlyRate = hourlyRate;
    }
    //Assuming person works 5 days a week with noOfHoursWorked hours and 5 weeks per month :->Total hours worked=noOfHoursWorked*5*5 + Extrahours * 5 *5
    int calculateSalary()
    {
        return  Math.round(((noOfHoursWorked*5*5*hourlyRate) + bonus +( extraHoursWorked * 5* 5 * rateOfExtraHour )))  ;
    }
}

class fullTimeEmployee extends Employee 
{
    float monthlySalary;
    fullTimeEmployee(String name,int employeeID, float extraHoursWorked, int rateOfExtraHour, int bonus, float monthlySalary)
    {
        super(name,employeeID,extraHoursWorked,rateOfExtraHour,bonus);
        this.monthlySalary = monthlySalary;
    }
    int calculateSalary()
    {
        return Math.round(monthlySalary + extraHoursWorked*rateOfExtraHour + bonus );
    }

}
class main15
{
    public static void main(String[] args)
    {
        partTimeEmployee e1 = new partTimeEmployee("Rohan",2,0,1000,0,7,300);
        System.out.println("Salary of person1:"+e1.calculateSalary());

        fullTimeEmployee e2 = new fullTimeEmployee("Rahul",5,2,100,5000,80000);
        System.out.println("Salary of person2:"+e2.calculateSalary());
    }
}

