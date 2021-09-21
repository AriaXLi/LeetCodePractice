//Link: https://leetcode.com/problems/happy-number/solution/
// testing commits on git are working now

class HappyNumber {
    
    public int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int m = n % 10;
            n /= 10;
            total += m * m;
        }
        return total;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> checkHappy = new HashSet<>();
        while (n != 1 && !checkHappy.contains(n)) {
            checkHappy.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}