package fr.iutinfo.skeleton.common.remote;

import java.util.List;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.format.DataFormatDetector;

import fr.iutinfo.skeleton.api.Api;
import fr.iutinfo.skeleton.api.BDDFactory;
import fr.iutinfo.skeleton.api.User;
import fr.iutinfo.skeleton.api.UserDao;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class UsersProviderIntegrationTest extends JerseyTest {

    private UserDao userDao = BDDFactory.getDbi().open(UserDao.class);
    private UsersProvider usersProvider = new UsersProvider(getBaseUri().toString());

    @Override
    protected Application configure() {
        return new Api();
    }


    @Test
    public void should_add_remote_user() {
        initDatabase();
        UserDto olivier = new UserDto();
        olivier.setName("Olivier");

        UserDto remoteUser = usersProvider.addUser(olivier);
        User bddUser = userDao.findById(remoteUser.getId());

        Assert.assertEquals("Olivier", bddUser.getName());
    }


    private void createUser(String name) {
        User thomas = new User();
        thomas.setName(name);
        userDao.insert(thomas);
    }

    private void initDatabase() {
        userDao.dropUserTable();
        userDao.createUserTable();
    }
}
