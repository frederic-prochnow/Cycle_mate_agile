package fr.iutinfo.skeleton.api;
/**
* @author team9
* REQUETE DE VERIFCATION SQL UTILISATEURS
*/
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface ChatDao {
    @SqlUpdate("create table Chat (id integer primary key autoincrement, nom text, message text, time bigint)")
    void createChatTable();

    @SqlUpdate("insert into Chat (nom, message, time) values (:nom, :message, :time)")
    @GetGeneratedKeys
    int insert(@BindBean() Chat chat);
    
    @SqlUpdate("drop table if exists Chat")
    void dropChatTable();

    @SqlQuery("select * from Chat order by time desc limit 15")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Chat> all();

    @SqlQuery("select * from Chat where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Chat> findById(@Bind("id") int id);

    void close();
}
