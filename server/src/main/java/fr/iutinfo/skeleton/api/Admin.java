package fr.iutinfo.skeleton.api;
/**
* @author team9
* GESTION UTILISATEURS
*/

import fr.iutinfo.skeleton.common.dto.AdminDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Admin {
    final static Logger logger = LoggerFactory.getLogger(Admin.class);
    
    private int AdMinId = 0;
    private String Login;
    private String Password;

    public Admin(int id, String login) {
        this.AdMinId = id;
        this.Login = login;
    }

    public Admin(int id, String login, String pwd) {
        this.AdMinId = id;
        this.Login = login;
        this.Password = pwd;
    }

    public Admin() {
    }

    public int getId() {
        return AdMinId;
    }

    public void setId(int id) {
        this.AdMinId = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    /*private String buildHash(String password, String s) {
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(password + s, Charsets.UTF_8);
        return hasher.hash().toString();
    }

    public boolean isGoodPassword(String password) {
        if (isAnonymous()) {
            return false;
        }
        String hash = buildHash(password, getSalt());
        return hash.equals(getPasswdHash());
    }*/

    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        Admin user = (Admin) arg;
        return Login.equals(user.Login) && Password.equals(user.Password);
    }

    @Override
    public String toString() {
        return AdMinId + ": " + Password + ", " + Login;
    }

    public void initFromDto(AdminDto dto) {
        this.setId(dto.getAdMinId());
        this.setLogin(dto.getLogin());
        this.setPassword(dto.getPassword());
    }

    public AdminDto convertToDto() {
        AdminDto dto = new AdminDto();
        dto.setAdMinId(this.getId());
        dto.setLogin(this.getLogin());
        dto.setPassword(this.getPassword());
        return dto;
    }
}
