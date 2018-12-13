package com.nagarro.main;



import org.hibernate.Session;
import com.nagarro.hibernate.util.Connection;;
public class Main {
	public static void main(String[] args) {
		try (Session currentSession=Connection.getSession()){
			String query="SELECT User();";
			String result=(String)currentSession.createNativeQuery(query).getSingleResult();
			System.out.println(result);
		}
		
	}
}
