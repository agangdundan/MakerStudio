package cn.it.phw.ms.common;

import java.io.Serializable;

/**
 *
 */
public class BaseEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long create_time;

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getCreate_time() {
        return create_time;
    }
}
