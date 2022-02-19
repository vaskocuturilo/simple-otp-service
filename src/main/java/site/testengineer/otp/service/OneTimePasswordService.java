package site.testengineer.otp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.testengineer.otp.utils.OneTimePasswordHelpService;
import site.testengineer.otp.model.OneTimePassword;
import site.testengineer.otp.repository.OneTimePasswordRepository;

import java.util.Date;

@Service
public class OneTimePasswordService {

    private final Long expiryInterval = 5L * 60 * 1000;

    OneTimePasswordRepository oneTimePasswordRepository;

    OneTimePasswordHelpService oneTimePasswordHelpService;

    @Autowired
    public OneTimePasswordService(OneTimePasswordRepository oneTimePasswordRepository) {
        this.oneTimePasswordRepository = oneTimePasswordRepository;
    }

    public OneTimePassword returnOneTimePassword() {
        OneTimePassword oneTimePassword = new OneTimePassword();

        oneTimePassword.setOneTimePasswordCode(oneTimePasswordHelpService.createRandomOneTimePassword().get());
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + expiryInterval));

        oneTimePasswordRepository.save(oneTimePassword);

        return oneTimePassword;
    }
}
