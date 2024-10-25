class shape 
{
    void area(double length,double breadth)
    {
        System.out.println("Area of rectangle:"+(length*breadth));
    }

    void area(int side)
    {
        System.out.println("Area of square:"+(side*side));
    }

    void area(double radius)
    {
        System.out.println("Area of circle:"+(Math.PI*radius*radius));
    }

}

class main5
{
    public static void main(String[] args)
    {
        shape s = new shape();
        s.area(3,4);
        s.area(2);
        s.area(2.0);
    }
}