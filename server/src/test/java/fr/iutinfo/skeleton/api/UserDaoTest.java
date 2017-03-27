package fr.iutinfo.skeleton.api;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserDaoTest {
	
	UserDao dao;
	
	@Before
	public void init(){
		dao = BDDFactory.getDbi().open(UserDao.class);
	}

	@Test
	public void test_insert(){
		
	}

}
