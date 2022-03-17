package org.javasm.supermarket.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commodity {

  private Integer id;
  private Integer prentId;
  private String typeName;
  private Integer prent;
  private Integer typeStatus;
  private java.util.Date createTime;
  private java.util.Date updateTime;

}
