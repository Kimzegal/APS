import java.util.*;

class Solution {
    public String solution(String s) {
        // 공백을 기준으로 스플릿
        char[] c = s.toLowerCase().toCharArray();
        
        boolean first = true;
        for(int i = 0; i < c.length; i++){
            if(c[i] == ' ') {
                first = true;
                continue;
            }
            if(first){
                if(c[i] >= 65) c[i] -= 32;
                first = false;
                continue;
            }
            
        }
        // 맨끝 공백 없앤다
        return new String(c);
    }
}