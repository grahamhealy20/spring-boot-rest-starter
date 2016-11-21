package app.services;

import app.model.user.CustomGrantedAuthority;
import app.model.user.CustomUser;
import app.model.user.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrahamH on 15/08/2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private CustomUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        CustomUser user = userRepository.findByUsername(s);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("Username not found");

    }


    public void addNewUser(String username, String password, String email) {

        String encrypted_password = passwordEncoder.encode(password);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new CustomGrantedAuthority("ROLE_USER"));

        CustomUser user = new CustomUser(username, encrypted_password, email, authorities);
        userRepository.save(user);
    }
}
