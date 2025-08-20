package Authorization.service.Authorization.service.Service;

import Authorization.service.Authorization.service.Enum.Authorities;
import Authorization.service.Authorization.service.Exception.InvalidCredentials;
import Authorization.service.Authorization.service.Exception.UnauthorizedUser;
import Authorization.service.Authorization.service.Repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;
    public AuthorizationService(UserRepository repository){
        this.userRepository = repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
