package com.quakec.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.quakec.model.Choice;



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

	public boolean createChoice(Choice choice, Context ctx) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (name,description,datetime,memberCount,chosenAlternative,id) values(?,?,?,?,?,?);");

		ps.setString(1, choice.getName());
		ps.setString(2, choice.getDescription());
		ps.setTimestamp(3, new Timestamp(choice.getDatetime().getTime()));
		ps.setInt(4, choice.getMemberCount());
		ps.setString(5, choice.getChosenAlternative());
		ps.setString(6, choice.getId());
		ps.execute();
		return true;

	}

	public Choice getChoice(String id) throws Exception {

		Choice choice = null;
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE id=?;");
		ps.setString(1,  id);
		ResultSet resultSet = ps.executeQuery();

		while (resultSet.next()) {
			choice = generateChoice(resultSet);
		}
		resultSet.close();
		ps.close();

		return choice;

	}

	public List<Choice> getAllChoices() throws Exception {
		ArrayList<Choice> choices = new ArrayList<>();

		Choice choice = null;
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName);
		ResultSet resultSet = ps.executeQuery();

		while (resultSet.next()) {
			choice = generateChoice(resultSet);
			choices.add(choice);
		}

		resultSet.close();
		ps.close();

		return choices;

	}

	public boolean deleteStaleChoices(int timeInMillis) throws Exception {
		String query = "DELETE FROM " + tblName + " WHERE date < DATEADD(ms, -?, GETDATE())";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, timeInMillis);
			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in deleting stale: " + e.getMessage());
		}
	}

	private Choice generateChoice(ResultSet resultSet) throws Exception {
		String name  = resultSet.getString("name");
		String description  = resultSet.getString("description");
		Timestamp timestamp  = resultSet.getTimestamp("datetime");
		Date date = new Date(timestamp.getTime());
		int memberCount  = resultSet.getInt("memberCount");
		String chosenAlternative  = resultSet.getString("chosenAlternative");
		String id  = resultSet.getString("id");

		return new Choice (id, name, description, date, memberCount,chosenAlternative);
	}

	public boolean completeChoice(String choiceId, String alternativeId) throws Exception {
		AlternativesDAO alternativesDAO = new AlternativesDAO();

		if(alternativesDAO.getAlternative(alternativeId).getChoiceId().equals(choiceId)) { // is the alternative actually part of the choice??
			PreparedStatement ps = conn.prepareStatement("UPDATE " + tblName + " SET chosenAlternative=? WHERE id=?;");
			ps.setString(1, alternativeId);
			ps.setString(2, choiceId);

			ps.execute();
			ps.close();

			return true;
		}

		// it's not, return false. something went wrong
		return false;
	}


}
