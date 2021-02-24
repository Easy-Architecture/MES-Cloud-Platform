package Entity;

import java.io.Serializable;

/**
 * @author zhaohan
 * 商品销售属性
 */

public class CommodityAttributes implements Serializable {

    private static final long serialVersionUID = 3290614051092242511L;

    /**
     * 酒水种类
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 瓶子容量
     */
    private short capacity;
    /**
     *个数
     */
    private int num;
    /**
     * 酒水总量
     */
    private long total;

}

