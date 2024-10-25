import java.util.*;
class WordCounterClass
{
    static HashSet<String> countUniqueWords(String text)
    {
        String[] array = text.split("\\s+");
        HashSet<String>h1 = new HashSet<>();
        for(String s:array)
        {
            s = s.replaceAll("[^a-zA-z]","");
            h1.add(s);
        }
        return h1;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();
        HashSet<String>h1 = WordCounterClass.countUniqueWords(text);
        System.out.println("Number of unique words:"+h1.size());
        scanner.close();
    }
}

// import java.util.*;

// class WordCounterClass {
//     static HashSet<String> countUniqueWords(String text) {
//         // Remove punctuation and split the text into words
//         text = text.replaceAll("[^a-zA-Z]", "");  // Only keeps letters and spaces
//         String[] array = text.split("\\s+");

//         // Use a HashSet to store unique words
//         HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(array));

//         return uniqueWords;
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter text:");
//         String text = scanner.nextLine();

//         HashSet<String> uniqueWords = WordCounterClass.countUniqueWords(text);
//         System.out.println("Number of unique words: " + uniqueWords.size());
//         scanner.close();
//     }
// }
