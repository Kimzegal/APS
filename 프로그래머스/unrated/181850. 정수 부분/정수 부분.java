class Solution {
    public int solution(double flo) {
        String s = String.valueOf(flo);
        String[] a = s.split("\\.");
        return Integer.parseInt(a[0]);
    }
}