package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.ChatDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/chat")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class ChatResource {
    final static Logger logger = LoggerFactory.getLogger(ChatResource.class);
    private static ChatDao dao = getDbi().open(ChatDao.class);
    private static boolean isDefault = true;
    
    public void creation_table(){
    	dao.insert(new Chat("Dylan", "Bonjour, je test le chat!", new Date().getTime()));
    	dao.insert(new Chat("Douglas", "Il semble fonctionner.", new Date().getTime()));
    	dao.insert(new Chat("Caroline", "Coucou tout le monde!", new Date().getTime()));
    }

    public ChatResource() throws SQLException {
        if (!tableExist("Chat")) {
            logger.debug("Create table Chat");
            dao.createChatTable();
            creation_table();
       } if(tableExist("Chat")&&isDefault){
    	   dao.dropChatTable();
    	   logger.debug("Create table Chat");
           dao.createChatTable();
    	   creation_table();
    	   isDefault = false;
       }
    }

    @POST
    public ChatDto createChat(ChatDto dto) {
    	Chat chat = new Chat();
        chat.initFromDto(dto);
        dao.insert(chat);
        return dto;
    }

    @GET
    @Path("/{id}")
    public Chat getChat(@PathParam("id") int id) {
        Chat chat;
        chat = dao.findById(id);
        return chat;
    }
    
    @GET
    @Path("/max")
    public int getMxId() {
        int chat;
        chat = dao.getMaxId();
        return chat;
    }

    @GET
    public List<Chat> getAllChat(@QueryParam("q") String query) throws SQLException {
        List<Chat> chat;
        if (query == null) {
            chat = dao.all();
        } else{
        	chat = null;
        }
        Collections.reverse(chat);
        return chat;
    }

}
