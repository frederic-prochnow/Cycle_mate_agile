package fr.iutinfo.skeleton.api;

import org.junit.Test;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static org.junit.Assert.*;

import org.junit.Before;

public class PerformanceTest {
	
	Performance performance;
	PerformanceDao dao = getDbi().open(PerformanceDao.class);
	@Before
	public void before_test(){
		performance = new Performance(65535, 10, 20, 30, 40, 50);
	}
	
    @Test
    public void performance_non_null(){
    	assertNotNull(performance);
    }
    
    @Test
    public void test_get_id(){
    	assertEquals(performance.getId(),65535);
    }
    
    @Test
    public void test_get_puissance(){
    	assertEquals(performance.getPuissance(),10);
    }
    
    @Test
    public void test_suppression(){
    	dao.delete(65535);
    }
}
