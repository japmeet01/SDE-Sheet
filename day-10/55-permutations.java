// // Space-n!*n soln
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res=new ArrayList();
//         List<Integer> curr=new ArrayList();
//         HashMap<Integer,Boolean> map=new HashMap();
//         for(int i=0;i<nums.length;i++){
//             map.put(i,false);
//         }
//         permutations(nums,map,res,curr);
//         return res;
//     }
//     public void permutations(int[] nums,HashMap<Integer,Boolean> map,List<List<Integer>> res,List<Integer> curr){
//         if(curr.size()>=nums.length){
//             res.add(new ArrayList(curr));
//             return;
//         }
//         for(int i=0;i<nums.length;i++){
//             if(map.get(i)==false){
//                 map.put(i,true);
//                 curr.add(nums[i]);
//                 permutations(nums, map,res,curr);
//                 curr.remove(curr.size()-1);
//                 map.put(i,false);
//             }
//         }
//     }
// }


// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res=new ArrayList();
//         permutations(0,nums,res);
//         return res;
//     }
//     public void permutations(int index,int[] nums,List<List<Integer>> res){
//         if(index>=nums.length){
//             List<Integer> curr=new ArrayList();
//             for(int i=0;i<nums.length;i++){
//                 curr.add(nums[i]);
//             }
//             res.add(new ArrayList(curr));
//             return;
//         }
//         for(int i=index;i<nums.length;i++){
//             swap(i,index,nums);
//             permutations(index+1,nums,res);
//             swap(i,index,nums);
//         }
//     }
//     private void swap(int ind1,int ind2,int[] nums){
//         int t=nums[ind1];
//         nums[ind1]=nums[ind2];
//         nums[ind2]=t;
//     }
// }

//string permutations -coding ninjas
import java.util.* ;
public class Solution {
    public static List<String> findPermutations(String nums) {
        List<String> res=new ArrayList();
        permutations(0,nums,res);
        return res;
    }
    public static void permutations(int index,String nums,List<String> res){
        if(index>=nums.length()){
            res.add(nums);
            return;
        }
        for(int i=index;i<nums.length();i++){
            nums=swap(i,index,nums);
            permutations(index+1,nums,res);
            nums=swap(i,index,nums);
        }
    }
    private static String swap(int i,int j,String str){
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}

