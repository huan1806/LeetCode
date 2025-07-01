class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            ans += chars[i] == chars[i - 1] ? 1 : 0;
        }
        return ans;
    }
}