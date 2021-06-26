package site.testengineer.otp.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class OTPService {

    public Map<String, String> sayHello() {
        Date date = new Date();
        HashMap<String, String> map = new HashMap<>();
        map.put("is_successful", "true");
        map.put("parameter_errors", "null");
        map.put("server_datetime", String.valueOf(date));
        map.put("code", "1234");
        return map;
    }
}
