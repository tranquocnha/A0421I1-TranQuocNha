package com.example.cesutudy.sercurity;

import com.example.cesutudy.model.Role;

import com.example.cesutudy.repository.role.UserRoleRepository;
import com.example.cesutudy.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        com.example.cesutudy.model.User user = this.userRepository.findByUserName(userName);
        if (user == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        System.out.println("Found user:! " + user);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        Set<Role> roles = user.getRoles();
//        for (Role role : roles) {
//            // ROLE_USER, ROLE_ADMIN,..
//            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
//            grantedAuthorities.add(authority);
//        }
//
//        UserDetails userDetails = (UserDetails)  new User(user.getUserName(), user.getPassword(), grantedAuthorities);
        return new MyUserDetails(user);
    }

}
