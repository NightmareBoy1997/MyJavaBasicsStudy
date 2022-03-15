package exercise.classlast.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  private Integer id;
  private String title;
  private String author;
  private double price;
  private Integer sales;
  private Integer stock;
  private String imgPath;

}
