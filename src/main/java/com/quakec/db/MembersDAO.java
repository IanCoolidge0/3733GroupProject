package com.quakec.db;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class MembersDAO { 

	java.sql.Connection conn;
	
	final String tblName = "member";   // Exact capitalization

    public MembersDAO() {
    	try  {
    		conn = DatabaseUtil.connect();
    	} catch (Exception e) {
    		conn = null;
    	}
    }

   

}