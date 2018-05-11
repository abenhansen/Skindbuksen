package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class BrugerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<Bruger> {
        @Override
        public Bruger mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bruger bruger = new Bruger();
            bruger.setBrugerID(rs.getLong("user_role_id"));
            bruger.setUsername(rs.getString("username"));
            bruger.setPassword(rs.getString("password"));
            bruger.setRoles(rs.getString("role"));
            bruger.setEnabled(rs.getBoolean("enabled"));
            return bruger;
        }
    }

        public List<Bruger> findAll() {
            return jdbcTemplate.query("select * from users", new UserRowMapper());
        }

    public Bruger findById(long id) {
        return jdbcTemplate.queryForObject("select * from users where user_role_id=?", new Object[] { id },
                new BeanPropertyRowMapper<Bruger>(Bruger.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from users where user_role_id=?", new Object[] { id });
    }


        public int insert(Bruger bruger) {
            return jdbcTemplate.update("insert into users (username, password, role) " + "values(?, ?, ?)",
                    new Object[] { bruger.getUsername(), bruger.getPassword(), bruger.getRoles() });
        }

    public int update(Bruger bruger) {
        return jdbcTemplate.update("update users set role = ?, password = ?, username = ? where user_role_id = ?",
                new Object[] { bruger.isEnabled(), bruger.getRoles(), bruger.getPassword(), bruger.getUsername(), bruger.getBrugerID() });
    }



}