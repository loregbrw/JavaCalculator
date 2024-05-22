import java.util.ArrayList;

public class Calculate {

    public static Float calculateExpression(ArrayList<Float> nums, ArrayList<Character> operators) {
        
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '%') {
                nums.set(i, Percentage(nums.get(i)));
                operators.remove(i);
                i--;
                break;
            }
        }
        
        Float result = nums.get(0);
        
        for (int i = 0; i < operators.size(); i++) {
            switch (operators.get(i)) {
                case '÷':
                    result = Div(result, nums.get(i + 1));
                    break;

                case 'x':
                    result = Mul(result, nums.get(i + 1));
                    break;

                case '-':
                    result = Sub(result, nums.get(i + 1));
                    break;

                case '+':
                    result = Sum(result, nums.get(i + 1));
                    break;
            }
        }

        return result;
    }

    private static Float Sum(Float num1, Float num2) {
        return num1 + num2;
    }

    private static Float Sub(Float num1, Float num2) {
        return num1 - num2;
    }

    private static Float Mul(Float num1, Float num2) {
        return num1 * num2;
    }

    private static Float Div(Float num1, Float num2) {
        return num1 / num2;
    }

    private static Float Percentage(Float num) {
        return num / 100;
    }
}
