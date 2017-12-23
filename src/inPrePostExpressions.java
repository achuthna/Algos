import java.util.Stack;

public class inPrePostExpressions {


    public static int evaluatePreFix(String s){
        char[] exp = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for(int i = exp.length - 1; i >= 0; i--){
            char c = exp[i];
            if(Character.isDigit(c)){
                stack.push(c - '0');
            } else {
                int res = 0;
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+' :
                        res = val2 + val1;
                        break;
                    case '-' :
                        res = val1 - val2;
                        break;
                    case '*' :
                        res = val2 * val1;
                        break;
                    case '/' :
                        res = val1 / val2;
                        break;
                }
                stack.push(res);
            }
        }


        return stack.pop();
    }

    public static int evaluatePostFix(String s){

        char[] exp = s.toCharArray();

        Stack<Integer> stack = new Stack<>();

        for (char c : exp){
            if(Character.isDigit(c)){
                stack.push(c - '0');
            } else {
                int res = 0;
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+' :
                        res = val2 + val1;
                    break;
                    case '-' :
                        res = val2 - val1;
                    break;
                    case '*' :
                        res = val2 * val1;
                    break;
                    case '/' :
                        res = val2 / val1;
                    break;
                }
                stack.push(res);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args){


        System.out.println(evaluatePostFix("231*+9-"));
        System.out.println(evaluatePreFix("*+14+31"));

    }
}
