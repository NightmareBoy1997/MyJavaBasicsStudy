package org.javasm.supermarket.bean;

import lombok.Data;

@Data
public class OrderDetail {

  private Integer id;
  private Integer orderId;
  private Integer productId;
  private Integer buyNumber;

}
