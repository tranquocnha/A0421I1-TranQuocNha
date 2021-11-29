package codegym.services;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    public float calculator(float firstNum, float lastNum, String calculation);
}
