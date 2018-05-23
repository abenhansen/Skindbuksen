package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Repository
public class BestillingRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<Bestilling> {
        @Override
        public Bestilling mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bestilling bestilling = new Bestilling();
            bestilling.setId(rs.getInt("id"));
            bestilling.setRetter(rs.getString("retter"));
            bestilling.setTotalpris(rs.getInt("totalpris"));
            bestilling.setBord(rs.getInt("bord"));
            return bestilling;
        }
    }

    public List<Bestilling> findAll() {
        return jdbcTemplate.query("select * from bestillinger", new UserRowMapper());
    }

    public Bestilling findById(long id) {
        return jdbcTemplate.queryForObject("select * from bestillinger where id=?", new Object[] { id },
                new BeanPropertyRowMapper<Bestilling>(Bestilling.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from bestillinger where id=?", new Object[] { id });
    }


    public int insert(Bestilling bestilling) {
        return jdbcTemplate.update("insert into bestillinger (retter, totalpris, bord) " + "values(?, ?, ?)",
                new Object[] { bestilling.getRetter(), bestilling.getTotalpris(), bestilling.getBord()});
    }

    public int update(Bestilling bestilling) {
        return jdbcTemplate.update("update bestillinger set retter = ?, totalpris = ?, bord = ? where id = ?",
                new Object[] { bestilling.getRetter(),bestilling.getTotalpris(), bestilling.getBord(), bestilling.getId() });
    }


}