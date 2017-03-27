package fr.iutinfo.skeleton.api;
/**
* @author team9
* GESTION WEB UTILISATEURS
*/
import fr.iutinfo.skeleton.common.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    final static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static UserDao dao = getDbi().open(UserDao.class);
    private static boolean isDefault = true;
    
    public void creation_table(){
    	 logger.debug("Crate table users");
         dao.createUserTable();
         dao.insert(new User(1, "Dylan","","dylan@cyclemate.com" ));
         dao.insert(new User(2, "Douglas","","douglas@cyclemate.com" ));
         dao.insert(new User(3, "Caroline","","caroline@cyclemate.com" ));
         dao.insert(new User(4, "Cindy","","cindy@cyclemate.com" ));
         dao.insert(new User(5, "Baptiste","","baptiste@cyclemate.com" ));
         dao.insert(new User(6, "Stéphanie","","stephanie@cyclemate.com" ));
         dao.insert(new User(7, "Maurice","","maurice@cyclemate.com" ));
         dao.insert(new User(8, "Cassius","","cassius@cyclemate.com" ));
         dao.insert(new User(9, "Sarah","","sarah@cyclemate.com" ));
         dao.insert(new User(10, "Stan","","stan@cyclemate.com" ));
    }

    public UserResource() throws SQLException {
        if (!tableExist("users")) {
            logger.debug("Crate table users");
            creation_table();
        } if(tableExist("users")&& isDefault){
        	dao.dropUserTable();
        	creation_table();
        	isDefault = false;
        }
    }

    @POST
    public UserDto createUser(UserDto dto) {
        User user = new User();
        user.initFromDto(dto);
        user.resetPasswordHash();
        int id = dao.insert(user);
        dto.setId(id);
        return dto;
    }

    @GET
    @Path("/{name}")
    public UserDto getUser(@PathParam("name") String name) {
        User user = dao.findByName(name);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user.convertToDto();
    }
    
    /*@GET
    @Path("/{id}")
    public UserDto getUserParam(@PathParam("id") int id) {
        User user = dao.findById(id);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user.convertToDto();
    }*/

    @GET
    public List<UserDto> getAllUsers(@QueryParam("q") String query) {
        List<User> users;
        if (query == null) {
            users = dao.all();
        } else {
            logger.debug("Search users with query: " + query);
            users = dao.search("%" + query + "%");
        }
        return users.stream().map(User::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/del/{id}")
    public void deleteUser(@PathParam("id") int id) {
        dao.delete(id);
    }

}
