import java.util.ArrayList;
enum CourseLevel{
    UNDERGRAD,GRAD
}

public class Courses {
    CourseLevel courseLevel;
    private int courseCode;
    private String courseName;
    private int credit;
    private int courseLocation;
    private int courseGrade;
    private int  lecId ;
    private String lecName ;

    private String courseType;
    private ArrayList<Integer> courseList = new ArrayList<>();
    private ArrayList<Integer> stdIds = new ArrayList<>();

    private void uniqueCourse(ArrayList<Integer> courseList,int courseCode){
        if (!courseList.contains(courseCode))
            courseList.add(courseCode);
        else
            throw new RuntimeException("Course Code mut be unique");


    }
    Courses(int courseCode,String courseName,int credit){
        this(courseCode,courseName,credit,"undergrad");


    }
    Courses(int courseCode, String courseName,int credit,String courseType){
        setCourseCode(courseCode);
        setCourseName(courseName);
        setCredit(credit);
        setCourseType(courseType);

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


    public int getCourseCode() { return courseCode; }
    public void setCourseCode(int courseCode) { this.courseCode = courseCode; }

    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }

    public void setStdIds(int ids){
        stdIds.add(ids);
    }
    public void setLecId(int ids){
        this.lecId=ids;
    }
    public void setLecName(String name_surname){
        this.lecName=name_surname;
    }

    public void setCourseType(String courseType){
        switch (courseType.toLowerCase()) {
            case "undergrad" -> courseLevel = CourseLevel.UNDERGRAD;
            case "grad" -> courseLevel = CourseLevel.GRAD;
            default -> throw new RuntimeException("Course Type must be either undergrad or grad");
        }
    }
    public CourseLevel getCourseType(){
        return courseLevel;
    }




}
