package com.easy.cloundmes.assemblyline;

import Entity.AssemblyLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaohan
 */

public class AssemblyLineController {

    @Autowired
    private AssemblyLineService assemblyLineService;

    @RequestMapping(value = "/assemblyLinelogin",method = RequestMethod.POST)
    @ResponseBody
    public String assemblyLineLogin(@RequestBody AssemblyLine assemblyLine){

        if (assemblyLineService.insertLine(assemblyLine)){
            String state="注册成功";
            return state;
        }else {
            String state="注册失败";
            return state;
        }

    }

    @RequestMapping(value = "/assemblyLineSearch",method = RequestMethod.POST)
    @ResponseBody
    public String assemblyLineSearch(@RequestBody String linename){

        String json=assemblyLineService.searchLine(linename);
        return json;

    }

    @RequestMapping(value = "/assemblyLineUpdate",method = RequestMethod.POST)
    @ResponseBody
    public String assemblyLineUpdate(@RequestBody String m_name,String name,String linename){

        boolean tate=assemblyLineService.updateLine(m_name,name,linename);
        if (tate){
            String json="修改成功";
            return json;
        }else {
            String json="修改失败";
            return json;
        }

    }

    @RequestMapping(value = "/deleteLine",method = RequestMethod.POST)
    @ResponseBody
    public String deleteLine(@RequestBody String linename){

        boolean tate=assemblyLineService.deleteLine(linename);
        if (tate){
            String json="删除成功";
            return json;
        }else {
            String json="删除失败";
            return json;
        }

    }

    @RequestMapping(value = "/deleteLineMachine",method = RequestMethod.POST)
    @ResponseBody
    public String deleteLineMachine(@RequestBody String m_name){

        boolean tate=assemblyLineService.deleteMachine(m_name);
        if (tate){
            String json="删除成功";
            return json;
        }else {
            String json="删除失败";
            return json;
        }

    }

}

