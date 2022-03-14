package comguigu.java;

/**
 * @author shkstart
 * @create 2021-04-30 10:49
 */
public class Employee implements Comparable<Employee>{

    private String name;
    private int age;
    private MyDate birthday;

    public Employee(){
    }
    public Employee(String name,int age,MyDate birthday){
        this.age=age;
        this.name=name;
        this.birthday=birthday;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String toString(){
        return "[ name: "+name+", age: "+age+",birthday: "+birthday+" ]";
    }


    public int compareTo(Employee e){

            int number=this.name.compareTo(e.name);

            if(number!=0){
                return number;
            }else{
                int number1=this.age-e.age;

                if(number1!=0){
                    return number1;
                }else{
                    return 0;
                }

            }


    }

}


class MyDate implements Comparable<MyDate>{
   private int year;
   private int month;
   private int day;

   public MyDate(){
   }

   public MyDate(int year, int month, int day) {
       this.year = year;
       this.month = month;
       this.day = day;
   }

   public int getYear() {
       return year;
   }

   public void setYear(int year) {
       this.year = year;
   }

   public int getMonth() {
       return month;
   }

   public void setMonth(int month) {
       this.month = month;
   }

   public int getDay() {
       return day;
   }

   public void setDay(int day) {
       this.day = day;
   }

   @Override
   public String toString() {
       return "MyDate{" +
               "year=" + year +
               ", month=" + month +
               ", day=" + day +
               '}';
   }

   public int compareTo(MyDate date){

           //比较年
           int numberYear =this.year - date.year;
           if (numberYear != 0) {
               return numberYear;
           } else {
               //比较月
               int numberMonth = this.month - date.month;
               if (numberMonth != 0) {
                   return numberMonth;
               } else {
                   //比较日
                   int numberDay = this.day - date.day;
                       return numberDay;
               }
           }

   }

}
