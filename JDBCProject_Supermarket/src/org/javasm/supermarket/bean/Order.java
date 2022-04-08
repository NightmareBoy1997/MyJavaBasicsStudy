package org.javasm.supermarket.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
    private Integer mid;
    private BigDecimal totalMoney;
    private String payType;
    private java.util.Date payTime;

    public void setPayType(int payType1) {
        if (payType1 == 1) {
            payType = "现金";
        } else {
            payType = "余额";
        }
    }


}
