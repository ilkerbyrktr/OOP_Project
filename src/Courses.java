import java.util.ArrayList;

public class Courses {
    private int courseCode;
    private String courseName;
    private int credit;
    private int courseLocation;
    private int courseGrade;
    private int  lecId ;
    private String lecName ;
    private ArrayList<Integer> stdIds = new ArrayList<Integer>();


    Courses(int courseCode,String courseName,int credit){
        setCourseCode(courseCode);
        setCourseName(courseName);
        setCredit(credit);


    }

    public void courseInfo(){
        System.out.println(courseCode +" "+courseName+" "+credit);
        System.out.println(lecId+" "+lecName);
        for (int items:stdIds){
            System.out.println(items);
        }

    }


    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCourseLocation() { return courseLocation; }
    public void setCourseLocation(int courseLocation) { courseLocation=courseCode%100; }

    public int getCourseCode() { return courseCode; }
    public void setCourseCode(int courseCode) { this.courseCode = courseCode; }

    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }

    public void setCourseGrade(int courseGrade){
        this.courseGrade=(courseGrade<101&&courseGrade>-1?courseGrade:0);
    }

    public void setStdIds(int ids){
        stdIds.add(ids);
    }
    public void setLecId(int ids){
        this.lecId=ids;
    }
    public void setLecName(String name_surname){
        this.lecName=name_surname;
    }




}
