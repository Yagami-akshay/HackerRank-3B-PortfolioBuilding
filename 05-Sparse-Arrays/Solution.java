import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        Map<String, Integer> counts = new HashMap<>();
        for (String s : strings) {
            if (counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            } else {
                counts.put(s, 1);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (String q : queries) {
            if (counts.containsKey(q)) {
                result.add(counts.get(q));
            } else {
                result.add(0);
            }
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = bufferedReader.readLine();
            strings.add(stringsItem);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = new ArrayList<>();
        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = bufferedReader.readLine();
            queries.add(queriesItem);
        }

        List<Integer> result = Result.matchingStrings(strings, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
