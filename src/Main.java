import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       // System.out.println("Hello world!"); IDE generated code
        //create scanner object and import file MORSECODE
        Scanner scan = new Scanner(new File("MORSECODE"));
        //create binary search tree object
        BinarySearchTree<Character> tree = new BinarySearchTree<Character>();
        //add root to start of tree
        tree.add('*');
        //while loop to add all the nodes to the tree
        while(scan.hasNextLine()){
            //create two individual strings from scanner
            String line = scan.nextLine();
            String code = line.substring(0, line.indexOf(" "));
            //store character
            char character = code.charAt(0);
            //add to morse code tree
            tree.add(character, 0, code);
        }
        //close scanner
        scan.close();
        //create scanner object and import file TESTMORSECODE
        Scanner scan2 = new Scanner(new File("TESTMORSECODE"));
        //while loop to read through the morse code file
        while(scan2.hasNextLine()) {
            //read in first line from file
            String line = scan2.nextLine();
            //output the code to decode
            System.out.println(line);
            //decode the morse code
            String sentance = decodeSentence(line, tree);
            //output the decoded sentance
            System.out.println(sentance);
        }

    }

    public static int countSpaces(String phrase) {
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ') {
                count++;
            }
        }
        return count+1;
    }

    public static int countWords(String phrase) {
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '/') {
                count++;
            }
        }
        return count+1;
    }

    public static Character decodeCharacter(String Code, BinarySearchTree<Character> tree) {
        BinarySearchTreeNode<Character> current = tree.getRoot();
        for (int i = 0; i < Code.length(); i++) {
            if (Code.charAt(i) == '0') {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return current.getInfo();
    }

    public static String decodeWord(String word, BinarySearchTree<Character> tree) {
        String decodedWord = "";
        String code = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '/') {
                decodedWord += decodeCharacter(code, tree);
                code = "";
            } else {
                code += word.charAt(i);
            }
        }
        return decodedWord;
    }

    public static void seperateWords(String phrase, String[] words) {
        int count = 0;
        String word = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '/') {
                words[count] = word;
                count++;
                word = "";
            } else {
                word += phrase.charAt(i);
            }
        }
        words[count] = word;
    }

    public static void seperateLetters(String phrase, String[] letters) {
        int count = 0;
        String letter = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ') {
                letters[count] = letter;
                count++;
                letter = "";
            } else {
                letter += phrase.charAt(i);
            }
        }
        letters[count] = letter;
    }

    public static String decodeSentence(String phrase, BinarySearchTree<Character> tree) {
        String decodedSentence = "";
        String[] words = new String[countWords(phrase)];
        seperateWords(phrase, words);
        for (int i = 0; i < words.length; i++) {
            decodedSentence += decodeWord(words[i], tree);
            decodedSentence += " ";
        }
        return decodedSentence;
    }
}

