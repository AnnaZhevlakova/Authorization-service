package Authorization.service.Authorization.service.Repository;

import Authorization.service.Authorization.service.Enum.Authorities;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        return null;
    }
}
