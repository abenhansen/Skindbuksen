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
public class ReservationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<Reservation> {
        @Override
        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reservation reservation = new Reservation();
            reservation.setReservationID(rs.getLong("reservation_id"));
            reservation.setBordNr(rs.getInt("bord_nr"));
            reservation.setAntal(rs.getInt("antal"));
            reservation.setTidspunkt(rs.getString("tidspunkt"));
            reservation.setDato(rs.getDate("dato"));
            reservation.setFornavn(rs.getString("kunde_fornavn"));
            reservation.setEfternavn(rs.getString("kunde_efternavn"));
            return reservation;
        }
    }

    public List<Reservation> findAll() {
        return jdbcTemplate.query("select * from reservationer", new ReservationRepository.UserRowMapper());
    }

    public Reservation findById(long id) {
        return jdbcTemplate.queryForObject("select * from reservationer where reservation_id=?", new Object[] { id },
                new BeanPropertyRowMapper<Reservation>(Reservation.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from reservationer where reservation_id=?", new Object[] { id });
    }


    public int insert(Reservation reservation) {
        return jdbcTemplate.update("insert into reservationer (bord_nr, antal, tidspunkt, dato, kunde_fornavn, kunde_efternavn) " + "values(?, ?, ?, ?, ?, ?)",
                new Object[] { reservation.getBordNr(), reservation.getAntal(), reservation.getTidspunkt(), reservation.getDato(), reservation.getFornavn(), reservation.getEfternavn() });
    }

    public int update(Reservation reservation) {
        return jdbcTemplate.update("update reservationer set bord_nr = ?, antal = ?, tidspunkt = ?, dato = ?, kunde_fornavn = ?, kunde_efternavn= ? where reservation_id = ?",
                new Object[] { reservation.getBordNr(),reservation.getAntal(), reservation.getTidspunkt(), reservation.getDato(), reservation.getFornavn(), reservation.getEfternavn(), reservation.getReservationID() });
    }

}
