package site.testengineer.otp.controller;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OneTimePassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer oneTimePasswordCode;
    private Date expires;

    public OneTimePassword() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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