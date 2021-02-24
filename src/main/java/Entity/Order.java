package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhaohan
 * 用户订的订单的类
 */

public class Order implements Serializable {

    private static final long serialVersionUID = 5251605847558162389L;

    /**
     * 商品名称(需要)
     */
    private String c_Name;
    /**
     * 订单id(需要)
     */
    private int o_id;
    /**
     * 创建时间
     */
    private Date c_time;
    /**
     * 用户名称(需要)
     */
    private String u_name;
    /**
     * 总额(需要)
     */
    private int t_amount;
    /**
     * 订单状态(需要)
     */
    private int state;
    /**
     * 配送方式(需要)
     */
    private String d_method;
    /**
     * 收货人姓名(需要)
     */
    private String r_name;

    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    /**
     * 收货人电话(需要)
     */
    private String r_phone;
    /**
     * 支付时间
     */
    private Date p_time;
    /**
     * 发货时间
     */
    private Date d_time;
    /**
     * 确认收货时间
     */
    private Date r_time;
    /**
     * 订单备注(需要)
     */
    private String remark;
    /**
     * 客服电话
     */
    private String cs_phone;
    /**
     * 规格
     */
    private int specifications;
    /**
     * 运输地址
     */
    private String address;
    /**
     * 商品销售属性组合(json)
     */
    private String s_vals;

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public Date getC_time() {
        return c_time;
    }

    public void setC_time(Date c_time) {
        this.c_time = c_time;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public int getT_amount() {
        return t_amount;
    }

    public void setT_amount(int t_amount) {
        this.t_amount = t_amount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getD_method() {
        return d_method;
    }

    public void setD_method(String d_method) {
        this.d_method = d_method;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_phone() {
        return r_phone;
    }

    public void setR_phone(String r_phone) {
        this.r_phone = r_phone;
    }

    public Date getP_time() {
        return p_time;
    }

    public void setP_time(Date p_time) {
        this.p_time = p_time;
    }

    public Date getD_time() {
        return d_time;
    }

    public void setD_time(Date d_time) {
        this.d_time = d_time;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getS_vals() {
        return s_vals;
    }

    public void setS_vals(String s_vals) {
        this.s_vals = s_vals;
    }

}

