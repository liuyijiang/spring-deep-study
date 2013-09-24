package com.spring.jdbctemplet.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.util.StopWatch;

@Component
public class JDBCAccess {
  
	private final Logger logger = LoggerFactory.getLogger(JDBCAccess.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 public <T> List<T> find(String sql, RowMapper<T> rowMapper, Object... params) {
	        StopWatch watch = new StopWatch();
	        try {
	            return jdbcTemplate.query(sql, params, rowMapper);
	        } finally {
	            //logger.debug("find, sql={}, params={}, elapsedTime={}", new Object[]{sql, params, watch.elapsedTime()});
	        }
	    }

	    public <T> T findUniqueResult(String sql, RowMapper<T> rowMapper, Object... params) {
	        StopWatch watch = new StopWatch();
	        try {
	            return jdbcTemplate.queryForObject(sql, params, rowMapper);
	        } finally {
	            //logger.debug("findUniqueResult, sql={}, params={}, elapsedTime={}", new Object[]{sql, params, watch.elapsedTime()});
	        }
	    }

	    public int findInteger(String sql, Object... params) {
	        StopWatch watch = new StopWatch();
	        try {
	            return jdbcTemplate.queryForInt(sql, params);
	        } finally {
	            //logger.debug("findInteger, sql={}, params={}, elapsedTime={}", new Object[]{sql, params, watch.elapsedTime()});
	        }
	    }

	    public String findString(String sql, Object... params) {
	        StopWatch watch = new StopWatch();
	        try {
	            return jdbcTemplate.queryForObject(sql, params, new RowMapper<String>() {
	                @Override
	                public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	                    return resultSet.getString(1);
	                }
	            });
	        } finally {
	           // logger.debug("findString, sql={}, params={}, elapsedTime={}", new Object[]{sql, params, watch.elapsedTime()});
	        }
	    }

	    public int execute(String sql, Object... params) {
	        StopWatch watch = new StopWatch();
	        try {
	            return jdbcTemplate.update(sql, params);
	        } finally {
	            logger.debug("execute, sql={}, params={}, elapsedTime={}", new Object[]{sql, params, watch.elapsedTime()});
	        }
	    }

	    public int[] batchExecute(String sql, List<Object[]> params) {
	        StopWatch watch = new StopWatch();
	        try {
	            return jdbcTemplate.batchUpdate(sql, params);
	        } finally {
	           // logger.debug("batchExecute, sql={}, params={}, elapsedTime={}", new Object[]{sql, params, watch.elapsedTime()});
	        }
	    }

}
