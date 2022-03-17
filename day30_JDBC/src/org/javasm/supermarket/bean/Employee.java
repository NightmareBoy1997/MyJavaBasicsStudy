package org.javasm.supermarket.bean;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Employee {

  private Integer id;
  private String name;
  private String job;
  private Integer manager;
  private java.util.Date hireDate;
  private BigDecimal salary;
  private BigDecimal commission;
  private Integer departmentId;

}
