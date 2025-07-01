class Solution {
    public String maximumBinaryString(String binary) {
        StringBuilder sb = new StringBuilder();
        int c0 = 0;
        int c1 = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                if (c0 == 0) {
                    c0 = 1;
                } else {
                    sb.append('1');
                }
            } else {
                if (c0 == 0) {
                    sb.append('1');
                } else {
                    c1++;
                }
            }
        }
        if (c0 != 0) {
            sb.append('0');
            for (int i = 0; i < c1; i++) {
                sb.append('1');
            }
        }
        return sb.toString();
    }
}