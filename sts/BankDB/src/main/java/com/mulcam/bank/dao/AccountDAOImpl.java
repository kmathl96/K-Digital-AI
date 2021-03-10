package com.mulcam.bank.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.mulcam.bank.beans.Account;

public class AccountDAOImpl implements AccountDAO {
	private JdbcTemplate template;
	private SimpleJdbcInsert jdbcInsert;
	
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource);
	}
	
	@Override
	public void insertAccount(Account acc) throws Exception {
		String sql = "insert into accountw values(?,?,?,?,?)";
		Map<String, Object> params = new HashMap<>();
		params.put("id",acc.getId());
		params.put("name", acc.getName());
		params.put("balance", acc.getBalance());
		params.put("sect", acc.getSect());
		params.put("grade", acc.getGrade());
		jdbcInsert.execute(params);
//		template.update(sql, acc.getId(), acc.getName(), acc.getBalance(), acc.getSect(), acc.getGrade());
	}
	
	@Override
	public Account queryAccount(String id) throws Exception {
		String sql = "select * from accounts where id=?";
		Account acc = template.queryForObject(sql, new Object[] {id}, Account.class);
		return acc;
	}
	@Override
	public void updateAccBalance(String id, int money) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Account> queryAccounts() throws Exception {
		String sql = "select * from accountw";
		RowMapper<Account> mapper = new BeanPropertyRowMapper<Account>(Account.class);
		return template.query(sql, mapper);
	}
}
