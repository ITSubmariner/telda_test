package ru.telda.repositories;

import org.apache.ibatis.annotations.*;
import ru.telda.signatures.Region;

import java.util.List;

@Mapper
public interface RegionMapper {

    @Select("select * from regions where id = #{id}")
    Region getRegion(@Param("id") Long id);

    @Select("select * from regions where name = #{name}")
    Region getRegionByName(@Param("name") String name);

    @Select("select * from regions")
    List<Region> getAll();

    @Insert("insert into regions (name, title) values(#{name}, #{title})")
    @SelectKey(statement = "call identity()", keyColumn = "id", keyProperty = "id", before = false, resultType = long.class)
    boolean addRegion(Region region);

    @Delete("delete from regions where id = #{id}")
    boolean deleteRegion(@Param("id") Long id);

    @Update("update regions set name = #{name}, title = #{title} where id = #{id}")
    boolean updateRegion(Region region);
}
