package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//Repository til bruger databasen
@Repository
public class BrugerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //Brugt til at sætte data fra databasen ind i bruger objektet
    class UserRowMapper implements RowMapper<Bruger> {
        @Override
        public Bruger mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bruger bruger = new Bruger();
            bruger.setId(rs.getLong("id"));
            bruger.setUsername(rs.getString("username"));
            bruger.setPassword(rs.getString("password"));
            bruger.setRoles(rs.getString("roles"));
            bruger.setEnabled(rs.getBoolean("enabled"));
            return bruger;
        }
    }
        //Henter alle brugere fra databasen
        public List<Bruger> findAll() {
            return jdbcTemplate.query("select * from users", new UserRowMapper());
        }
    //finder en bruger via ID i databasen
    public Bruger findById(long id) {
        return jdbcTemplate.queryForObject("select * from users where id=?", new Object[] { id },
                new BeanPropertyRowMapper<Bruger>(Bruger.class));
    }
    //sletter en bruger via ID
    public int deleteById(long id) {
        return jdbcTemplate.update("delete from users where id=?", new Object[] { id });
    }

    //Tilføjer bruger til databasen
        public int insert(Bruger bruger) {
            return jdbcTemplate.update("insert into users (username, password, role) " + "values(?, ?, ?)",
                    new Object[] { bruger.getUsername(), bruger.getPassword(), bruger.getRoles() });
        }
    //opdaterer en bruger i databasen
    public int update(Bruger bruger) {
        return jdbcTemplate.update("update users set role = ?, password = ?, username = ? where id = ?",
                new Object[] { bruger.isEnabled(), bruger.getRoles(), bruger.getPassword(), bruger.getUsername(), bruger.getId() });
    }



}