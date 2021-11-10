package api.database.account.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Entity(name="verif_tokens")
public class VerificationToken {
    public static final int EXPIRATION = 60 * 24; // min

    @Id
    private String token;

    private String username;
    private Date expiryDate;

    public Date calculateExpiryDate(int expiryTimeInMins) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, expiryTimeInMins);

        return cal.getTime();
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
