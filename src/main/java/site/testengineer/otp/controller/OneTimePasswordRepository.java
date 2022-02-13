package site.testengineer.otp.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneTimePasswordRepository extends CrudRepository<OneTimePassword, Long> {
}
