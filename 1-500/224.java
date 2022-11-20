import java.util.Stack;

public class Basic_Calculator {

    class Solution {
        public int calculate(String s) {
            int res = 0;
            int num = 0;
            int sign = 1;
            int n = s.length();

            Stack<Integer> sk = new Stack<>();

            for (int i = 0; i < n; ++i) {
                char c = s.charAt(i);
                if (c >= '0') {
                    num = 10 * num + (c - '0');
                } else if (c == '+' || c == '-') {
                    res += sign * num; // possible overflow, eg. -1 * Integer.MIN_VALUE
                    num = 0;
                    sign = (c == '+') ? 1 : -1;
                } else if (c == '(') {
                    sk.push(res); // not c-'0'
                    sk.push(sign);
                    res = 0;
                    sign = 1;
                    num = 0; // this line can be removed, here for clarity, since it's set to 0 when hitting operator +/-
                } else if (c == ')') {
                    res += sign * num;
                    num = 0;
                    res *= sk.peek(); sk.pop(); // sign @note: can be replaced by just `-1*val`
                    res += sk.peek(); sk.pop(); // then previous result
                }
            }
            res += sign * num; // @note: final check, if no ')' to trigger stack pop stuff
            return res;
        }

    }
}
