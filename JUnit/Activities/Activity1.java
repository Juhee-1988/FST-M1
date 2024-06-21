package com.example.fst_m1_junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Activity1 {
	
	public ArrayList<String> list;

	@BeforeEach
	public void setUp() {
		list = new ArrayList<String>();
		list.add("alpha");
		list.add("beta");
	}
	
	@Test
	@Order(0)
	public void insertTest() {
		assertEquals(2,list.size(),"Wrong Size");
		list.add(2,"gamma");
		assertEquals(3,list.size(),"Wrong Size");	
		assertEquals("alpha",list.get(0),"Wrong Element");
		assertEquals("beta",list.get(1),"Wrong Element");
		assertEquals("gamma",list.get(2),"Wrong Element");
	}
	
	@Test
	@Order(1)
	public void replaceTest() {
		list.set(1,"gamma");
		assertEquals(2,list.size(),"Wrong Size");
		assertEquals("alpha",list.get(0),"Wrong Element");
		assertEquals("gamma",list.get(1),"Wrong Element");
	}
}
