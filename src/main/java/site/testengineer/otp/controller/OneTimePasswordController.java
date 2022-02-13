package site.testengineer.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.testengineer.otp.service.OneTimePasswordService;

@RestController
@RequestMapping("/api/v1/otp/")
public class OneTimePasswordController {

    private OneTimePasswordService oneTimePAsswordService;

    @Autowired
    public OneTimePasswordController(OneTimePasswordService oneTimePAsswordService) {
        this.oneTimePAsswordService = oneTimePAsswordService;
    }

    @GetMapping("/create")
    private Object getOneTimePassword() {
        try {
            return ResponseEntity.ok(oneTimePAsswordService.returnOneTimePassword());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}
