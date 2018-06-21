package es.jmfg.springboot2.ejemplo.jdbch2.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.jmfg.springboot2.ejemplo.jdbch2.modelo.Turista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// ESta clase representa un repositorio utilizando solamente
// JDBC.
@Repository
public class TuristaRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Translada de registro a Objeto
    class TuristaRowMapper implements RowMapper<Turista> {
        @Override
        public Turista mapRow(ResultSet rs, int rowNum) throws SQLException {
            Turista turista = new Turista();
            turista.setId(rs.getLong("id"));
            turista.setNombre(rs.getString("nombre"));
            turista.setPasaporte(rs.getString("pasaporte"));
            return turista;
        }

    }

    // Demas operaciones ...
    public List<Turista> findAll() {
        return jdbcTemplate.query("select * from turista", new TuristaRowMapper());
    }

    public Turista findById(long id) {
        return jdbcTemplate.queryForObject("select * from turista where id=?", new Object[] { id },
                new BeanPropertyRowMapper<Turista>(Turista.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from turista where id=?", new Object[] { id });
    }

    public int insert(Turista turista) {
        return jdbcTemplate.update("insert into turista (id, nombre, pasaporte) " + "values(?,  ?, ?)",
                new Object[] { turista.getId(), turista.getNombre(), turista.getPasaporte() });
    }

    public int update(Turista turista) {
        return jdbcTemplate.update("update turista " + " set nombre = ?, pasaporte = ? " + " where id = ?",
                new Object[] { turista.getNombre(), turista.getPasaporte(), turista.getId() });
    }

}
