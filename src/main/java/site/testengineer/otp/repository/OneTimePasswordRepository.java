package site.testengineer.otp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import site.testengineer.otp.model.OneTimePassword;

@Repository
public interface OneTimePasswordRepository extends CrudRepository<OneTimePassword, Long> {
}
