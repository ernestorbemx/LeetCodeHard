class Solution {

    boolean isPali(String s, int l, int r) {
            while (l <= r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }

    public String shortestPalindrome(String s) {
                 
        // Bucle que recorre la cadena desde el final
        for (int r = s.length() - 1; r >= 0; r--) {
            if (isPali(s, 0, r)) {
                return new StringBuilder(s.substring(r + 1)).reverse().toString() + s;
            }
        }
        return "";


    }
}
