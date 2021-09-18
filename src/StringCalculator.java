import java.util.ArrayList;
import java.util.List;

public class StringCalculator {


    int add(String numbers) {

        // Case:1 if String is empty or null or blank
        if (numbers == null || numbers.trim().isEmpty()) {
            return 0;
        }

        //Case:2 if string contains just number only
        if (!numbers.contains(",") && !numbers.contains("//")) {
            return toInt(numbers);
        }

        //Case:3 Getting integer array from unprocessed text
        int[] parsedIntegerArray = parseStringArrayToIntArray(parseString(numbers));

        // Checking negatives
        checkNegativeAndThrowsException(parsedIntegerArray);

        // sum of values
        return sum(parsedIntegerArray);

    }

    // It parses unprocessed string text to usable string text like "//[***]\n1***2***3" will return ["1","2","3"]
    String[] parseString(String numbers) {
        String delimiter = "";
        String[] splitArray;
        String textToSplit = numbers;


        //Case 1: Supporting new line.
        if (numbers.contains("\n") && !numbers.startsWith("//") && !numbers.contains("[")) {
            delimiter = "[,\n]";
        } else if (numbers.startsWith("//")) {
            String textContainingDelimiters = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"));

            if (!numbers.contains("[")) {
                delimiter = textContainingDelimiters;

            } else {
                String[] delimiters = getDelimiters(textContainingDelimiters);
                delimiter = processDelimiters(delimiters);

            }

            textToSplit = numbers.substring(numbers.indexOf("\n") + 1);

        }

        //Case 4: Contains default delimiter ","
        else {
            delimiter = ",";
        }

        splitArray = splitStringByDelimiter(textToSplit, delimiter);
        return splitArray;
    }

    // It gives array of delimiters for example: - "[*][%]" returns {"*","%"}
    String[] getDelimiters(String text) {
        String newText = text.replaceAll("\\[", "1").replaceAll("]", "2");
        String[] stringArrayContainsBadElement = newText.split("[1|2]");

        String[] delimiters = new String[stringArrayContainsBadElement.length / 2];

        for (int i = 0; i < delimiters.length; i++) {
            delimiters[i] = stringArrayContainsBadElement[i + i + 1];
        }
        return delimiters;
    }

    // It processes array of delimiters for example:-  {"*","%"} returns "[*%]+"
    String processDelimiters(String[] delimiters) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (String s : delimiters
        ) {
            stringBuilder.append(s.charAt(0));
        }
        stringBuilder.append("]+");
        return stringBuilder.toString();
    }


    void checkNegativeAndThrowsException(int[] numbers) {
        List<Integer> listOfNegativeNumbers = new ArrayList<>();
        for (int number : numbers
        ) {
            if (number < 0) listOfNegativeNumbers.add(number);
        }
        if (listOfNegativeNumbers.size() > 0)
            throw new RuntimeException("Negatives are not allowed: " + listOfNegativeNumbers);
    }

    //Converts string array to integer array
    int[] parseStringArrayToIntArray(String[] strings) {

        int[] numbers = new int[strings.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toInt(strings[i]);
        }
        return numbers;
    }


    int toInt(String number) {
        return Integer.parseInt(number);
    }


    //Takes string text and split it by particular delimiter
    String[] splitStringByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }

    // Takes an array and adds all element of array and returns sum.
    int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers
        ) {
            if (number > 1000) continue;
            sum += number;
        }
        return sum;
    }

}
