package fr.iutinfo.skeleton.api;

import org.junit.Test;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static org.junit.Assert.*;

import org.junit.Before;

public class AdminTest {
	
	Admin admin;
	@Before
	public void before_test(){
		admin = new Admin(2,"test","mdp");
	}
	
    @Test
    public void admin_non_null(){
    	assertNotNull(admin);
    }
    
    @Test
    public void test_get_login(){
    	assertEquals(admin.getLogin(),"test");
    }
    
    @Test
    public void test_get_mdp(){
    	assertEquals(admin.getPassword(),"mdp");
    }
    
    @Test
    public void test_suppression(){
    	AdminDao dao = getDbi().open(AdminDao.class);
    	dao.delete(2);
    }
}
