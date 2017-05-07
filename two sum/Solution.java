import java.util.HashMap;
import java.util.Iterator;

public class Solution {
   public int[] twoSum(int[] nums, int target) {
       int[] result = new int[2];
       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
       for(int i =0;i<nums.length;i++){
		   if(map.containsKey(nums[i])){
			   int index = map.get(nums[i]);
			   result[0] = index;
			   result[1] = i;
			   break;
		   }else{
			   map.put(target - nums[i], i);
		   }
	   }  

       System.out.println(result[0]);
       System.out.println(result[1]);
       return result;
   }
   public static void main(String[] args){
       int[] nums = {0,4,4,0};
       int target = 0;
       Solution s = new Solution();
       s.twoSum(nums,target);
   }
}
