package auth;

import model.Company;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import service.CompanyService;
import service.UserService;

import java.util.Arrays;
import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;
    private CompanyService companyService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = userService.loadUserByUsername(username);
        Company company = null;
        if (user == null) {
            company = companyService.loadUserByUsername(username);
            if (company == null) {
                throw new BadCredentialsException("Username not found.");
            }
            String hashedPassword = AuthHelper.encrypt(password, company.getSalt());
                if (company.getPassword().equals(hashedPassword)) {
                    return setAuthentication(company.getId(), company, Arrays.asList(new SimpleGrantedAuthority("USER")));

                }  else {
                    throw new BadCredentialsException("Wrong password.");

                }
        }
        String hashedPass = AuthHelper.encrypt(password, user.getSalt());
        if (password.equals(user.getPassword())) {
            return setAuthentication(user.getId(), user, Arrays.asList(new SimpleGrantedAuthority("USER")));

        }  else {
            throw new BadCredentialsException("Wrong password.");
        }
    }
    private Authentication setAuthentication(Long id, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        Authentication authToken =
                new UsernamePasswordAuthenticationToken(
                        id,
                        credentials,
                        Arrays.asList(new SimpleGrantedAuthority("USER"))

                );
        SecurityContextHolder.getContext().setAuthentication(authToken);
        return authToken;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
