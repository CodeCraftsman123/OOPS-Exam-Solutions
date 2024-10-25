interface Drawable
{
    void draw();
}

interface Resizeable
{
    void resize(double factor);
}

class circle implements Drawable,Resizeable
{
    public void draw()
    {
        System.out.println("Drawing for circle done");
    }
    
    public void resize(double factor)
    {
        System.out.println("Resizing done with factor:"+factor+" for circle");
    }

}

class rectangle implements Drawable 
{
    public void draw()
    {
        System.out.println("Drawing for rectangle done");
    }
}

class main7
{
    public static void main(String[] args)
    {
        circle c = new circle();
        c.draw();

        rectangle r = new rectangle();
        r.draw();

        c.resize(3.2);

    }
}