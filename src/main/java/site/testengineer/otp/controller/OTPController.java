package site.testengineer.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.testengineer.otp.service.OTPService;

@RestController
@RequestMapping("/api/otp")
public class OTPController {

    @Autowired
    private OTPService otpService;

    @GetMapping
    public ResponseEntity getOneTimePassword() {
        try {
            return ResponseEntity.ok(otpService.sayHello());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("User can't get One time password.");
        }
    }
}
