class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int bitCount = 0;
        int currentValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count++;
                bitCount++;
            } else {
                if (bitCount > 30) continue;
                int newValue = currentValue + (1 << bitCount);
                if (newValue <= k) {
                    bitCount++;
                    currentValue = newValue;
                }
            }
        }
        return count;
    }
}