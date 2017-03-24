package fr.iutinfo.skeleton.api;
/**
* @author team9
* REQUETE DE VERIFCATION SQL UTILISATEURS
*/
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface AdminDao {
    @SqlUpdate("create table Admin (AdMinId integer primary key autoincrement, Login varchar(16), Password varchar(4))")
    void createAdminTable();

    @SqlUpdate("insert into Admin (AdMinId,Login,Password) values (:AdMinId, :Login, :Password)")
    @GetGeneratedKeys
    int insert(@BindBean() Admin admin);

    @SqlQuery("select * from Admin where AdMinId = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findByName(@Bind("id") String id);
    
    /*@SqlQuery("select :column from Admin where AdMinId = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findColumnByName(@Bind("id")   String id,
    					  @Bind("column") String column);*/
    
	
    @SqlUpdate("drop table if exists Admin")
    void dropUserTable();

    @SqlUpdate("delete from Admin where AdMinId = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from Admin order by AdMinId")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Admin> all();

    @SqlQuery("select * from Admin where AdMinId = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Admin findById(@Bind("id") int id);

    void close();
}
