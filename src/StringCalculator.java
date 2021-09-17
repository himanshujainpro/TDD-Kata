import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        else if (numbers.length() == 1) return Integer.parseInt(numbers);
        else {
            //Getting integer array from unprocessed text
            int[] parsedIntegerArray = parseStringArrayToIntArray(parseString(numbers));

            // Checking negatives
            checkNegativeAndThrowsException(parsedIntegerArray);

            //Final
            return sum(parsedIntegerArray);
        }
    }

    String[] parseString(String numbers) {
        String delimiter;
        String[] splitArray;
        String textToSplit = numbers;


        //Case 1: Supporting new line.
        if (numbers.contains("\n") && !numbers.startsWith("//") && !numbers.contains("[")) {
            delimiter = "[,\n]";
            splitArray = splitStringByDelimiter(textToSplit, delimiter);
        }

        //Case 2: Contains default different delimiters like ";" , ":" etc.
        else if (numbers.startsWith("//") && !numbers.contains("[")) {
            delimiter = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"));
            textToSplit = numbers.substring(numbers.indexOf("\n") + 1);
            splitArray = splitStringByDelimiter(textToSplit, delimiter);
        }

        //Case 2: Contains default different delimiters like ";" , ":" etc. of multiple length
        else if (numbers.startsWith("//") && numbers.contains("[")) {
            delimiter = numbers.substring(numbers.indexOf("//") + 3, numbers.indexOf("\n") - 1);
            delimiter = escapeReservedOperatorsByBackSlashes(delimiter);
            textToSplit = numbers.substring(numbers.indexOf("\n") + 1);
            splitArray = splitStringByDelimiter(textToSplit, delimiter);
        }
        //Case 4: Contains default delimiter ","
        else {
            splitArray = splitStringByDelimiter(textToSplit, ",");
        }

        return splitArray;
    }

    String escapeReservedOperatorsByBackSlashes(String delimiter) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < delimiter.length(); i++) {
            stringBuilder.append("\\").append(delimiter.charAt(i));
        }
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
