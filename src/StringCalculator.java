public class StringCalculator {

    int add(String numbers) {
        String delimiter;
        if (numbers.isEmpty()) return 0;
        else if (numbers.length() == 1) return Integer.parseInt(numbers);

        else {
            String[] splitArray;

            if(numbers.contains("\n")){
                delimiter="[,\n]";
                splitArray=splitString(numbers,delimiter);
            }else{
                splitArray = splitString(numbers);
            }

            int[] parsedIntegerArray = parseStringArrayToIntArray(splitArray);
            return sum(parsedIntegerArray);
        }
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

    //Takes string text and split it by , which is default for now
    String[] splitString(String text) {
        return text.split(",");
    }

    //Takes string text and split it by particular delimiter
    String[] splitString(String text,String delimiter){
        return text.split(delimiter);
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
