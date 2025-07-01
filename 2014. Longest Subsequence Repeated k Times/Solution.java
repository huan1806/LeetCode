class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            freq[ch - 'a']++;
        }
        List<Character> available = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] >= k) {
                available.add((char) ('a' + i));
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        String ans = "";
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder(queue.poll());
            for (char ch : available) {
                sb.append(ch);
                String temp = sb.toString();
                if (isSastified(chars, k, sb)) {
                    ans = temp;
                    queue.offer(temp);
                }
                sb.deleteCharAt(temp.length() - 1);
            }
        }
        return ans;
    }

    private boolean isSastified(char[] s, int k, StringBuilder sb) {
        int c = 0;
        int i = 0;
        for (char ch : s) {
            if (sb.charAt(i) == ch) {
                if (++i == sb.length()) {
                    i = 0;
                    if (++c == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}