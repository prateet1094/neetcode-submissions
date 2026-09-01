class MedianFinder {
    PriorityQueue<Integer> leftHalf;
    PriorityQueue<Integer> rightHalf;

    public MedianFinder() {
        leftHalf = new PriorityQueue<>((a,b)->(b-a));
        rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
         leftHalf.add(num);
        if(leftHalf.size()>0 && rightHalf.size()>0 && leftHalf.peek()>rightHalf.peek()){
            rightHalf.add(leftHalf.remove());
        }
        if(leftHalf.size()-rightHalf.size()>1){
            rightHalf.add(leftHalf.remove());
        }
        if(rightHalf.size()-leftHalf.size()>1){
            leftHalf.add(rightHalf.remove());
        }
    }
    
    public double findMedian() {
        if(leftHalf.size()==rightHalf.size()){
            return (leftHalf.peek()+rightHalf.peek())/2.0;
        } else if(leftHalf.size()>rightHalf.size()) {

            return leftHalf.peek();
        } else {
            return rightHalf.peek();
        }
    }
}
