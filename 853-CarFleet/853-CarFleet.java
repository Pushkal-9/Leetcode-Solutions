class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<>();

        for(int i=0;i<speed.length;i++){
            Pair p = new Pair(speed[i],position[i]);
            list.add(p);
        }

        Collections.sort(list, (a,b) -> (a.pos-b.pos));

        for(Pair p : list){
            p.time = (double)(target-p.pos)/ p.speed;
        }

        Stack<Double> stack = new Stack<>();

        for(Pair p : list){
            if(stack.isEmpty()){
                stack.push(p.time);
            }
            else{
                while(!stack.isEmpty() &&stack.peek()<=p.time){
                    stack.pop();
                }
                stack.push(p.time);
            }
        }

        return stack.size();


    }

    public class Pair{
        public int speed;
        public int pos;
        public Double time;
        public Pair(int speed, int pos){
            this.speed = speed;
            this.pos = pos;
            this.time = null;
        }
    }
}