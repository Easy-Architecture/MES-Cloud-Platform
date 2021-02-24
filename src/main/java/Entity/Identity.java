package Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author zhaohan
 *注册机器的信息
 */

@Getter
@Setter
public class Identity implements Serializable {

    private static final long serialVersionUID = -2956879259787309152L;

    /**
     * 机器id
     */
    private Integer e_id;

    /**
     * 唯一身份认证
     */
    private Integer identity;

    /**
     * 厂商联系电话
     */
    private String manufacturerPhone;

}

