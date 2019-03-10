package pl.arturzaczek.exercise34.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.arturzaczek.exercise34.entity.User;
import pl.arturzaczek.exercise34.repository.UserRepository;

@Service
public class UserContextService {

    private UserRepository userRepository;

    @Autowired
    public UserContextService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String getLoggedAs(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication instanceof AnonymousAuthenticationToken){
            return null;
        }
        //authentication.getAuthorities().stream().map(a->a.getAuthority())
        return authentication.getName();
    }

    public boolean hasRole(String roleName){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication instanceof AnonymousAuthenticationToken){
            return false;
        }

        return authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .anyMatch(s -> s.equals(roleName));

    }
    public User getLoggedUser (){
        return userRepository.getUserEntityByEmail(getLoggedAs()).get();
    }
}
