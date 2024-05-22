import java.util.ArrayList;

public class Operations {
    private String calculus;
    private static char[] standardOperators = { '%', '÷', 'x', '-', '+' };
    private ArrayList<Character> operators = new ArrayList<Character>();
    private ArrayList<Float> nums = new ArrayList<Float>();

    Operations(String calculus) {
        this.calculus = calculus;
    }

    public Float Calculate() {
        String num = "";
        for (int i = 0; i < calculus.length(); i++) {
            boolean operator = false;
            if (isOperator(calculus.charAt(i))) {
                operators.add(Character.valueOf(calculus.charAt(i)));
                operator = true;
            }

            if (!operator) {
                num += calculus.charAt(i);
            }
            if (operator || i == (calculus.length() - 1)) {
                Float floatNum = Float.parseFloat(num);
                System.out.println(floatNum.floatValue());
                nums.add(floatNum);
                num = "";
                operator = false;
            }
        }

        return Calculate.calculateExpression(nums, operators);
    }

    public static boolean isOperator(char c) {
        for (char operator : standardOperators) {
            if (c == operator) {
                return true;
            }
        }
        return false;
    }
}