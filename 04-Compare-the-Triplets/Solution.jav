import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScore = 0;
        int bobScore = 0;
        
        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;
            } else if (a.get(i) < b.get(i)) {
                bobScore++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(aliceScore);
        result.add(bobScore);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> a = new ArrayList<>();
        for (String item : aItems) {
            a.add(Integer.parseInt(item));
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> b = new ArrayList<>();
        for (String item : bItems) {
            b.add(Integer.parseInt(item));
        }

        List<Integer> result = Result.compareTriplets(a, b);

        bufferedWriter.write(result.get(0) + " " + result.get(1));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
