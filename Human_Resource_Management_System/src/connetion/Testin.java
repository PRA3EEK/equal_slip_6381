package connetion;

import java.sql.Connection;

public class Testin {

	public static void main(String[] args) {
	 
		Connection con = CreateConnetion.create();
		System.out.println(con);
		
	}
}
