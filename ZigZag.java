public class ZigZag {
    public int longestZigZag (int[] sequence) {
        int len = sequence.length;
        if (len < 2)
            return len;
        int[][] maxZigZag = new int[len][len];
        
        maxZigZag[0][0] = 1;
        for (int row = 1; row < len; row ++)
            maxZigZag[row][0] = 2;
        
        for (int i = 2; i < len; i ++) {
            for (int j = 1; j < i; j ++) {
                for (int k = 0; k < j; k ++) {
                    if ((sequence[i] > sequence[j] && sequence[j] < sequence[k]) ||
                        (sequence[i] < sequence[j] && sequence[j] > sequence[k]))
                        maxZigZag[i][j] = Math.max(maxZigZag[i][j], 1 + maxZigZag[j][k]);
                }
            }
        }
        
        int result = 0;
        for (int col = 0; col < len; col ++)
            result = Mat.max(result, maxZigZag[len - 1][col]);
        return result;
    }
}