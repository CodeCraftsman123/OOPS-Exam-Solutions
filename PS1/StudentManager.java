import java.util.*;
class Student 
{
    String name;
    int rollno;
    String grade;

    Student(String name,int rollno, String grade)
    {
        this.name = name;
        this.rollno = rollno;
        this.grade = grade;
    }

    public String toString()
    {
        return "[name=" +name+", rollno="+rollno+", grade="+grade+"]";
    }
}

public class StudentManager {
    static void addStudent(ArrayList<Student> al,Scanner scanner)
    {
        int rollno;
        String name;
        String grade;
        boolean alreadyExists = false;
        System.out.println("Enter rollno:");
        rollno = scanner.nextInt();
        System.out.println("Enter name:");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.println("Enter grade:");
        grade = scanner.next();
        for(Student s: al)
        {
            if(s.rollno == rollno)
                alreadyExists = true;
        }
        if(alreadyExists)
        {
            System.out.println("The Student with rollno already exists so two students with same roll no cannot be added");
        }
        else 
        {
            al.add(new Student(name,rollno,grade));
            System.out.println("Element added successfully");
        }
    }



    static void removeStudent(ArrayList<Student>al,Scanner scanner)
    {
        System.out.println("Enter rollno to remove:");
        int rollno=scanner.nextInt();
        boolean alreadyExists = false;
        for(Student s:al)
        {
            if(s.rollno == rollno)
                alreadyExists = true;
        }
        if(alreadyExists)
        {
            Iterator<Student> itr = al.iterator();
            while(itr.hasNext())
            {
                Student s = (Student)itr.next();
                if(s.rollno == rollno)
                    break;
            }
            itr.remove();
            System.out.println("Record of the user removed successfully");
        }
        else 
        {
            System.out.println("Cannot delete record of this student as record of this student doesn't exists");
        }
    }
    static void displayAllElements(ArrayList<Student>al, Scanner scanner)
    {
        Iterator<Student>itr = al.iterator();
        System.out.println("Records of students:");
        while(itr.hasNext())
        {
            Student s = (Student)itr.next();
            System.out.println(s.toString());
        } 
    }
    static void replaceGrade(ArrayList<Student> al,Scanner scanner)
    {
        System.out.println("Enter roll no of student you want to replace:");
        int rollno = scanner.nextInt();
        boolean alreadyExists = false;
        Iterator<Student> itr = al.iterator(); 
        for(Student s:al)
        {
            if(s.rollno == rollno)
                alreadyExists = true;
        }
        if(alreadyExists)
        {
            System.out.println("Enter new grade of student:");
            scanner.nextLine();
            String grade = scanner.nextLine();
            Student s1;
            Iterator<Student>iterator = al.iterator();
            while(iterator.hasNext())
            {
                Student s = (Student)iterator.next();
                if(s.rollno == rollno)
                {
                    s.grade = grade;
                    break;
                }
            }
            System.out.println("Grade updated successfully");
        }
        else 
        {
            System.out.println("Cannot replace grade of this rollno as this student record doesn't exists");
        }
    }
    public static void main(String[] args)
    {
        ArrayList<Student>al = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("1.Add a student to the list\n2.Remove a student from the list\n3.Display all students in the list\n4.Replace the grade of any student\n5.Exit\nEnter choice:");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    StudentManager.addStudent(al,scanner);
                    break;
                case 2:
                    StudentManager.removeStudent(al,scanner);
                    break;
                case 3:
                    StudentManager.displayAllElements(al,scanner);
                    break;
                case 4:
                    StudentManager.replaceGrade(al,scanner);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default :
                    System.out.println("You have entered wrong option.");
            }
        }

    }
}
