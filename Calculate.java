import java.util.ArrayList;

public class Calculate {
    private static char[] standardOperators = { '%', '÷', 'x', '-', '+' };
    private ArrayList<Character> operators = new ArrayList<Character>();
    private ArrayList<Float> nums = new ArrayList<Float>();

    Calculate(String calculus) {
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
                nums.add(floatNum);
                num = "";
                operator = false;
            }
        }
        for (Float f : nums) {
            System.out.println(f);
        }
        for (char c : operators) {
            System.out.println(c);
        }
    }

    public Float calculateAll() {

        return Float.valueOf("2.2");
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