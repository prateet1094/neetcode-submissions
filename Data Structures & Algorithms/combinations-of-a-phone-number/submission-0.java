class Solution {
    public List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        dfs(digits,0,new StringBuilder());
        return res;
    }
    public void dfs(String digits, int idx, StringBuilder sb){
        if(idx==digits.length()){
            if(sb.length()>0)
                res.add(sb.toString());
            return;
        }
        char[] ch = getChars(digits.charAt(idx));
        for(char c: ch){
            sb.append(c);
            dfs(digits,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public char[] getChars(char n ){
        if(n=='2')return new char[]{'a','b','c'};
        else if(n=='3')return new char[]{'d','e','f'};
        else if(n=='4')return new char[]{'g','h','i'};
        else if(n=='5')return new char[]{'j','k','l'};
        else if(n=='6')return new char[]{'m','n','o'};
        else if(n=='7')return new char[]{'p','q','r','s'};
        else if(n=='8')return new char[]{'t','u','v'};
        else if(n=='9')return new char[]{'w','x','y','z'};

        return new char[]{};
    }
}
