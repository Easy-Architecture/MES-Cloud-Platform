package com.easy.cloundmes.machinelogin;

import Entity.MaSet;
import Entity.Machine;
import Entity.StateFunction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author zhaohan
 */

@Component
public interface MachineMapper {

    @Insert(value = "INSERT INTO machine (m_id,m_name,learn) VALUES (#{machine.m_id},#{machine.m_name},#{machine.learn})")
    int insertMachine(@Param(value = "machine") Machine machine);

    @Insert(value = "INSERT INTO s_function (s_id,state,state_num,fun) VALUES (#{machine.m_id},#{machine.state},#{machine.stateNum},#{machine.function})")
    int insertFunction(@Param(value = "machine") StateFunction machine);

    @Select(value = "SELECT * FROM machine WHERE m_id=#{m_id}")
    MaSet findByM_id(@Param("m_id") int m_id);

    @Select(value = "SELECT * FROM s_function WHERE s_id=#{m_id}")
    StateFunction findStateByM_id(@Param("m_id") int m_id);

    @Delete(value = "DELETE FROM machine WHERE m_id=#{m_id}")
    void deleteBym_id(@Param("m_id") int m_id);

}

