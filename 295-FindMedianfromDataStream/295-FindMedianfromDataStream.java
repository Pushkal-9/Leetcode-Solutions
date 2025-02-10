class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>((a,b) -> b-a);
        max = new PriorityQueue<>();            
    }
    
    public void addNum(int num) {
        if(min.isEmpty()){
            min.add(num);
            return;
        }
        if(num>min.peek()){
            max.add(num);
            return;
        }

            min.add(num);
    }
    
    public double findMedian() {
        while(min.size()>max.size()){
            max.add(min.poll());
        }

        while(max.size()>min.size()){
            min.add(max.poll());
        }

        if(max.size()==min.size()){
            return (double)(max.peek()+min.peek())/2;
        }

        return min.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */