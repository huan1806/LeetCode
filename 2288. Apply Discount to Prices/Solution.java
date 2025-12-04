class Solution {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        int mul = 100 - discount;
        for (String word : words) {
            if (word.length() > 1 && word.charAt(0) == '$') {
                char[] chars = word.toCharArray();
                long num = 0;
                boolean isValidPrice = true;
                for (int i = 1; i < chars.length; i++) {
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        num = 10 * num + chars[i] - '0';
                    } else {
                        isValidPrice = false;
                        break;
                    }
                }
                if (isValidPrice) {
                    long cents = num * mul;
                    long integer = cents / 100;
                    long frac = cents % 100;
                    sb.append('$').append(integer).append('.');
                    if (frac < 10) sb.append('0');
                    sb.append(frac).append(' ');
                } else {
                    sb.append(word).append(' ');
                }
            } else {
                sb.append(word).append(' ');
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}