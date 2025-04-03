class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack();
        int n=path.length(),ptr=0;
        StringBuilder res=new StringBuilder();
        while(ptr<n){
            StringBuilder temp=new StringBuilder();
            while(ptr<n && path.charAt(ptr)=='/') ptr++;

            while(ptr<n && path.charAt(ptr)!='/'){
                temp.append(path.charAt(ptr));
                ptr++;
            }

            String s=temp.toString();

            if(!s.isEmpty()){
                if(s.equals(".")){
                    continue;
                }else if(s.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else{
                    stack.push(s);
                }
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
            res.insert(0,'/');
        }
        return res.toString();
    }
}