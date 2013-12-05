package com.spring.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class HandlerTypeHandler implements TypeHandler {
  
	private static final Map<Integer,HandlerType> map = new HashMap<Integer,HandlerType>();
	
	static{
		map.put(HandlerType.ERROR.getCode(), HandlerType.ERROR);
		map.put(HandlerType.SUCCESS.getCode(), HandlerType.SUCCESS);
	}
	
	@Override
	public Object getResult(ResultSet rs, String columnIndex) throws SQLException {
		return map.get(rs.getInt(columnIndex));
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return map.get(cs.getInt(columnIndex));
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		HandlerType type = (HandlerType) parameter;
		ps.setInt(i, type.getCode());
	}

}
