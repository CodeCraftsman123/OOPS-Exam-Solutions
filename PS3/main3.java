abstract class shape
{
    abstract double calculateArea();
    abstract double calculatePerimeter();
    abstract void displayResult();
}

class circle extends shape 
{
    double radius;

    circle(double radius)
    {
        this.radius = radius;
    }

    double calculateArea()
    {
        return (Math.PI*radius*radius);
    }

    double calculatePerimeter()
    {
        return (2*Math.PI*radius);
    }

    void displayResult()
    {
        double area = this.calculateArea();
        double perimeter = this.calculatePerimeter();
        System.out.println("\nRadius:"+radius+"\nArea:"+area+"\nPerimeter:"+perimeter);
    }
}

class rectangle extends shape 
{
    double length,breadth;

    rectangle(double length,double breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }

    double calculateArea()
    {
        return (length*breadth);
    }

    double calculatePerimeter()
    {
        return (2*(length+breadth));
    }

    void displayResult()
    {
        double area = this.calculateArea();
        double perimeter = this.calculatePerimeter();
        System.out.println("\nLength:"+length+"\nBreadth:"+breadth+"\nArea:"+area+"\nPerimeter:"+perimeter);
    }
}

class triangle extends shape 
{
   double side1,side2,side3;

   triangle(double side1,double side2,double side3)
   {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
   }

   double calculateArea()
   {
        double s =((side1+side2+side3)/2);
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
   }

   double calculatePerimeter()
   {
        return (side1 + side2 + side3);
   }

   void displayResult()
   {
        System.out.println("\nside1:"+side1+"\nside2:"+side2+"\nside3:"+side3+"\nArea:"+this.calculateArea()+"\nPerimeter:"+this.calculatePerimeter());
   }
    
}

class main3
{
    public static void main(String[] args)
    {
        circle c = new circle(3);
        c.displayResult();
        rectangle r = new rectangle(2,4);
        r.displayResult();
        triangle t = new triangle(3,4,5);
        t.displayResult();
    }
}