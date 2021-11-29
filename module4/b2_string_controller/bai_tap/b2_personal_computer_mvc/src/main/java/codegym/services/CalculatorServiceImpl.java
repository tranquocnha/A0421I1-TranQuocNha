package codegym.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public float calculator(float firstNum, float lastNum, String calculation) {
        float result;
        switch (calculation){
            case "add":
                result = firstNum + lastNum;
                break;
            case "sub":
                result = firstNum - lastNum;
                break;
            case "mul":
                result = firstNum * lastNum;
                break;
            case "div":
                result = firstNum / lastNum;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculation);
        }
        return result;
    }
}
