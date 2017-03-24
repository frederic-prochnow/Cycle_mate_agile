package fr.iutinfo.skeleton.api;
/**
* @author team9
* GESTION WEB UTILISATEURS
*/
import fr.iutinfo.skeleton.common.dto.PerformanceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/perf")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class PerformanceResource {
    final static Logger logger = LoggerFactory.getLogger(PerformanceResource.class);
    private static PerformanceDao dao = getDbi().open(PerformanceDao.class);

    public PerformanceResource() throws SQLException {
        if (!tableExist("Performance")) {
            logger.debug("Create table Performance");
            dao.createPerformanceTable();
            //c'est ici que l'on inserera les donnees Performance
            dao.insert(new Performance(1, 120, 3, 20, 145, 1));
            dao.insert(new Performance(1, 156, 3, 26, 159, 2));
            dao.insert(new Performance(1, 144, 3, 24, 174, 3));
            dao.insert(new Performance(1, 180, 4, 30, 188, 4));
            dao.insert(new Performance(1, 234, 5, 39, 145, 5));
            dao.insert(new Performance(1, 216, 5, 36, 159, 6));
            dao.insert(new Performance(1, 180, 4, 30, 174, 7));
            dao.insert(new Performance(1, 234, 5, 39, 188, 8));
            dao.insert(new Performance(1, 216, 5, 36, 145, 9));
            dao.insert(new Performance(1, 180, 4, 30, 159, 10));
            
            dao.insert(new Performance(2, 182, 4, 26, 154, 1));
            dao.insert(new Performance(2, 140, 3, 20, 140, 2));
            dao.insert(new Performance(2, 210, 5, 30, 182, 3));
            dao.insert(new Performance(2, 252, 6, 36, 159, 4));
            dao.insert(new Performance(2, 210, 5, 30, 174, 5));
            dao.insert(new Performance(2, 273, 6, 39, 188, 6));
            dao.insert(new Performance(2, 273, 6, 39, 145, 7));
            dao.insert(new Performance(2, 210, 5, 30, 159, 8));
            dao.insert(new Performance(2, 168, 4, 24, 168, 9));
            dao.insert(new Performance(2, 252, 6, 36, 145, 10));
             
            dao.insert(new Performance(3, 160, 4, 22, 142, 1));
            dao.insert(new Performance(3, 208, 5, 28, 156, 2));
            dao.insert(new Performance(3, 192, 4, 26, 170, 3));
            dao.insert(new Performance(3, 100, 2, 33, 140, 4));
            dao.insert(new Performance(3, 130, 3, 42, 145, 5));
            dao.insert(new Performance(3, 120, 3, 39, 159, 6));
            dao.insert(new Performance(3, 160, 4, 33, 174, 7));
            dao.insert(new Performance(3, 208, 5, 42, 188, 8));
            dao.insert(new Performance(3, 192, 4, 39, 145, 9));
            dao.insert(new Performance(3, 160, 4, 33, 159, 10));
            
            dao.insert(new Performance(4, 120, 3, 18, 150, 1));
            dao.insert(new Performance(4, 156, 3, 23, 165, 2));
            dao.insert(new Performance(4, 144, 3, 21, 180, 3));
            dao.insert(new Performance(4, 130, 3, 27, 140, 4));
            dao.insert(new Performance(4, 169, 4, 35, 145, 5));
            dao.insert(new Performance(4, 156, 3, 32, 159, 6));
            dao.insert(new Performance(4, 200, 5, 27, 174, 7));
            dao.insert(new Performance(4, 260, 6, 35, 188, 8));
            dao.insert(new Performance(4, 240, 6, 32, 145, 9));
            dao.insert(new Performance(4, 200, 5, 27, 159, 10));
            
            dao.insert(new Performance(5, 200, 5, 25, 145, 1));
            dao.insert(new Performance(5, 260, 6, 32, 159, 2));
            dao.insert(new Performance(5, 240, 6, 30, 174, 3));
            dao.insert(new Performance(5, 220, 5, 37, 160, 4));
            dao.insert(new Performance(5, 286, 7, 48, 145, 5));
            dao.insert(new Performance(5, 264, 6, 45, 159, 6));
            dao.insert(new Performance(5, 300, 7, 37, 174, 7));
            dao.insert(new Performance(5, 390, 9, 48, 188, 8));
            dao.insert(new Performance(5, 360, 9, 45, 160, 9));
            dao.insert(new Performance(5, 300, 7, 37, 176, 10));
            
            dao.insert(new Performance(6, 190, 4, 25, 145, 1));
            dao.insert(new Performance(6, 247, 6, 32, 159, 2));
            dao.insert(new Performance(6, 280, 7, 30, 174, 3));
            dao.insert(new Performance(6, 220, 5, 37, 160, 4));
            dao.insert(new Performance(6, 286, 7, 48, 145, 5));
            dao.insert(new Performance(6, 264, 6, 45, 159, 6));
            dao.insert(new Performance(6, 300, 7, 37, 174, 7));
            dao.insert(new Performance(6, 390, 9, 48, 188, 8));
            dao.insert(new Performance(6, 150, 3, 45, 160, 9));
            dao.insert(new Performance(6, 160, 4, 37, 176, 10));
            
            dao.insert(new Performance(7, 195, 4, 25, 145, 1));
            dao.insert(new Performance(7, 253, 6, 32, 159, 2));
            dao.insert(new Performance(7, 320, 8, 30, 174, 3));
            dao.insert(new Performance(7, 220, 5, 30, 160, 4));
            dao.insert(new Performance(7, 286, 7, 39, 145, 5));
            dao.insert(new Performance(7, 264, 6, 36, 159, 6));
            dao.insert(new Performance(7, 160, 4, 20, 150, 7));
            dao.insert(new Performance(7, 208, 5, 16, 188, 8));
            dao.insert(new Performance(7, 150, 3, 24, 160, 9));
            dao.insert(new Performance(7, 300, 7, 30, 176, 10));
            
            dao.insert(new Performance(8, 230, 5, 25, 145, 1));
            dao.insert(new Performance(8, 229, 7, 32, 159, 2));
            dao.insert(new Performance(8, 320, 8, 30, 174, 3));
            dao.insert(new Performance(8, 210, 5, 30, 160, 4));
            dao.insert(new Performance(8, 273, 6, 39, 145, 5));
            dao.insert(new Performance(8, 252, 6, 36, 159, 6));
            dao.insert(new Performance(8, 360, 9, 30, 180, 7));
            dao.insert(new Performance(8, 400, 10, 39, 188, 8));
            dao.insert(new Performance(8, 200, 5, 35, 160, 9));
            dao.insert(new Performance(8, 300, 7, 30, 176, 10));
            
            dao.insert(new Performance(9, 170, 4, 25, 145, 1));
            dao.insert(new Performance(9, 221, 5, 32, 159, 2));
            dao.insert(new Performance(9, 350, 8, 30, 174, 3));
            dao.insert(new Performance(9, 220, 5, 30, 156, 4));
            dao.insert(new Performance(9, 286, 7, 39, 145, 5));
            dao.insert(new Performance(9, 264, 6, 36, 159, 6));
            dao.insert(new Performance(9, 360, 9, 30, 176, 7));
            dao.insert(new Performance(9, 370, 9, 37, 188, 8));
            dao.insert(new Performance(9, 222, 5, 33, 160, 9));
            dao.insert(new Performance(9, 300, 7, 30, 176, 10));
 
            dao.insert(new Performance(10, 150, 3, 25, 140, 1));
            dao.insert(new Performance(10, 195, 4, 32, 154, 2));
            dao.insert(new Performance(10, 250, 6, 30, 168, 3));
            dao.insert(new Performance(10, 220, 5, 30, 156, 4));
            dao.insert(new Performance(10, 286, 7, 36, 145, 5));
            dao.insert(new Performance(10, 264, 6, 33, 155, 6));
            dao.insert(new Performance(10, 290, 7, 30, 168, 7));
            dao.insert(new Performance(10, 260, 6, 35, 176, 8));
            dao.insert(new Performance(10, 220, 5, 33, 160, 9));
            dao.insert(new Performance(10, 270, 6, 29, 176, 10));
       }
    }

    @POST
    public PerformanceDto createPerformance(PerformanceDto dto) {
        Performance performance = new Performance();
        performance.initFromDto(dto);
        return dto;
    }

    @GET
    @Path("/{id}")
    public PerformanceDto getPerformance(@PathParam("id") int id) {
        Performance performance = dao.findById(id);
        if (performance == null) {
            throw new WebApplicationException(404);
        }
        return performance.convertToDto();
    }
    
    @GET
    @Path("/moy/{id}")
    public PerformanceDto getMoyenne(@PathParam("id") int id) {
    	Performance performance = dao.findById(id);
    	performance.setCaloriesmoy(dao.CaloriesMoyById(id));
    	performance.setVitessemoy(dao.VitesseMoyById(id));;
    	performance.setFreqcardmoy(dao.FreqCardMoyById(id));
    	performance.setPuissancemoy(dao.PuissanceMoyById(id));
    	return performance.convertToDto();
    }
    
    /*@GET
    @Path("/{name}/{column}")
    public PerformanceDto getPerformanceParam(@PathParam("name") String name, @PathParam("column") String column) {
        Performance Performance = dao.findColumnByName(name, column);
        System.out.println("Performance("+name+","+column+")  => "+Performance);
        if (Performance == null) {
            throw new WebApplicationException(404);
        }
        return Performance.convertToDto();
    }*/

    @GET
    public List<Performance> getAllPerformances(@QueryParam("q") String query) throws SQLException {
        List<Performance> performances;
        if (query == null) {
            performances = dao.all();
            if (performances.isEmpty()){
            	dao.insert(new Performance(1, 120, 3, 20, 145, 1));
            	performances = dao.all();
            }
        } else{
        	performances = null;
        }
        return performances;
    }

    @DELETE
    @Path("/{id}")
    public void deletePerformance(@PathParam("id") int id) {
        dao.delete(id);
    }

}
