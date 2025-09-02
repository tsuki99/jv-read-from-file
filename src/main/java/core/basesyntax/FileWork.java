package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIC_CHARACTER = "w";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder filteredWords = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();

            while (value != null) {
                String[] splittedWords = value.split("\\W+");

                for (String currentWord : splittedWords) {
                    if (startsWithLetterW(currentWord)) {
                        filteredWords.append(currentWord.toLowerCase()).append(SPACE);
                    }
                }
                value = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String[] filteredArray = filteredWords.toString().split("\\W+");
        Arrays.sort(filteredArray);

        System.out.println(Arrays.toString(filteredArray));
        return filteredWords.isEmpty() ? new String[]{} : filteredArray;
    }

    private boolean startsWithLetterW(String word) {
        return word.toLowerCase().startsWith(SPECIFIC_CHARACTER);
    }
}
