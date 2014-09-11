public class ZigZagSII {
    public int longestZigZag (int[] sequence) {
        int len = sequence.length;
        int[] maxZigZag = int[len];
        boolean[] negative = new boolean[len];
        for (int i = 0; i < len; i++) {
            maxZigZag[i] = 1;
            for (int j = 0; j < i; j++) {
                if(sequence[i] == sequence[j])
                    continue;
                if (maxZigZag[j] == 1) {
                    maxZigZag[i] = 1;
                    negative[i] = sequence[i] < sequence[j];
                } if (sequence[i] > sequence[j] && negative[j] ||
                    sequence[i] < sequence[j] && !negative[j]) {
                    if (maxZigZag[j] + 1 > maxZigZag[i]) {
                        negative[i] = !negative[j];
                        maxZigZag[i] = maxZigZag[j] + 1;
                    }
                }
            }
        }
        return maxZigZag[len - 1];
    }
}