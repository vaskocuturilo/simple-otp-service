package site.testengineer.otp.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class OTPService {

    public ResponseEntity<Object> getOneParameterMap() {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("code", "1234"));
    }
}
