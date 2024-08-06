public class Solution_0806 {
    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'I' && (i + 1 < len) && s.charAt(i + 1) == 'V') {
                sum += 4;
                i++;
                continue;
            } else if (s.charAt(i) == 'I' && (i + 1 < len) && s.charAt(i + 1) == 'X') {
                sum += 9;
                i++;
                continue;
            } else if (s.charAt(i) == 'X' && (i + 1 < len) && s.charAt(i + 1) == 'L') {
                sum += 40;
                i++;
                continue;
            } else if (s.charAt(i) == 'X' && (i + 1 < len) && s.charAt(i + 1) == 'C') {
                sum += 90;
                i++;
                continue;
            } else if (s.charAt(i) == 'C' && (i + 1 < len) && s.charAt(i + 1) == 'D') {
                sum += 400;
                i++;
                continue;
            } else if (s.charAt(i) == 'C' && (i + 1 < len) && s.charAt(i + 1) == 'M') {
                sum += 900;
                i++;
                continue;
            }
            switch (s.charAt(i)) {
                case 'I':
                    sum += 1;
                    continue;
                case 'V':
                    sum += 5;
                    continue;
                case 'X':
                    sum += 10;
                    continue;
                case 'L':
                    sum += 50;
                    continue;
                case 'C':
                    sum += 100;
                    continue;
                case 'D':
                    sum += 500;
                    continue;
                case 'M':
                    sum += 1000;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_0806 solution = new Solution_0806();
        String s = "LVIII";
        int result = solution.romanToInt(s);
        System.out.println(result);
    }
}
