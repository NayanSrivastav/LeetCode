

import java.util.Stack;

public class BalanceParentheses {
    static class Bracket {
        char open;
        char close;

        public Bracket(char open, char close) {
            this.open = open;
            this.close = close;
        }
    }

    static Bracket[] brackets = {
            new Bracket('{', '}'),
            new Bracket('(', ')'),
            new Bracket('[', ']')
    };

    public static void main(String[] args) {
        System.out.println(isBalanced("({[{{{}}}])"));
    }

    public static boolean isOpenTerm(Character term) {
        for (Bracket bracket : brackets) {
            if (bracket.open == term) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMatches(Character openTerm, Character closeTerm) {
        for (Bracket bracket : brackets) {
            if (bracket.open == openTerm) {
                return bracket.close == closeTerm;
            }
        }
        return false;
    }

    public static boolean isBalanced( String expression) {
        if (expression.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (Character c : expression.toCharArray()) {
            if (isOpenTerm(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatches(stack.pop(), c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
