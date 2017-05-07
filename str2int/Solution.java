import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Solution {
	public int myAtoi(String str) {
		int result = 0;
		String dest = "";
		Matcher a = Pattern.compile("^\\s*?((\\d+)|(-\\d+)|(\\+\\d+))").matcher(str);
		if(a.find()){
			System.out.println(a.group(1));
			result = tools(a.group(1));
		}
		return result;
	}
	private int tools(String str){
		long result = 0;
		try{
			result=Long.parseLong(str);
		}catch(NumberFormatException e){
     		e.printStackTrace();
		}
		if(result > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		if(result < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		return (int)result;
	}
	public static void main(String[] args){
		String str = "2147483648";
		Solution s = new Solution();
		System.out.println(s.myAtoi(str));
		
	}

}
