package org.javasm.supermarket.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {

  private Integer id;
  private Integer prentId;
  private String typeName;
  private boolean prent;
  private boolean typeStatus;
  private java.util.Date createTime;
  private java.util.Date updateTime;

}
