package adventofcode.binarydiagnostic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryDiagnostic {
    public static List<String> fileToIntegerList(String filename) throws IOException {

        return Files
                .lines(Paths.get(filename))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        try {
            List<String> numbers = fileToIntegerList("src/main/resources/input.txt");
            int[] numberOfOnes = new int[numbers.get(0).length()];
            int[] numberOfZeros = new int[numbers.get(0).length()];
            for(String number : numbers) {
                for(int i = 0; i < number.length(); i++) {
                    if(number.charAt(i) == '1') {
                        numberOfOnes[i]++;
                    }
                    else {
                        numberOfZeros[i]++;
                    }
                }
            }
            char[] gammaChars = new char[numbers.get(0).length()];
            char[] epsilonChars = new char[numbers.get(0).length()];

            for(int i = 0; i < numberOfOnes.length; i++) {
                if(numberOfOnes[i] > numberOfZeros[i]) {
                    gammaChars[i] = '1';
                    epsilonChars[i] = '0';
                }
                else {
                    gammaChars[i] = '0';
                    epsilonChars[i] = '1';
                }
            }

            int gamma = Integer.parseInt(String.valueOf(gammaChars), 2);
            int epsilon = Integer.parseInt(String.valueOf(epsilonChars), 2);

            System.out.println(gamma * epsilon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
