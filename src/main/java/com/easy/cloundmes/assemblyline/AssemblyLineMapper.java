package com.easy.cloundmes.assemblyline;

import Entity.AssemblyLine;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author zhaohan
 */

@Component
public interface AssemblyLineMapper {

    @Insert(value = "INSERT INTO assemblyline (linename,m_name) VALUES (#{assemblyLine.linename},#{m_name})")
    int insertLine(@Param("assemblyLine") AssemblyLine assemblyLine,@Param("m_name") String m_name);

    @Select(value = "SELECT m_name FROM assemblyline WHERE linename=#{linename}")
    ArrayList<String> findLineByName(@Param("linename") String linename);

    @Delete(value = "DELETE FROM assemblyline WHERE linename=#{linename}")
    int deleteLine(@Param("linename") String linename);

    @Update(value = "UPDATE assemblyline SET m_name=#{m_name} WHERE m_name=#{name}")
    int updateLine(@Param("m_name") String m_name,@Param("name") String name);

    @Delete(value = "DELETE FROM assemblyline WHERE m_name=#{m_name}")
    int deleteLineMachine(@Param("m_name") String m_name);

    @Select(value = "SELECT m_name FROM assemblyline WHERE m_name=#{m_name}")
    String findLineByM_name(@Param("m_name") String m_name);

}

