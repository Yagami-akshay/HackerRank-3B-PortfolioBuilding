import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<Integer>());
        }
        
        int lastAnswer = 0;
        List<Integer> result = new ArrayList<>();
        
        for (List<Integer> q : queries) {
            int queryType = q.get(0);
            int x = q.get(1);
            int y = q.get(2);
            
            int idx = (x ^ lastAnswer) % n;
            
            if (queryType == 1) {
                seqList.get(idx).add(y);
            } else if (queryType == 2) {
                int valIdx = y % seqList.get(idx).size();
                lastAnswer = seqList.get(idx).get(valIdx);
                result.add(lastAnswer);
            }
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queryItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> queryRow = new ArrayList<>();
            for (String item : queryItems) {
                queryRow.add(Integer.parseInt(item));
            }
            queries.add(queryRow);
        }

        List<Integer> result = Result.dynamicArray(n, queries);

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
