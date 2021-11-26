package services;

import org.springframework.stereotype.Service;

@Service
public interface ConvertMonetService {
    Double getConvert(int usd);
}
