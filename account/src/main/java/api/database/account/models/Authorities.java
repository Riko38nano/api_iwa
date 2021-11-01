package api.database.account.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "authorities")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authority_id;
    private String username;
    private String authority;

    public Authorities(String username, String role_user) {
        this.username = username;
        this.authority = role_user;
    }

    public long getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(long authority_id) {
        this.authority_id = authority_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
