package com.ll.pnu_backend_mini_bootcamp.User;

import com.ll.pnu_backend_mini_bootcamp.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SiteUserService {

    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

    void create(String username, String password, String email){
        SiteUser siteUser = new SiteUser();
        siteUser.setUsername(username);
        siteUser.setPassword(passwordEncoder.encode(password));
        siteUser.setEmail(email);
        siteUserRepository.save(siteUser);
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.siteUserRepository.findByUsername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
}
