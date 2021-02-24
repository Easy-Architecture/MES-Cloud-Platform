package Entity;

import org.springframework.stereotype.Component;

/**
 * @author zhaohan
 * 注册机器时的函数
 */

@Component
public class MachineFunction {

    /**
     * 当前机器状态
     */
    private String state;
    /**
     * 修正状态
     */
    private String newState;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

}

