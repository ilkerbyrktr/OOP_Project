import java.util.ArrayList;
enum Degree{
    UNDERGRAD,MASTER,DOCTORATE
}


public class Students {
    Degree degree;
    private int studentId;
    private String name_surname;
    private int year;
    private double gpa;
    private static ArrayList<Integer> studentList = new ArrayList<>();
    private ArrayList<String> coursesTaken = new ArrayList<>();
    private ArrayList<Integer> courseGrades = new ArrayList<>();
    int index=0;
    private void uniqueID(ArrayList<Integer> studentList,int studentId){
        if (!studentList.contains(studentId)){
            studentList.add(studentId);
        }
        else
            throw new RuntimeException("Student ID must be unique");

    }
    Students(String name_surname,int studentId,int year){
        this(name_surname,studentId,year,"undergrad");

    }
    Students(String name_surname,int studentId,int year,String gradType){
        setStudentId(studentId);
        uniqueID(studentList,studentId);
        setYear(year);
        setName_surname(name_surname);
        setGradType(gradType);
    }
    public void addCourse(Courses course,int grade){

        switch (degree){
            case UNDERGRAD:
                if (course.getCourseType()==CourseLevel.UNDERGRAD){
                    coursesTaken.add(course.getCourseName());
                    courseGrades.add(grade);
                    course.setStdIds(studentId);
                    index+=1;
                }else
                    throw new RuntimeException("You cant assign higher level courses to students");
                break;
            case MASTER:
                coursesTaken.add(course.getCourseName());
                courseGrades.add(grade);
                course.setStdIds(studentId);
                index+=1;
                break;
            case DOCTORATE:
                coursesTaken.add(course.getCourseName());
                courseGrades.add(grade);
                course.setStdIds(studentId);
                index+=1;
                break;
            default:
                break;

        }


    }
    public void courseInfo(){
        for (String items:coursesTaken)
            System.out.println(items);
    }


   public void checkCourse(Courses course){
       if (coursesTaken.contains(course.getCourseName()))
           System.out.println(name_surname+" is already taking "+course.getCourseName()+" course");
       else
           System.out.println(name_surname+" isnt taking "+course.getCourseName()+" yet");
   }
   public ArrayList<String> getCoursesTaken(){
        return coursesTaken;
   }
   public void assignGrade(Courses course,int grade){
       if(coursesTaken.contains(course.getCourseName()))
           courseGrades.set(coursesTaken.indexOf(course.getCourseName()),grade);


   }
    public void setGPA(){ this.gpa=gpa; }
   public double getGPA(){ return gpa; }

    public void gradInfo(){
        switch (degree){
            case DOCTORATE -> doctoral();
            case UNDERGRAD -> undergrad();
            case MASTER ->   master();
        }
    }
    private void doctoral(){
        System.out.println(name_surname+ " is a doctorate student");

    }
    private void master(){
        System.out.println(name_surname + " is a master student");
    }
    private void undergrad(){
        System.out.println(name_surname +" is an undergrad student");
    }
    public int getStudentId() { return studentId; }
    private void setStudentId(int studentId) { this.studentId = studentId; }

    public int getYear() { return year; }
    private void setYear(int year) { this.year=(year>1900&&year<2023?year:2022); }

    public String getName_surname() { return name_surname; }
    private void setName_surname(String name_surname) {

        for (char c:name_surname.toCharArray()){
            if(Character.isDigit(c)){
                System.out.println("Name cannot contain Numbers");
                throw new RuntimeException("Number in Name");
            }
        }
        this.name_surname=name_surname;

    }

    public void setGradType(String gradType) {

        switch (gradType.toLowerCase()) {
            case "doctorate" -> degree = Degree.DOCTORATE;
            case "master" -> degree = Degree.MASTER;
            case "undergrad" -> degree = Degree.UNDERGRAD;
            default ->
                    throw new RuntimeException("You can only assign Doctorate,Master or Undergrad to Graduation Type");
        }

    }




}
