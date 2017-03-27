package fr.iutinfo.skeleton.api;
/**
* @author team9
* GESTION WEB UTILISATEURS
*/
import fr.iutinfo.skeleton.common.dto.AdminDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class AdminResource {
    final static Logger logger = LoggerFactory.getLogger(AdminResource.class);
    private static AdminDao dao = getDbi().open(AdminDao.class);
    private static boolean isDefault = true;

    public void creation_table(){
    	dao.insert(new Admin(1, "LaBoheme", "adminpwd"));
    }
    
    public AdminResource() throws SQLException {
        if (!tableExist("Admin")) {
            logger.debug("Create table Admin");
            dao.createAdminTable();
            creation_table();
        }if(tableExist("Admin")&&isDefault){
        	dao.dropAdminTable();
        	logger.debug("Create table Admin");
            dao.createAdminTable();
        	creation_table();
        	isDefault = false;
        }
    }

    @POST
    public AdminDto createAdmin(AdminDto dto) {
        Admin admin = new Admin();
        admin.initFromDto(dto);
        return dto;
    }

    @GET
    @Path("/{id}")
    public AdminDto getAdmin(@PathParam("id") int id) {
        Admin admin = dao.findById(id);
        if (admin == null) {
            throw new WebApplicationException(404);
        }
        return admin.convertToDto();
    }
    
    /*@GET
    @Path("/{name}/{column}")
    public AdminDto getAdminParam(@PathParam("name") String name, @PathParam("column") String column) {
        Admin Admin = dao.findColumnByName(name, column);
        System.out.println("Admin("+name+","+column+")  => "+Admin);
        if (Admin == null) {
            throw new WebApplicationException(404);
        }
        return Admin.convertToDto();
    }*/

    @GET
    public List<Admin> getAllAdmins(@QueryParam("q") String query) throws SQLException {
        List<Admin> admins;
        if (query == null) {
            admins = dao.all();
            if (admins.isEmpty()){
            	dao.insert(new Admin(1, "LaBoheme", "adminpwd"));
            	admins = dao.all();
            }
        } else{
        	admins = null;
        }
        return admins;
    }

    @DELETE
    @Path("/{id}")
    public void deleteAdmin(@PathParam("id") int id) {
        dao.delete(id);
    }

}
