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
    @SqlUpdate("create table Admin (id integer primary key, login varchar(16), password varchar(4))")
    void createAdminTable();

    @SqlUpdate("insert into Admin values (:id, :login, :password)")
    @GetGeneratedKeys
    int insert(@BindBean() Admin admin);

    @SqlQuery("select * from Admin where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Admin findByName(@Bind("id") int id);
    
    /*@SqlQuery("select :column from Admin where AdMinId = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findColumnByName(@Bind("id")   String id,
    					  @Bind("column") String column);*/
    
	
    @SqlUpdate("drop table if exists Admin")
    void dropAdminTable();

    @SqlUpdate("delete from Admin where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from Admin order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Admin> all();

    @SqlQuery("select * from Admin where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Admin findById(@Bind("id") int id);

    void close();
}
