package com.sd.brigadeiria.acesso;

import com.sd.brigadeiria.model.Usuario;
import com.sd.brigadeiria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private  UsuarioRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = this.userRepository.findUsuarioByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("username " + username + " is not found");
        }
        return new CustomUserDetails(user);
    }



    static final class CustomUserDetails extends Usuario implements UserDetails {

        private static final List<GrantedAuthority> ROLE_USER = Collections
                .unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

        CustomUserDetails(Usuario user) {
            super.setLogin(user.getLogin());
            super.setSenha(user.getSenha());
            //super.setRole(user.getRole());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections
                    .unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
            //return ROLE_USER;
        }

        @Override
        public String getPassword() {
            return getSenha();
        }

        @Override
        public String getUsername() {
            return getLogin();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }

}
