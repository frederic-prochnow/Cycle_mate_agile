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
    
    private int id = 1;
    private String login;
    private String password;

    public Admin(Integer id, String login) {
    	this.id = id;
        this.login = login;
    }

    public Admin(Integer id, String login, String pwd) {
    	this(id, login);
        this.password = pwd;
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return login.equals(user.login) && password.equals(user.password);
    }

    @Override
    public String toString() {
        return id + ": " + password + ", " + login;
    }

    public void initFromDto(AdminDto dto) {
        this.setId(dto.getId());
        this.setLogin(dto.getLogin());
        this.setPassword(dto.getPassword());
    }

    public AdminDto convertToDto() {
        AdminDto dto = new AdminDto();
        dto.setId(this.getId());
        dto.setLogin(this.getLogin());
        dto.setPassword(this.getPassword());
        return dto;
    }
}
