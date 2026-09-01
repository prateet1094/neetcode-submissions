class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        Set<String> operators = Set.of("+", "-", "*", "/");
        int result = 0;
        for(String token : tokens){
            if(operators.contains(token)){
                int b = stack.pop();
                int a = stack.pop();
                if(token.equals("+")){
                    result = a+b;
                } else if(token.equals("-")){
                    result = a-b;
                } else if(token.equals("*")){
                    result = a*b;
                } else {
                    result = a/b;
                }
                stack.push(result);

            }  else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
