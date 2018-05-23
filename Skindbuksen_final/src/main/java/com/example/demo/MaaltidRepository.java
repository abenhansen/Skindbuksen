package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Repository til at hentte Maaltider fra databasen
@Repository
public class MaaltidRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class MaaltidMapper implements RowMapper<Maaltid> {
        @Override
        public Maaltid mapRow(ResultSet rs, int rowNum) throws SQLException {
            Maaltid maaltid = new Maaltid();
            maaltid.setId(rs.getInt("id"));
            maaltid.setNavn(rs.getString("navn"));
            maaltid.setPris(rs.getInt("pris"));
            return maaltid;
        }
    }

    public List<Maaltid> findAll() {
        return jdbcTemplate.query("select * from menukort", new MaaltidMapper());
    }

    public Maaltid findById(int id) {
        return jdbcTemplate.queryForObject("select * from menukort where id=?", new Object[] { id },
                new BeanPropertyRowMapper<Maaltid>(Maaltid.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from menukort where id=?", new Object[] { id });
    }


    public int insert(Maaltid maaltid) {
        return jdbcTemplate.update("insert into maaltid (id, navn, price) " + "values(?, ?, ?)",
                new Object[] { maaltid.getId(), maaltid.getNavn(), maaltid.getPris()});
    }

    public int update(Maaltid maaltid) {
        return jdbcTemplate.update("update menukort set id = ?, navn = ?, pris = ? where id = ?",
                new Object[] { maaltid.getId(),maaltid.getNavn(), maaltid.getPris()});
    }

}
