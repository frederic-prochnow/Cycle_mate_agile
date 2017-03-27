package fr.iutinfo.skeleton.api;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MoyenneTest {
	
	Moyenne moyenne;
	@Before
	public void before_test(){
		moyenne = new Moyenne(1000, 50, 60, 70, 80);
	}
	
    @Test
    public void moyenne_non_null(){
    	assertNotNull(moyenne);
    }
    
    @Test
    public void test_get_id(){
    	assertEquals(moyenne.getId(),1000);
    }
    
    @Test
    public void test_get_mdp(){
    	assertEquals(moyenne.getMoyCalories(),60);
    }
}
