
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 6;
        LinearProbingHash<String> hash = null;

        do {
            System.out.println("1. Load the dictionary given text file name.");
            System.out.println("2. Search a word.");
            System.out.println("3. Insert a word");
            System.out.println("4. Delete a word");
            System.out.println("5. Check Spell");
            System.out.println("6. Exit");

            System.out.println("Enter your option: ");
            option = input.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter the file name: ");
                    String fileName = input.next();
                    hash = readFile(fileName);
                    break;
                case 2:
                    System.out.println("Enter the word: ");
                    String word = input.next();
                    if (hash == null){
                        System.out.println("The dictionary is empty.");
                        break;
                    }

                    try{
                        hash.get(word);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }

                    int wordIndex = hash.hash(word);
                    System.out.println("The word is found and " + word + " is at index " + wordIndex + " in the hash table.");
                    break;
                case 3:
                    System.out.println("Enter the word: ");
                    String newWord = input.next();

                    try{
                        hash.insert(newWord);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }


                    System.out.println("The word is inserted.");
                    break;
                case 4:
                    System.out.println("Enter the word: ");
                    String deleteWord = input.next();

                    try{
                        hash.delete(deleteWord);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("The word is deleted.");
                    break;
                case 5:
                    System.out.println("Enter the file name: ");
                    String checkFileName = input.next();
                    LinearProbingHash<String> checkBy = readFile(checkFileName);

                    try{
                        hash.checkSpell(checkBy);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }

                    break;
            }
        }while(option != 6);

        input.close();

        System.out.println("Goodbye!");
    }

    public static LinearProbingHash<String> readFile(String fileName) {
        File file = new File(fileName);
        try {
            Scanner fileScn = new Scanner(file);
            int count = 0;

            while (fileScn.hasNextLine()) {
                String line = fileScn.nextLine();
                System.out.println(line);
                count++;
            }

            fileScn.close();

            fileScn = new Scanner(file);

            LinearProbingHash<String> hash = new LinearProbingHash<>(count * 2);

            while (fileScn.hasNextLine()) {
                hash.insert(fileScn.nextLine());
            }

            fileScn.close();
            System.out.println("\nThe dictionary is loaded.\n");
            return hash;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}