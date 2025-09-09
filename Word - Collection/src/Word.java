//Elia Schwartz, June 5, 2025, COP 3330C - 33777
/*This program attempts to get eight individual words from the user, then input those values
into an ArrayList while manipulating how it is organized and displayed to the console.*/
/*With the use of the Collections framework, students will learn how to use it to control and access
 * data. */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class Word {
    public static void main(String[] args) {
        String word;

        //Creating an ArrayList and a Scanner
        ArrayList<String> wordList = new ArrayList<>();
        Scanner userThought = new Scanner(System.in);

        //A loop that allow the user to input a word 8 times
        while (wordList.size() < 8) {
            System.out.println("Enter a single word (Please reframe from adding duplicate entries): ");
            word = userThought.nextLine();

            boolean isDuplicate = false;
            //A loop, assessing if a word in the ArrayList is added twice despite being lowercase or uppercase.
            for (String list : wordList) {
                if (list.equalsIgnoreCase(word)) {
                    isDuplicate = true;
                    break;
                }
            }
           /*Checks if there is a duplicate word, displays a message that it is already there
             else add the word to the wordList arraylist.*/
            if (isDuplicate) {
                System.out.println(word + " can't be added to the list");
            } else {
                wordList.add(word);
            }
        }

        //An enhanced for loop that gets each word individually from its index and prints it to the console.
        System.out.println("The original words in the arraylist contains the following: ");
        for (String list : wordList) {
            System.out.println(list);
        }

        //Outputting the size of the arraylist.
        System.out.println("The size of the word List arraylist is " + wordList.size() + ".");

        //Variable that holds the first element in the arraylist.
        String longEntry = wordList.get(0);
        String shortEntry = wordList.get(0);
        // An enhanced for loop to evaluate which word in the list is the longest and the shortest.
        for (String list : wordList) {
            if (list.length() > longEntry.length()) {
                longEntry = list;
            }
            if (list.length() < shortEntry.length()) {
                shortEntry = list;
            }
        }
        //Print the longest entry, and the shortest entry within the list.
        System.out.println("The shortest word in the list is " + shortEntry + ".");
        System.out.println("The longest word in the list is " + longEntry + ".");

        //It's sorting the words in the arraylist. Lines 69-70.
        System.out.println("The words in the arraylist are now sorted in alphabetical order.");
        Collections.sort(wordList);
        System.out.println(wordList);

        //Sorted by the character length. Lines 73-77
        System.out.println("The arraylist is sorted by character length from longest to shortest: ");
        wordList.sort(Comparator.comparingInt(String::length).reversed());
        for (String list : wordList) {
            System.out.println(list);
        }

        //Shuffling the list. Lines 80 & 81.
        Collections.shuffle(wordList);
        System.out.println("Let's switch things up! The arraylist is now shuffled in a different order. \n" + wordList);

        //Searching for a particular word from the user. Lines 84 - 98.
        System.out.println("What word would you like to search for in the list? Please look at the shuffle ");
        String searchWord = userThought.nextLine();
        boolean isFound = false;
        //A loop that helps to search through the arraylist for a particular word given by the user.
        //Using the shuffle arraylist to get the position of the word in the arraylist.
        for (int i = 0; i <wordList.size(); i++) {
            //See if the word is contained in the list, regardless of the case of the word.
            if (wordList.get(i).equalsIgnoreCase(searchWord) && wordList.contains(wordList.get(i))) {

                System.out.println("The word " + searchWord + " is at the " + (i+1) + " position in the shuffle arraylist.");
                isFound = true;
                break;
            }
        }
        //The word is not found, a statement is displayed.
        if(!isFound){
            System.out.println("The word you are searching for in not in this arraylist.");
        }

        //Using the binary search method in the Collections class. First Collections Static Method.
        //New a sorted list to operate
        Collections.sort(wordList);
        System.out.println("What word would you like to see using binary search? Please look at the alphabetical ordered list:");
        word = userThought.nextLine();
        //A faster way to search through a list.
        int binaryWord = Collections.binarySearch(wordList, word);
        //The index of the word found is greater than zero, then print out a statement
        if (binaryWord >= 0) {
            System.out.println("The following is the binary location for the word: " + word + " - " +
                    (Integer.toBinaryString(binaryWord +1) + " in the alphabetical order arraylist."));
            //Integer.toBinaryString is turning the index into a binary representation string
        }
        else {
            System.out.println("Invalid");
        }

        //Converting an ArrayList to an Array
        String[] wordsArray = wordList.toArray(wordList.toArray(new String[0]));
        System.out.println("The arraylist was converted to an array.");
        for(String wordInArray: wordsArray){
            System.out.println(wordInArray);
        }

        //Converting an Array into an ArrayList.
        ArrayList<String> newWordList = new ArrayList<>(Arrays.asList(wordsArray));
        System.out.println("Converting the array back into an arraylist: " + newWordList);

        //Using fill method from the Collections class. Second Collection Static Method
        System.out.println("What word would you like to fill the arraylist with?");
        word = userThought.nextLine();
        //Using the user input to fill all the elements in the arraylist.
        Collections.fill(wordList, word);
        System.out.println("The list is now fill using the word " + word);
        for (String list : wordList) {
            System.out.println(list);
        }
   }
}
/*Collections vs Collection
Collections have pre-declared static methods in the Java util package that are used to implement a variety
*manipulations and operations on sections of code for different uses on objects.
A collection is an interface that holds classes and deals with groups of object types and parameters.
It offers simple methods for accessing and organizing data through its sub-interface, Collection.
Ex: List, Sets, Queues. The methods include, but are not limited to, add(), remove(), and size().
*
*Interface vs class
*Interface only has method declarations without code implementation; each method in the interface
must be used in a class. To use an interface, the keyword implements must be after the Class declaration
with the interface name.
*Class is a blueprint for creating objects. It defines attributes and methods for an object to take
characteristics or actions (Java, Java, Java).
It easily helps associate attributes and behavior with multiple objects simultaneously.
Without class, objects would be an empty shell of an item or person, and
programmers would have to input everything by hand.

*References:
*https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
*https://runestone.academy/ns/books/published/javajavajava/what-is-programming.html#what-is-programming-7-3
*https://www.geeksforgeeks.org/collection-vs-collections-in-java-with-example/
 */