import java.io.*;
import java.util.*;

class Result {

    public static String timeConversion(String s) {
        String period = s.substring(8);
        int hours = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, 8);
        
        if (period.equals("AM")) {
            if (hours == 12) {
                hours = 0;
            }
        } else {
            if (hours != 12) {
                hours += 12;
            }
        }
        
        return String.format("%02d%s", hours, rest);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
