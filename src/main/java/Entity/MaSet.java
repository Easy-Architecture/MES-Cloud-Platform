package Entity;

import java.io.Serializable;

/**
 * @author zhaohan
 * 解耦machine和stateFunction
 */

public class MaSet implements Serializable {

    private static final long serialVersionUID = 4663857772509461207L;

    private int m_id;

    private String m_name;

    private boolean learn;

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

