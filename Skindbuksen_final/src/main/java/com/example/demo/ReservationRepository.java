package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<Reservation> {
        @Override
        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reservation reservation = new Reservation();
            reservation.setReservationID(rs.getInt("reservationID"));
            reservation.setBordNr(rs.getInt("bord_nr"));
            reservation.setAntal(rs.getInt("antal"));
            reservation.setTidspunkt(rs.getString("tidspunkt"));
            reservation.setDato(rs.getDate("dato"));
            reservation.setFornavn(rs.getString("fornavn"));
            reservation.setEfternavn(rs.getString("efternavn"));
            return reservation;
        }
    }

    public List<Reservation> findAll() {
        return jdbcTemplate.query("select * from reservationer", new ReservationRepository.UserRowMapper());
    }


    public Reservation findById(int id) {
        return jdbcTemplate.queryForObject("select * from reservationer where reservationID=?", new Object[] { id },
                new BeanPropertyRowMapper<Reservation>(Reservation.class));
    }


    public int deleteById(int id) {
        return jdbcTemplate.update("delete from reservationer where reservationID=?", new Object[] { id });
    }


    public int insert(Reservation reservation) {
        return jdbcTemplate.update("insert into reservationer (bord_nr, antal, tidspunkt, dato, fornavn, efternavn) " + "values(?, ?, ?, ?, ?, ?)",
                new Object[] { reservation.getBordNr(), reservation.getAntal(), reservation.getTidspunkt(), reservation.getDato(), reservation.getFornavn(), reservation.getEfternavn() });
    }

    public int update(Reservation reservation) {
        return jdbcTemplate.update("update reservationer set bord_nr = ?, antal = ?, tidspunkt = ?, dato = ?, fornavn = ?, efternavn= ? where reservationID = ?",
                new Object[] { reservation.getBordNr(),reservation.getAntal(), reservation.getTidspunkt(), reservation.getDato(), reservation.getFornavn(), reservation.getEfternavn(), reservation.getReservationID() });
    }

}
