class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minus = 1;
        int now = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                now *= minus;
                max = Math.max(max, now);
                min = Math.min(min, now);
                minus = 1;
                now = 0;
                continue;
            }
            else if(s.charAt(i) == '-'){
                minus = -1;
                continue;
            }
            int cur = s.charAt(i) - '0';
            now = now*10 + cur;
            

        }
                        now *= minus;
                max = Math.max(max, now);
                min = Math.min(min, now);
        
        return min + " " + max;
    }
}
