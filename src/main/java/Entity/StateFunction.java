package Entity;

import java.io.Serializable;

/**
 * @author zhaohan
 * 机器操作函数
 */

public class StateFunction implements Serializable {

    private static final long serialVersionUID = -3823268291511505620L;

    private int state;

    private String function;

    private int stateNum;

    private int m_id;

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getStateNum() {
        return stateNum;
    }

    public void setStateNum(int stateNum) {
        this.stateNum = stateNum;
    }

}

