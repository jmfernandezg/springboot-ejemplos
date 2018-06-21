package es.jmfg.springboot2.ejemplo.mybatish2.repo;

import es.jmfg.springboot2.ejemplo.mybatish2.modelo.Turista;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Este es un repo al estilo mybatis
@Mapper
public interface TuristaRepo {
    @Select("select * from turista")
    List<Turista> findAll();

    @Select("SELECT * FROM turista WHERE id = #{id}")
    Turista findById(long id);

    @Delete("DELETE FROM turista WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO turista(id, nombre, pasaporte) VALUES (#{id}, #{nombre}, #{pasaporte})")
    int insert(Turista turista);

    @Update("Update turista set nombre=#{nombre}, pasaporte=#{pasaporte} where id=#{id}")
    int update(Turista turista);

}
