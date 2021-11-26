package services.impl;

import org.springframework.stereotype.Service;
import services.ConvertMonetService;

@Service
public class ConvertMonetServiceImpl implements ConvertMonetService {
    @Override
    public Double getConvert(int usd) {
        double usdConvert = usd;
        double vnd = usdConvert * 23000;
        return vnd;
    }
}
