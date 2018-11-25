package com.alex.access.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;
public class DataAccessDAO extends JdbcDaoSupport{
	@Transactional
	public void insert(String sql)
	{
		this.getJdbcTemplate().execute(sql);
		throw new RuntimeException("hello");
	}

}
