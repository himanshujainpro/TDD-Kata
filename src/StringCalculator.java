public class StringCalculator {

    int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        else if (numbers.length() == 1) return Integer.parseInt(numbers);
        else return sum(parseStringArrayToIntArray(splitString(numbers)));
    }


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

    String[] splitString(String text) {
        return text.split(",");
    }

    // Takes an array and adds all element of array and returns sum.
    int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers
        ) {
            sum += number;
        }
        return sum;
    }
}
