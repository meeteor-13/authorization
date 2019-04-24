package com.github.meeteor13.authorization.domain.service;

import com.github.meeteor13.authorization.domain.repository.DefaultUserDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultUserDetailsService implements UserDetailsService {

    private final DefaultUserDetailsRepository userDetailsRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        log.info("Trying to fetch user by {} username", username);

        return userDetailsRepository.findOneByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
