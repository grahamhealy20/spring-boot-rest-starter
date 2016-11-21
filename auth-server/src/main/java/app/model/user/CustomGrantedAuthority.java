package app.model.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by GrahamH on 15/08/2016.
 */

@Entity
public class CustomGrantedAuthority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    public CustomGrantedAuthority() {

    }

    public CustomGrantedAuthority(String authority) {
        this.authority = authority;
    }
}
