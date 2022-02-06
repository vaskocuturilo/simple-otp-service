package site.testengineer.otp.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OneTimePassword {

    @Id
    private Long id;
    private Integer oneTimePasswordCode;
    private Date expires;


    public OneTimePassword() {

    }

    public OneTimePassword(Integer oneTimePasswordCode, Date expires) {
        this.oneTimePasswordCode = oneTimePasswordCode;
        this.expires = expires;
    }

    public Integer getOneTimePasswordCode() {
        return oneTimePasswordCode;
    }

    public void setOneTimePasswordCode(Integer oneTimePasswordCode) {
        this.oneTimePasswordCode = oneTimePasswordCode;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
}
