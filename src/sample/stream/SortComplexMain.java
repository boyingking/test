package sample.stream;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author wangxl@ushareit.com  2020/12/29 20:25
 */
public class SortComplexMain {



/*    今天在项目中遇到个需求，按照对象中的三个属性进行排序。
    具体要求：
    前提：对象 Obj [a=a,b=b,c=c]
            1、 优先级为a > b > c
2、 a属性为中文，固定排序规则为：政府，合作，基金 … …
            3、 b的为BigDecimal类型，固定的排序规则为：降序排序
4、 c为java.util.Date类型，规则为：降序排序*/


    public static void main(String[] args) {
        Project project1 = new Project("政府", new BigDecimal(2318.9),new Date(2345,1,21));
        Project project2 = new Project("合作",new BigDecimal(114.3),new Date(2020,10,12));
        Project project21 = new Project("合作",new BigDecimal(112.3),new Date(2021,10,12));
        Project project3 = new Project("基金", new BigDecimal(3323.3), new Date(1999,3,23));

        List<Project> projectList = Arrays.asList(project1,project2,project3,project21);


        //Stream
        projectList.stream()
                .sorted(Comparator.comparing(Project::getType).thenComparing(Project::getPrice,Comparator.reverseOrder()).thenComparing(Project::getTime,Comparator.reverseOrder()))
                .forEach(System.out::println);

        //List
        projectList.sort(
            Comparator.comparing(Project::getType).thenComparing(Project::getPrice).thenComparing(Project::getTime)
        );

/*        //内部类
        projectList.sort(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return 0;
            }
        });

        //lamda
        projectList.sort((h1,h2)->{

        });

        //内部类
        Collections.sort(projectList, new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return 0;
            }
        });

        //lamda
        Collections.sort(projectList,(h1,h2)->{

        });*/
    }

}

class Project {
    String type;
    BigDecimal price;
    Date time;

    public Project(String type, BigDecimal price, Date time) {
        this.type = type;
        this.price = price;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return type + "-" +price.intValue()+"-"+time.getYear();
    }
}
