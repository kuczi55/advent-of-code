package adventofcode.sonarsweep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SonarSweep {
    public static List<Integer> fileToIntegerList(String filename) {
        List<Integer> numbers = new ArrayList<>();

        try {
            File input = new File(filename);
            Scanner scanner = new Scanner(input);

            while(scanner.hasNext()) {
                String number = scanner.nextLine();
                numbers.add(Integer.valueOf(number));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return numbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = fileToIntegerList("src/main/resources/input.txt");
        int counter = 0;
        if(numbers.size() > 3) {
            int prevSum = numbers.get(0) + numbers.get(1) + numbers.get(2);

            for(int i = 1; i < numbers.size() - 2; i++) {
                int sum = numbers.get(i) + numbers.get(i + 1) + numbers.get(i + 2);
                if(sum > prevSum) {
                    counter++;
                }
                prevSum = sum;
            }
        }

        System.out.println(counter);
    }
}
