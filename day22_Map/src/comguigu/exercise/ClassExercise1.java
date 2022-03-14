package comguigu.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-24 12:11
 */
public class ClassExercise1 {


    //    按要求实现下列问题：
    // 1)封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；（10分）
    // 2)只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
    //   新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
    //   新闻二：春节临近北京“卖房热”
    //
    // 3)将新闻对象添加到ArrayList集合中，并且使用ListIterator倒序遍历；
    // 4)在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前14个，然后在后边加“…”
    // 5)在控制台打印遍历出经过处理的新闻标题；
    @Test
    public void test1(){
        News news1  = new News("新闻一：中国多地遭雾霾笼罩空气质量再成热议话题" , "");
        News news2 = new News("新闻二：春节临近北京“卖房热”" , "");
        News news3  = new News("新闻三：乌克兰多个城市发生爆炸 有居民称听到了炮声" , "");
        News news4 = new News("新闻四：丰县女子生育八孩" , "");
        News news5 = new News("新闻五：被问“是否低估了普京” 拜登沉默十多秒后尬笑抠嘴" , "");

        ArrayList<News> arrayList = new ArrayList(10);
        arrayList.add(news1);
        arrayList.add(news2);
        arrayList.add(news3);
        arrayList.add(news4);
        arrayList.add(news5);
        arrayList.add(news2);

        // 需要 循环 或 正序遍历 将指针移到最后位置
        ListIterator<News> listIterator = arrayList.listIterator();
        while(listIterator.hasNext()){
            News news = listIterator.next();
            System.out.println(news);
        }

        System.out.println("*****************");

        // 倒序遍历
        while(listIterator.hasPrevious()){
            News news =  listIterator.previous();
            if(news.getHeadline().length() > 15){

                String str = news.getHeadline().substring(0,14);
                String newStr = str.concat("...");
                news.setHeadline(newStr);
            }
            System.out.println(news);
        }
    }


    // 定义一个Map接口类型的变量，引用一个实现类，添加键值对，判断集合中是否包含某一key值，
    // 通过某一key值得到value值，通过某一key删除键值对，把另一个map集合添加到此map集合，
    // 判断是否为空，清除集合，返回集合里元素的个数等常用操作。 通过两种方法遍历上题中的map集合
    @Test
    public void test2(){

        HashMap hashMap1 = new HashMap();

        hashMap1.put("java",11);
        hashMap1.put(true,22);
        hashMap1.put("新闻",new News("乌克兰多个城市发生爆炸",null));
        hashMap1.put(null,null);
        hashMap1.put(15,15.99);
        hashMap1.put("序号3",false);
        hashMap1.put('y',false);
        hashMap1.put(12.55,"java好难");

        int number  = hashMap1.size();
        System.out.println(number);

        System.out.println(hashMap1);

        boolean isKey = hashMap1.containsKey("序号1");
        System.out.println(isKey);
        boolean isValue = hashMap1.containsValue(false);
        System.out.println(isValue);

        Object keyValue = hashMap1.get("序号2");
        System.out.println(keyValue);

        Object removeValue = hashMap1.remove(15);
        System.out.println(removeValue);

        System.out.println(hashMap1);

        Object removeValue1 = hashMap1.remove('y',true);
        System.out.println(removeValue1);
//        System.out.println(removeValue1);

        HashMap hashMap2 = new HashMap();

        hashMap2.put("序号1",120);
        hashMap2.put(true,"java");
        hashMap2.put(15,15.99);
        hashMap2.put("序号3",false);
        hashMap2.put('y',false);
        hashMap2.put(12.55,"java好难");
        hashMap2.put("序号2",1997);

        hashMap1.putAll(hashMap2);
        number = hashMap1.size();
        System.out.println(number);

//        hashMap1.clear();
//        boolean empty = hashMap1.isEmpty();
//        System.out.println(empty);

        Set entrySet = hashMap1.entrySet();
        // iterator遍历
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // 增强for循环
        for (Object o : entrySet) {
            System.out.println(o);
        }

    }


    // 使用Map接口的实现类完成员工工资(姓名--工资)的摸拟：
    // 1)添加几条信息
    // 2)列出所有的员工姓名
    // 3)列出所有员工姓名及其工资
    // 4)删除名叫“Tom”的员工信息
    // 5)输出Jack的工资，并将其工资加1000元(通过取值实现)
    // 6)将所有工资低于1000元的员工的工资上涨20%(通过取值实现)
    @Test
    public void test3(){
        HashMap hashMap = new HashMap(16);

        hashMap.put("Tom",999.99);
        hashMap.put("Jack",299);
        hashMap.put("Ali",830);
        hashMap.put("shou",1799.9);
        hashMap.put("xbei",640.2);
        hashMap.put("lighst",400.7);

        Set keySet = hashMap.keySet();
        Iterator keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            Object obj = keyIterator.next();
            System.out.println(obj + " -- " + hashMap.get(obj) );
        }

        Object removeValue = hashMap.remove("Tom");
        System.out.println(removeValue);

        Iterator keyIterator1 = keySet.iterator();
        while(keyIterator1.hasNext()){
            Object obj = keyIterator1.next();
            double salary = Double.parseDouble(hashMap.get(obj).toString()) ;

            if(obj.equals("Jack")){
                double newSalary = salary +1000;
                hashMap.put(obj,newSalary);
            }else if( salary  < 1000){
                double newSalary = salary * (1+0.2);
                hashMap.put(obj,newSalary);
            }

            System.out.println(obj + " -- " + hashMap.get(obj));
        }

    }


    // 创建有序的map集合的实例化对象，添加元素，查看排序结果
    @Test
    public void test4(){

        LinkedHashMap linkedHashMap = new LinkedHashMap(16);

        linkedHashMap.put(1001,"王康");
        linkedHashMap.put("Tom",999.99);
        linkedHashMap.put("Jack",299);
        linkedHashMap.put("Ali",830);
        linkedHashMap.put("shou",1799.9);
        linkedHashMap.put("xbei",640.2);
        linkedHashMap.put("lighst",400.7);

        for(Object obj : linkedHashMap.keySet()){
            System.out.println(obj + " --- " + linkedHashMap.get(obj));
        }
    }


    // 封装一个新闻类，包含标题、作者、新闻内容和发布时间，新闻标题如下：
    // 新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
    // 新闻二：民进党台北举行“火大游行”
    // 新闻三：春节临近北京“卖房热”
    // 新闻四：春节临近北京“卖房热”
    // 完成如下要求（共50分，每小题10分）：
    //   1）完成对新闻类的设计，要求在初始化新闻类对象时 ，通过构造传参的形式对新闻标题赋值，并要求实例化四个对象，标题内容如题。
    //   2）要求打印新闻对象时，直接打印新闻标题；
    //   3）要求使用equals方法比较新闻时，只要标题相同，就认为是同一新闻，请输出新闻一与新闻二的比较结果，新闻三与新闻四的比较结果。
    //   4）将新闻对象存入HashSet集合中，并且遍历集合，打印新闻类对象；
    //   5）打印集合中新闻数量。
    @Test
    public void test5(){

        News1 news1 = new News1(" 中国多地遭雾霾笼罩空气质量再成热议话题","","","2022-02-24 03:47:09");
        News1 news2 = new News1(" 民进党台北举行“火大游行”","","","2022-2-24 15:41:22");
        News1 news3 = new News1(" 春节临近北京“卖房热”","","","2022-02-24 03:47:09");
        News1 news4 = new News1(" 春节临近北京“卖房热”","","","2022-2-24 15:41:22");

        HashSet newsSet = new HashSet();
        newsSet.add(news1);
        newsSet.add(news2);
        newsSet.add(news3);
        newsSet.add(news4);

        System.out.println(newsSet);
        Iterator iterator = newsSet.iterator();
        while(iterator.hasNext()){
            News1 news = (News1)iterator.next();
            System.out.println(news + "  ---  " + news.getDate() );
        }
    }


    //    创建一个List集合的对象，添加几个数字，反转对象中元素的顺序；根据元素的自然顺序排序；
    @Test
    public void test6(){

        List<Integer> list = new ArrayList(16);
        list.add(23);
        list.add(-3);
        list.add(16);
        list.add(51);
        list.add(77);
        list.add(13);
        list.add(6);
        list.add(17);
        list.add(73);
        list.add(89);
        list.add(19);

        for (int i = 0; i <= list.size()/2 - 1 ; i++) {
            int temp = list.get(i);
            list.set(i , list.get(list.size() - 1 - i)) ;
            list.set(list.size()-1 - i , temp);
        }
        System.out.println(list);

        list.sort(Integer :: compare);
        System.out.println(list);
    }


    //    创建一个List集合的对象，添加几个字符串，反转对象中元素的顺序；根据元素的自然顺序排序；
    //    创建一个List集合的对象，添加几条数据，将1号位和2号位交换；获得最大值，最小值，
    @Test
    public void test7(){

        List<String> list = new ArrayList(10);
        list.add("animal");
        list.add("bast");
        list.add("car");
        list.add("double");
        list.add("equals");
        list.add("false");
        list.add("group");
        list.add("having");
        list.add("java");

        String tempStr = list.get(1);
        list.set(1,list.get(2));
        list.set(2,tempStr);
        System.out.println(list);

        for (int i = 0; i <= list.size()/2 - 1 ; i++) {
            String temp = list.get(i);
            list.set(i , list.get(list.size() - 1 - i)) ;
            list.set(list.size()-1 - i , temp);
        }
        System.out.println(list);

        // 自然排序
        list.sort(String :: compareTo);
        System.out.println(list);
    }


    /*

            按要求完成如下操作
1.	生成10个随机数，值在100到200之间；
            2.	将这十个数存入HashSet集合中（有可能集合的长度小于10）。
            3.	将这个HashSet集合转换成ArrayList集合
4.	重新为ArrayList集合排序，按照从小到大的顺序；
            5.	使用foreach遍历集合；

    按要求完成如下操作
1 ）封装一个汽车类，包含String  name、int  speed属性，在测试类中实例化三个对象：c1，c2，c3，分别设置name为：“奥拓”，“宝马”，“奔驰”，速度分别设置为：100,200,300
            2 ）使用Map集合对象m1将这三个汽车类对象保存成key，然后将int型的汽车价钱作为值保存在m1的value中，上述三款汽车分别对应的价钱是10000,500000,2000000
            3 ）遍历m1的键，打印name属性
4 ）通过合适的方法，求出m1中“宝马”的价格，并打印结果；
            5 ）经过折旧，所有汽车都降价到原来的80%，请打印降价后“宝马”的价格




*/


/*
    按要求完成如下操作
    1 ） 要求集合对象c1中，只能添加字符串形式的单个元素，元素可以重复，在测试类中为c1集合添加字符串
    “这是一个可以重复的集合”三遍，然后遍历打印结果。
    2 ）要求集合对象c2中只能添加整型数值，并且不可重复，按自然顺序排序。要求遍历集合对象，
    打印添加进1,2,3,4,5五个数字的c2集合

    3 ）要求创建一个合适的Map集合对象m1，它的键和值都只能是字符串，并且值可以是null，
    像map集合中添加三组字符串，其中一个只有键，值是空，遍历这个集合对象的键，并打印键。
    4）想办法将m1中所有值为null都替换成一个字符串”这里是空值”
    5）遍历m1的所有值。*/
    @Test
    public void test8(){
        HashMap<String,String> hashMap1 = new HashMap(16);

        hashMap1.put("myl",null);
        hashMap1.put("shou","王康");
        hashMap1.put("xbei","涂占亚");

        Set<String> keySet = hashMap1.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str + " --- " + hashMap1.get(str) );

            if(hashMap1.get(str) == null){
                hashMap1.put(str,"这是一个空值");
            }

            System.out.println(str  + " --- " + hashMap1.get(str) );

        }


    }



}



@Data
@AllArgsConstructor
class News{

    private String headline ;
    private String content ;

    public String toString(){
        return headline;
    }

}


@Data
@AllArgsConstructor
class News1{

    private String headline;
    private String author;
    private String content;
    private String date;
    public News1(String headline , String author , String content , LocalDate localDate){
        this.headline = headline;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {

        return "headline= " + headline + " " ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News1 news1 = (News1) o;

        return headline != null ? headline.equals(news1.headline) : news1.headline == null;
    }

    @Override
    public int hashCode() {
        return headline != null ? headline.hashCode() : 0;
    }


}