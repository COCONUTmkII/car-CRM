package by.home.chevrolet.service.impl;

import by.home.chevrolet.entity.Manager;
import by.home.chevrolet.model.JwtManager;
import by.home.chevrolet.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Optional<Manager> managerOptional = managerRepository.findByNickname(nickname);
        Manager manager = managerOptional
                .orElseThrow(() -> new UsernameNotFoundException("No manager found with this nickname " + nickname));
        /*return new User(manager.getNickname(), manager.getPassword(),
                manager.isEnabled(),
                true, true, true, getAuthorities("Admin"));*/
        return new JwtManager(manager.getId(), manager.getNickname(), manager.getEmail(), manager.getTelephone(),
                manager.getPassword(), true, getAuthorities("Admin"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
    /*@Autowired
    ManagerRepository managerRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Optional<Manager> managerOptional = managerRepository.findByNickname(nickname);
        Manager manager = managerOptional
                .orElseThrow(() -> new UsernameNotFoundException("No manager found with this nickname " + nickname));
        return new User(manager.getNickname(), manager.getPassword(),
                manager.isEnabled(),
                true, true, true, getAuthorities("Admin"));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }*/

}
