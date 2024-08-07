public class Solution_0807 {
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int len = values.length;
        while (num > 0) {
            for (int i = 0; i < len; i++) {
                int bits = num / values[i];
                for (int j = 1; j <= bits; j++) {
                    result.append(symbols[i]);
                }
                num = (num % values[i]);
            }
        }
        return result.toString();
    }

}
