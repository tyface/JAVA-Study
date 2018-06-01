package test;

import org.junit.Test;

import service.MemberService;

public class ServiceTest {
	MemberService service;
	
	@Test
	public void testService() {
		service = new MemberService();
		
		System.out.println(service.login("zxuz3123", "1234555"));
	}
}
