import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SplitFile {

    public static void main(String[] args) {
        String inputFile = "input.txt";         // Path to the input file
        String outputFile1 = "output1.txt";     // Path to the first output file
        String outputFile2 = "output2.txt";     // Path to the second output file

        try {
            // Read the input file and store lines in a list
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }

            // Check if the input file has 1000 lines
            if (lines.size() != 10) {
                System.err.println("The input file does not contain exactly 1000 lines.");
                return;
            }

            // Split the list of lines into two halves
            List<String> firstHalf = lines.subList(0,10);
            List<String> secondHalf = lines.subList(10, 20);

            // Write the first half to the first output file
            try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(outputFile1))) {
                for (String line : firstHalf) {
                    writer1.write(line);
                    writer1.newLine();
                }
            }

            // Write the second half to the second output file
            try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(outputFile2))) {
                for (String line : secondHalf) {
                    writer2.write(line);
                    writer2.newLine();
                }
            }

            System.out.println("File has been split successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
