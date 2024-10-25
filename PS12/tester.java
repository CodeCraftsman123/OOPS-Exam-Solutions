import java.util.*;
class tester 
{
    static ArrayList<Integer> removeDuplicates(ArrayList<Integer>al)
    {
        LinkedHashSet<Integer>hs = new LinkedHashSet<>(al);
        al = new ArrayList<>(hs);
        return al;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer>al = new ArrayList<>(Arrays.asList(10,20,10,15,40,15,40));
        // al = tester.removeDuplicates(al);
        Iterator itr = al.iterator();

        while(itr.hasNext())
        {
            Integer i = (Integer) itr.next();
            System.out.print(i+" ");
        }

        boolean isExists = al.contains(10);
        System.out.println("\nisExists 10:"+isExists);
        isExists = al.contains(5);
        System.out.println("isExists 5:"+isExists);

        // al.add(1,5);
        // System.out.println("\nAfter adding:"+al.toString());

        // al.remove(2);
        // System.out.println("\nAfter removing:"+al.toString());

        // Collections.sort(al);
        // System.out.println("\nAfter using Collections.sort():"+al);

        // Collections.reverse(al);
        // System.out.println("\nAfter using Collections.reverse():"+al);

        ArrayList<Integer>al2 = new ArrayList<>(Arrays.asList(10,20,10,15,40,15,10));
        boolean isSame = al2.equals(al);
        System.out.println("isSame:"+isSame);

        System.out.println("1st occurrence of 10:"+al2.indexOf(10));
        System.out.println("Last occurrence of 10:"+al2.lastIndexOf(10));


    }
}