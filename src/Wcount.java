import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Wcount {

    public static void main(String[] args) {
        //commit
        String fileName = "D:\\steadfast.txt";
        Map<String, Integer> wordCounts = countWords(fileName);

        System.out.println("Word counts:");
        for (Map.Entry<String, Integer> entry : new TreeMap<>(wordCounts).entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Integer> countWords(String fileName) {
        Map<String, Integer> wordCounts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into words, removing punctuation and converting to lowercase
                for (String word : line.split("[\\p{Punct}\\s]+")) {
                    word = word.toLowerCase();
                    if (!word.isEmpty()) {
                        // Update count for the word
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return wordCounts;
    }
}
