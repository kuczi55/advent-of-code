package adventofcode.dive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dive {

    public static void main(String[] args) {
        try {
            int horizontal = 0;
            int depth = 0;

            File input = new File("src/main/resources/input.txt");
            Scanner scanner = new Scanner(input);

            while(scanner.hasNext()) {
                String[] line = scanner.nextLine().split(" ");
                if(line.length > 1) {
                    switch (line[0]) {
                        case "forward" -> horizontal += Integer.parseInt(line[1]);
                        case "down" -> depth += Integer.parseInt(line[1]);
                        case "up" -> depth -= Integer.parseInt(line[1]);
                        default -> {}
                    }
                }
            }

            System.out.println(horizontal * depth);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
