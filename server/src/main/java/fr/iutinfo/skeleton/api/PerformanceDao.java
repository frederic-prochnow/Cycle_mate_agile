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
    @SqlUpdate("create table Performance (id integer, periode integer, puissance integer, calories integer, vitesse integer, freqcard integer)")
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
    
    //dessous : testing debugging...
    
    @SqlQuery("select avg(puissance) from Performance where periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int PuissanceMoyPeriodic(@Bind("periode") int periode);
    
    @SqlQuery("select avg(calories) from Performance where periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int CaloriesMoyPeriodic(@Bind("periode") int periode);
    
    @SqlQuery("select avg(vitesse) from Performance where periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int VitesseMoyPeriodic(@Bind("periode") int periode);
    
    @SqlQuery("select avg(freqcard) from Performance where periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int FreqCardMoyPeriodic(@Bind("periode") int periode);
    
    @SqlQuery("select avg(puissance) from Performance where id = :id and periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int PuissanceMoyPeriodicById(@Bind("id") int id, @Bind("periode") int periode);
    
    @SqlQuery("select avg(calories) from Performance where id = :id and periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int CaloriesMoyPeriodicById(@Bind("id") int id, @Bind("periode") int periode);
    
    @SqlQuery("select avg(vitesse) from Performance where id = :id and periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int VitesseMoyPeriodicById(@Bind("id") int id, @Bind("periode") int periode);
    
    @SqlQuery("select avg(freqcard) from Performance where id = :id and periode = :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int FreqCardMoyPeriodicById(@Bind("id") int id, @Bind("periode") int periode);
    
    @SqlQuery("select sum(calories) from Performance where id = :id and periode <= :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int CumuledCalForPeriodByID(@Bind("id") int id, @Bind("periode") int periode);
    
    @SqlQuery("select sum(calories) from Performance where periode <= :periode")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int CumuledCalForPeriod(@Bind("periode") int periode);
    
    @SqlQuery("select sum(calories) from Performance")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int CumuledCalTotal();
    
    @SqlQuery("select max(id) from Performance")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int TotalIds();
	
    @SqlUpdate("drop table if exists Performance")
    void dropPerformanceTable();

    @SqlUpdate("delete from Performance where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from Performance order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Performance> all();

    @SqlQuery("select * from Performance where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Performance> findById(@Bind("id") int id);

    void close();
}
