package org.javasm.supermarket.bean;
import lombok.Data;

@Data
public class Product {

  private Integer id;
  private String productName;
  private Integer typeId;
  private double productPrice;
  private Integer productStore;
  private String productImage;
  private boolean productStatus;
  private Integer productDiscount;
  private java.util.Date createTime;
  private java.util.Date updateTime;

}
