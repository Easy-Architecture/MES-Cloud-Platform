package Entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author zhaohan
 * 流水线
 */

@Component
public class AssemblyLine implements Serializable {

    private static final long serialVersionUID = 7011469592514648556L;

    private String lineName;

    private ArrayList<String> lineMode;

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public ArrayList<String> getLineMode() {
        return lineMode;
    }

    public void setLineMode(ArrayList<String> lineMode) {
        this.lineMode = lineMode;
    }

}

