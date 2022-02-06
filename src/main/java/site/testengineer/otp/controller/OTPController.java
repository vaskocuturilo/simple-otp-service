package site.testengineer.otp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.testengineer.otp.service.HomeService;

@RestController
@RequestMapping("/api/otp")
public class OTPController {

    private HomeService homeService;

    public OTPController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public ResponseEntity getOneTimePassword() {
        try {
            return ResponseEntity.ok(homeService.returnOneTimePassword());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("User can't get One time password.");
        }
    }
}
