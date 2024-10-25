class calculator 
{
    double num1,num2;
    static double pi;
    calculator(double num1,double num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    static 
    {
        pi = Math.PI;
        System.out.println("Welcome ");
    }
    {
        System.out.println("New calculator instance created");
    }
    
    void add()
    {
        System.out.println("Addition:"+(num1+num2));
    }

    void subtract()
    {
       System.out.println("Subtraction:"+(num1-num2));
    }

    void multiplication()
    {
        System.out.println("Multiplication:"+(num1*num2));
    }

    void division()
    {
        if(num2 == 0)
            System.out.println("Cannot divide because divisor is 0");
        else 
            System.out.println("Division:"+(num1/num2));
    }
}

class main6
{
    public static void main(String[] args)
    {
        calculator c1 = new calculator(3,4);
        
        c1.add();
        c1.subtract();
        c1.multiplication();
        c1.division();
        
        System.out.println("-".repeat(20));
        calculator c2 = new calculator(5,6);
        c2.add();
        c2.subtract();
        c2.multiplication();
        c2.division();
    }
}