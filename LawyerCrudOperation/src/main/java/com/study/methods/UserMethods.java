package com.study.methods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMethods {
	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst()  && rs.getRow() == 0) ;
	}

}
