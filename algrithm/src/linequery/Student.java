package linequery;

/**
 * @author liyanan
 * @date 2022/04/09 18:48
 **/
public class Student implements Comparable<Student> {
    private String name;
    private Integer age;
    private Integer score;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, Integer age, Integer score) {
        this(name, age);
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Student)) {
            return false;
        }
        Student student = (Student) object;
        return this.getName().equals(student.getName()) && this.getAge().equals(student.getAge());
    }


    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getAge();
    }

    @Override
    public int compareTo(Student o) {
       /* if (this.score < o.getScore()) {
            return -1;
        } else if (this.score.equals(o.getScore())) {
            return 0;
        } else {
            return 1;
        }*/
        return this.score - o.getScore();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
