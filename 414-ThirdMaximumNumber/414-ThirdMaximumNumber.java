// Last updated: 13/04/2025, 15:57:34
class Solution {
    public int thirdMax(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Iterator<Integer> it = set.iterator();

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        if(set.size()==1){
            return it.next();
        }
        else if(set.size()==2){
            it = set.iterator();
            return Math.max(it.next(),it.next());
        }

        for(int i : set){
            if(i>first){
                third = second;
                second = first;
                first=i;
            }
            else if(i>second){
                third=second;
                second=i;
            }
            else if(i>third){
                third=i;
            }
        }

        return third;
    }
}