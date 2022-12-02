import java.util.ArrayList;
enum HOD{
    REGULAR,HOD
}
public class Lecturers {
    HOD Hod;
    private int lecturer_id;
    private String name_surname;
    private int givenCourses=0;
    private static ArrayList<Integer> lecturerList=new ArrayList<>();
    private ArrayList<String> givenCourseNames=new ArrayList<String>();
    private final int MAXCOURSES=10;
    private boolean hod;

    private void uniqueLecturer(ArrayList<Integer> lecturerList,int lecturer_id){
        if (!lecturerList.contains(lecturer_id))
            lecturerList.add(lecturer_id);
        else
            throw new RuntimeException("Lecturer ID must be unique");
    }
    Lecturers (int lecturer_id,String name_surname){
        this(lecturer_id,name_surname,false);

    }
    Lecturers (int lecturer_id,String name_surname,boolean hod){
        setLecturer_id(lecturer_id);
        uniqueLecturer(lecturerList,lecturer_id);
        setName_surname(name_surname);
        this.hod=hod;
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
        if (givenCourseNames.contains(course.getCourseName()))
            givenCourseNames.remove(course.getCourseName());
        else
            throw new RuntimeException("You cant remove a class from a lecturer who dont give that course");

    }
    public void giveGrades(Students students, Courses courses,int grade){
        if (givenCourseNames.contains(courses.getCourseName()))
            students.assignGrade(courses,grade);
        else
            throw new RuntimeException("You cant assign grades to a course that you dont give");
    }
    //checks if Lecturer is the Head of Department or not
    public HOD getHOD(){
        return Hod=(hod?HOD.HOD:HOD.REGULAR);
    }

    public void giveCertificate(Students students){
        if(Hod!=HOD.HOD){
            throw new RuntimeException("Only Head Of Department can give graduation certificates");
        }
        else switch (students.degree){
            case UNDERGRAD :
                if (students.getCoursesTaken().size()>=40 && students.getGPA()>=2)
                    gradMessage(students);
                else
                    gradError(students);
            case MASTER:
                if (students.getCoursesTaken().size()>=7 && students.getGPA()>=2.5)
                    gradMessage(students);
                else
                    gradError(students);
            case DOCTORATE:
                if (students.getCoursesTaken().size()>=8 && students.getGPA()>=3)
                    gradMessage(students);
                else
                    gradError(students);
        }}

    private void gradMessage(Students students){
        System.out.println(students.getName_surname()+" successfully graduated.");
    }
    private void gradError(Students students){
        System.out.println(students.getName_surname()+" cant graduate yet");
    }

    public String toString(){
        return String.format("Lecturer Name: %s\nLecturer ID: %d\n",name_surname,lecturer_id);
    }

}
