public class Solution {
	public boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		if(x<10){
			return true;
		}
		int tmp = x;
		int left = 1;
		int right = 10;
		while(10<=tmp){
			left = left*10;
			tmp = tmp/10;
		}
		System.out.printf("%d,%d\n",left,right);
		while(left>=right){
			if(x/left!=x%right){
				return false;
			}
			x %=left;
			x /=right;
			left /=100;
		}
		return true;
	}
	public static void main(String args[]){
		int num = -2147483648;
		Solution s = new Solution();
		System.out.println(s.isPalindrome(num));
	}

}
