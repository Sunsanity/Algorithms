package SortingBasic.SelectionSortUsingComparable;

/**
 * Created by SJW on 2017/7/8.
 */
public class Student implements Comparable<Student>{

    private String name;
    private int scroe;

    public Student(String name, int scroe) {
        this.name = name;
        this.scroe = scroe;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scroe=" + scroe +
                '}';
    }

    /**
     * 学生类比较方法，先比较分数，如果相同按照名字字母顺序排序
     * 不相等的话分数高的排在前面
     * @return
     */
    @Override
    public int compareTo(Student that) {
        if (this.scroe == that.scroe){
            return this.name.compareTo(that.name);
        }
        if (this.scroe > that.scroe){
            return -1;
        }else if (this.scroe < that.scroe){
            return 1;
        }
        return 0;
    }
}
