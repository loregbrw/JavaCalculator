import java.util.ArrayList;

public class Calculate {
    private char[] standardOperators = {'%', '÷', 'x', '-', '+'};
    private ArrayList<Character> operators = new ArrayList<Character>();
    private ArrayList<Float> nums = new ArrayList<Float>();

    Calculate(String calculus) {
        String num ="";
        for (int i = 0; i < calculus.length(); i++) {
            boolean operator = false;
            for (char c : standardOperators) {
                if (calculus.charAt(i) == c) {
                    operators.add(Character.valueOf(calculus.charAt(i)));
                    operator = true;
                    break;
                }
            }

            if (operator || i == calculus.length() - 1) {
                Float floatNum = Float.parseFloat(num);
                nums.add(floatNum);
                num = "";
                operator = false;
            } else if (!operator) {
                num += calculus.charAt(i);
            }
        }
        for (Float f : nums) {
            System.out.println(f);
        }
    }

    public Float calculateAll() {
        
        
        return Float.valueOf("2.2");
    }
}