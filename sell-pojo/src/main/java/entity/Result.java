package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: eric
 * @Description:
 * @Date: 2018/9/14 09:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    private boolean success;
    private String message;

}
