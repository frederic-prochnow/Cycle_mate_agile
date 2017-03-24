package fr.iutinfo.skeleton.api;
/**
* @author team9
* REQUETE DE VERIFCATION SQL UTILISATEURS
*/
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface PerformanceDao {
    @SqlUpdate("create table Performance (id integer primary key not null, periode integer, puissance integer, calories integer, vitesse integer, freqcard integer, contraints fk_id foreign key (id) references user(id)")
    void createPerformanceTable();

    @SqlUpdate("insert into Performance values (:id, :periode, :puissance, :calories, :vitesse, :freqcard)")
    @GetGeneratedKeys
    int insert(@BindBean() Performance performance);

    @SqlQuery("select * from Performance where periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Performance findByPeriode(@Bind("periode") int periode);
    
    @SqlQuery("select avg(puissance) from Performance")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int PuissanceMoy();
    
    @SqlQuery("select avg(calories) from Performance")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int CaloriesMoy();
    
    @SqlQuery("select avg(vitesse) from Performance")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int VitesseMoy();
    
    @SqlQuery("select avg(freqcard) from Performance")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int FreqCardMoy();
    
    @SqlQuery("select avg(puissance) from Performance where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int PuissanceMoyById(@Bind("id") int id);
    
    @SqlQuery("select avg(calories) from Performance where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int CaloriesMoyById(@Bind("id") int id);
    
    @SqlQuery("select avg(vitesse) from Performance where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int VitesseMoyById(@Bind("id") int id);
    
    @SqlQuery("select avg(freqcard) from Performance where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int FreqCardMoyById(@Bind("id") int id);
    
    /*@SqlQuery("select :column from Admin where AdMinId = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findColumnByName(@Bind("id")   String id,
    					  @Bind("column") String column);*/
    
	
    @SqlUpdate("drop table if exists Performance")
    void dropPerformanceTable();

    @SqlUpdate("delete from Performance where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from Performance order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Performance> all();

    @SqlQuery("select * from Admin where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Performance findById(@Bind("id") int id);

    void close();
}
