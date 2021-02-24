package Entity;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author zhaohan
 * 机器
 */

public class Machine implements Serializable {

    private static final long serialVersionUID = -7760461038519255026L;

    private int m_id;

    private String m_name;

    private boolean learn;

    private LinkedList<StateFunction> state;

    public LinkedList<StateFunction> getState() {
        return state;
    }

    public void setState(LinkedList<StateFunction> state) {
        this.state = state;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public boolean isLearn() {
        return learn;
    }

    public void setLearn(boolean learn) {
        this.learn = learn;
    }

}

