package adventofcode.sonarsweep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SonarSweep {
    public static List<Integer> fileToIntegerList(String filename) throws IOException {

            return Files
                    .lines(Paths.get(filename))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int counter = 0;

        try {
            List<Integer> numbers = fileToIntegerList("src/main/resources/input.txt");
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }
}
