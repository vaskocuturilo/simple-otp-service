package site.testengineer.otp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.testengineer.otp.service.HomeService;

@RestController
@RequestMapping("/api/v1/otp/")
public class OneTimePasswordController {

    private HomeService homeService;

    public OneTimePasswordController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/create")
    @ResponseBody
    private Object getOneTimePassword() {
        Object result;
        try {
            result = ResponseEntity.ok(homeService.returnOneTimePassword());
        } catch (Exception exception) {
            result = ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return result;
    }
}
