package site.testengineer.otp.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OneTimePasswordRepository extends JpaRepository<OneTimePassword, Long> {

}
