package com.quakec.db;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ChoicesDAO { 

	java.sql.Connection conn;
	
	final String tblName = "choice";   // Exact capitalization

    public ChoicesDAO() {
    	try  {
    		conn = DatabaseUtil.connect();
    	} catch (Exception e) {
    		conn = null;
    	}
    }

   

}