package Authorization.service.Authorization.service.Controller;

import Authorization.service.Authorization.service.Enum.Authorities;
import Authorization.service.Authorization.service.Models.User;
import Authorization.service.Authorization.service.Service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;
    public AuthorizationController(AuthorizationService service){
       this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities( @Valid User user) {
        return service.getAuthorities(user.getLogin(), user.getPassword());
    }
}
