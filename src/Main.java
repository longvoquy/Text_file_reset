
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            Manager manager = new Manager(); // Create an instance of Manager
            int countLine = manager.countLine();
            int count = 1;
            br = new BufferedReader(new FileReader(new File("input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)));
            String line;
            // Write until the end of the file
            while ((line = br.readLine()) != null) {
                // Check line empty
                if (manager.isLineEmpty(line)) {
                    continue;
                }
                line = manager.formatOneSpace(line);
                line = manager.formatSpecialCharacters(line);
                line = manager.afterDotUpperCase(line);
                line = manager.noSpaceQuotes(line);
                line = manager.firstUppercase(line);
                line = manager.lastAddDot(line);
                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot find the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
