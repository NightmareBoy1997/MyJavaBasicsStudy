package org.javasm.supermarket.bean;
import lombok.Data;

@Data
public class Product {

  private Integer id;
  private String productName;
  private Integer typeId;
  private Double productPrice;
  private Integer productStore;
  private String productImage;
  private boolean productStatus;
  private Double productDiscount;
  private java.util.Date createTime;
  private java.util.Date updateTime;

}
