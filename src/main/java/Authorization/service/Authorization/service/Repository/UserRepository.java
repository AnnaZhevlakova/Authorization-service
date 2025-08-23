package Authorization.service.Authorization.service.Repository;

import Authorization.service.Authorization.service.Enum.Authorities;

import Authorization.service.Authorization.service.Dtos.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {
    private static List<UserDto> list = new CopyOnWriteArrayList<>(
            List.of(
                    new UserDto(
                            "admin",
                            "admin123",
                            Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)),
                    new UserDto(
                            "user1",
                            "user1",
                            Arrays.asList(Authorities.READ)),
                    new UserDto(
                            "user2",
                            "user2",
                            Arrays.asList(Authorities.WRITE, Authorities.DELETE))));


    public List<Authorities> getUserAuthorities(String user, String password) {
        var result = list.stream()
                .filter(x -> x.getLogin().equals(user) && x.getPassword().equals(password))
                .map(UserDto::getRights)
                .findFirst()
                .orElse(new ArrayList<>());
        return result;
    }
}
