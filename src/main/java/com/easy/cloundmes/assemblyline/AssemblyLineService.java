package com.easy.cloundmes.assemblyline;

import Entity.AssemblyLine;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author zhaohan
 * 流水线业务类
 */

@Service
public class AssemblyLineService {

    @Autowired
    private AssemblyLineMapper assemblyLineMapper;

    private AssemblyLine assemblyLine=new AssemblyLine();

    public String searchLine(String linename){

        ArrayList<String> arr=assemblyLineMapper.findLineByName(linename);

        assemblyLine.setLineMode(arr);
        assemblyLine.setLineName(linename);

        String json=(String)JSON.toJSON(assemblyLine);
        return json;

    }

    public boolean insertLine(AssemblyLine assemblyLine){

        boolean state=false;

        ArrayList<String> arr=assemblyLineMapper.findLineByName(assemblyLine.getLineName());
        if (arr.size()==0) {

            ArrayList<String> arrayList = assemblyLine.getLineMode();
            for (String str : arrayList) {

                assemblyLineMapper.insertLine(assemblyLine, str);

            }
            state=true;
        }

        return state;

    }

    public boolean updateLine(String m_name,String name,String linename){

        boolean tee=false;

        ArrayList<String> aee=assemblyLineMapper.findLineByName(linename);
        if (aee.size()==0&&aee.contains(name)){
            return tee;
        }else {
            assemblyLineMapper.updateLine(m_name,name);
            tee=true;
            return tee;
        }

    }

    public boolean deleteLine(String linename){

        boolean b=false;

        if (assemblyLineMapper.findLineByName(linename).size()==0){
            return b;
        }else {
            assemblyLineMapper.deleteLine(linename);
            b=true;
            return b;
        }

    }

    public boolean deleteMachine(String m_name){

        boolean a=false;

        if (assemblyLineMapper.findLineByM_name(m_name)==null){
            return a;
        }else {

            assemblyLineMapper.deleteLineMachine(m_name);
            a=true;
            return a;

        }

    }

}

