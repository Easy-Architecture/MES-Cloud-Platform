package Entity;

/**
 * @author zhaohan
 * 瓶子任务
 */

public class Bottle {

    public Bottle(int o_id,short capacity,int num){

        this.capacity=capacity;
        this.num=num;
        this.o_id=o_id;

    }

    /**
     * 任务订单号
     */
    private int o_id;
    /**
     * 瓶子容量
     */
    private short capacity;
    /**
     * 瓶子数量
     */
    private int num;

}
