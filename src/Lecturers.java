import java.util.ArrayList;

public class Lecturers {
    private int lecturer_id;
    private String name_surname;
    private int givenCourses=0;
    private ArrayList<String> givenCourseNames=new ArrayList<String>();
    private final int MAXCOURSES=10;

    Lecturers (int lecturer_id,String name_surname){
        setLecturer_id(lecturer_id);
        setName_surname(name_surname);

    }
    // Get and set methods for lecturer id
    public int getLecturer_id() { return lecturer_id; }
    public void setLecturer_id(int lecturer_id) { this.lecturer_id = lecturer_id; }


    // Get and set methods for name_surname
    public String getName_surname() { return name_surname; }
    public void setName_surname(String name_surname) {

        for (char c:name_surname.toCharArray()){
            if(Character.isDigit(c)){
                System.out.println("Name cannot contain Numbers");
                throw new RuntimeException("Number in Name");
            }
            else
                continue;
        }
        this.name_surname=name_surname;

    }

    public void addCourse(Courses course){
        if (givenCourses<MAXCOURSES){
            givenCourseNames.add(course.getCourseName());
            System.out.println(course.getCourseName()+" course added Successfully");
            givenCourses+=1;
            course.setLecId(lecturer_id);
            course.setLecName(name_surname);
        }
        else
            System.out.println("Limit is reached");

    }
    public void removeCourse(Courses course){
       for(int i=0;i<givenCourseNames.size();i++){
           if (givenCourseNames.get(i)==course.getCourseName()){
               givenCourseNames.remove(i);
               break;
           }
       }

    }
    public String toString(){
        return String.format("Lecturer Name: %s\nLecturer ID: %d\nCourses given: %s\n",name_surname,lecturer_id,givenCourseNames.get(0));
    }

}
