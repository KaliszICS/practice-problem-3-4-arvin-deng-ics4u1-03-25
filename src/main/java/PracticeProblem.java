import java.util.ArrayList;
import java.util.HashSet;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int[] recaman(int n) {
        if (n <= 0) return new int[0];

        ArrayList<Integer> fullSequence = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        fullSequence.add(0); 
        seen.add(0);

        generateRecaman(n + 1, 1, fullSequence, seen);  

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = fullSequence.get(i + 1);
        }

        return result;
    }

    private static void generateRecaman(int total, int index, ArrayList<Integer> sequence, HashSet<Integer> seen) {
        if (sequence.size() >= total) return;

        int last = sequence.get(sequence.size() - 1);
        int candidate = last - index;

        if (candidate > 0 && !seen.contains(candidate)) {
            sequence.add(candidate);
            seen.add(candidate);
        } else {
            candidate = last + index;
            sequence.add(candidate);
            seen.add(candidate);
        }

        generateRecaman(total, index + 1, sequence, seen);
    }

}
