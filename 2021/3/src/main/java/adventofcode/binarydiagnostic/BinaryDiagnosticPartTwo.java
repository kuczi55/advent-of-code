package adventofcode.binarydiagnostic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryDiagnosticPartTwo {
    public static List<String> fileToIntegerList(String filename) throws IOException {

        return Files
                .lines(Paths.get(filename))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        try {
            List<String> numbers = fileToIntegerList("src/main/resources/input.txt");
            int size = numbers.get(0).length();

            List<String> oxygenList = new ArrayList<>(numbers);
            List<String> co2List = new ArrayList<>(numbers);

            for(int i = 0; i < size; i++) {
                int finalI = i;
                int numberOfOxygenOnes = 0;
                int numberOfOxygenZeros = 0;

                for(String oxyNum : oxygenList) {
                    if(oxyNum.charAt(i) == '1') {
                        numberOfOxygenOnes++;
                    }
                    else {
                        numberOfOxygenZeros++;
                    }
                }

                if(numberOfOxygenOnes > numberOfOxygenZeros) {
                    oxygenList = oxygenList.stream().filter(number -> number.charAt(finalI) == '1').collect(Collectors.toList());
                }
                else if (numberOfOxygenOnes < numberOfOxygenZeros) {
                    oxygenList = oxygenList.stream().filter(number -> number.charAt(finalI) == '0').collect(Collectors.toList());
                }

                int numberOfCo2Ones = 0;
                int numberOfCo2Zeros = 0;

                for(String co2Num : co2List) {
                    if(co2Num.charAt(i) == '1') {
                        numberOfCo2Ones++;
                    }
                    else {
                        numberOfCo2Zeros++;
                    }
                }

                if(numberOfCo2Ones > numberOfCo2Zeros && numberOfCo2Ones > 0 && numberOfCo2Zeros > 0) {
                    co2List = co2List.stream().filter(number -> number.charAt(finalI) == '0').collect(Collectors.toList());
                }
                else if (numberOfCo2Ones < numberOfCo2Zeros && numberOfCo2Ones > 0) {
                    co2List = co2List.stream().filter(number -> number.charAt(finalI) == '1').collect(Collectors.toList());
                }
            }

            int oxygen;
            int co2;

            if(oxygenList.size() > 1) {
                oxygen = Integer.parseInt(oxygenList.stream().filter(number -> number.charAt(number.length() - 1) == '1').collect(Collectors.toList()).get(0), 2);
            }
            else {
                oxygen = Integer.parseInt(oxygenList.get(0), 2);
            }

            if(co2List.size() > 1) {
                co2 = Integer.parseInt(co2List.stream().filter(number -> number.charAt(number.length() - 1) == '0').collect(Collectors.toList()).get(0), 2);
            }
            else {
                co2 = Integer.parseInt(co2List.get(0), 2);
            }

            System.out.println(oxygen * co2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
