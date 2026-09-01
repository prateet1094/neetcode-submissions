class MinStack {

    Stack<Integer> stack ;
    Stack<Integer> minimum;
    public MinStack() {
        stack = new Stack<Integer>();
        minimum = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minimum.isEmpty())minimum.push(val);
        else {
            int lastMin = minimum.peek();
            if(val<lastMin){
                minimum.push(val);
            } else {
                minimum.push(lastMin);  
            }
        }

    }
    
    public void pop() {
        minimum.pop();
        stack.pop();
    }
    
    public int top() {
         return stack.peek();
    }
    
    public int getMin() {
        return minimum.peek();
    }
}
