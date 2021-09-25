//Link: https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/171/
//Difficulty: Easy
//Time complexity: O(n)
//Space complexity: O(n)

class StringToInteger {
    public int myAtoi(String s) {
        int i = 0;
        String ret = "";
        boolean isNegative = false;
        while (i < s.length() && !Character.isLetter(s.charAt(i))) {
            if (s.charAt(i) == '-') {
                isNegative = true;
            }
            if (Character.isDigit(s.charAt(i))) {
                ret += s.charAt(i);
            }
            i++;
        }
        if (ret.isEmpty()) {
            return 0;
        }
        if (isNegative) {
            int retNum = Integer.valueOf(ret);
            retNum *= -1;
            return retNum;
        }
        else {
            return Integer.valueOf(ret);   
        }
    }
}