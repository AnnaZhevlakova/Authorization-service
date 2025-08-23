package Authorization.service.Authorization.service.Dtos;

import Authorization.service.Authorization.service.Enum.Authorities;

import java.util.List;

public class UserDto {
    private String login;
    private String password;
    private List<Authorities> rights;

    public UserDto(String login, String password, List<Authorities> rights){
        this.login = login;
        this.password = password;
        this.rights = rights;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getRights() {
        return rights;
    }

    public void setRights(List<Authorities> rights) {
        this.rights = rights;
    }
}
