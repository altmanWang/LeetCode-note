/**
 * Created by altman on 17-5-7.
 */
public class Solution {
    public String reverseStr(String s, int k) {
        int N = s.length();
        char[] arr = s.toCharArray();

        for(int i = 0; i <= N / (k*2); i++){
            reverse(arr, i*k*2, Math.min(i*k*2+k,N));
        }
        return new String(arr);
    }
    public void reverse(char[] target,int start, int end){
        int mid = (start+end)/2-start;
        char tmp;
        //System.out.println(start+" "+mid+" "+end);
        for(int i = 0; i < mid; i ++){
            tmp = target[start + i];
            target[start + i] = target[end - i -1];
            target[end - i -1] = tmp;
        }

    }
    public static void main(String[] args){
        String data = "abcdefg";
        System.out.println(new Solution().reverseStr(data,12));
    }
}
