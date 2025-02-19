package com.mandu.productManagement.service;

import com.mandu.productManagement.config.UserPrincipal;
import com.mandu.productManagement.entity.User;
import com.mandu.productManagement.repo.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDb userDb;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        User user = userDb.findByUserName(username);
        if (user==null){
            throw new UsernameNotFoundException("User "+username+ " not found");
        }
        return new UserPrincipal(user);
    }
}
