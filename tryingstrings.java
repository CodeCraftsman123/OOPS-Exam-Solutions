class tryingstrings 
{
    public static void main(String[] args)
    {
        String s1 = new String("Prasad");
        String s2 = s1 ;
        System.out.println(s2);
        s1 = s1.concat("Kamble ");
        System.out.print(s2);//Prasad Kamble
    }
}