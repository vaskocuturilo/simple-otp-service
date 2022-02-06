package site.testengineer.otp.service;

import org.springframework.stereotype.Service;
import site.testengineer.otp.controller.OneTimePassword;
import site.testengineer.otp.controller.OneTimePasswordRepository;

import java.util.Date;

@Service
public class HomeService {

    private final Long expiryInterval = 5L * 60 * 1000;

    OneTimePasswordRepository oneTimePasswordRepository;

    public HomeService(OneTimePasswordRepository oneTimePasswordRepository) {
        this.oneTimePasswordRepository = oneTimePasswordRepository;
    }

    private Integer generateCode() {
        final Integer min = 100000;
        final Integer max = 999999;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public OneTimePassword returnOneTimePassword() {
        OneTimePassword oneTimePassword = new OneTimePassword();

        oneTimePassword.setOneTimePasswordCode(generateCode());
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + expiryInterval));

        oneTimePasswordRepository.save(oneTimePassword);

        return oneTimePassword;
    }
}
