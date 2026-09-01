class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(isClosing(c)){
                if(stack.isEmpty())return false;
                char last = stack.pop();
                if(last!=opening(c))return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    public char opening(char c){
        if(c==')')return '(';
        else if(c==']') return '[';
        return '{';
                
    }
    public boolean isOpening(char c){
        if(c=='(' || c=='[' || c=='{')return true;
        return false;
    }
    public boolean isClosing(char c){
        if(c==')' || c==']' || c=='}')return true;
        return false;
    }
}
