import java.util.ArrayList;
enum Degree{
    UNDERGRAD,MASTER,DOCTORATE
}


public class Students {
    Degree degree;
    private int studentId;
    private String name_surname;
    private int year;
    private String gradType;
    private boolean graduate;
    private double gpa;

    private ArrayList<String> coursesTaken = new ArrayList<String>();
    private ArrayList<Integer> courseGrades = new ArrayList<Integer>();
    int index=0;

    Students(String name_surname,int studentId,int year){
        setStudentId(studentId);
        setYear(year);
        setName_surname(name_surname);

    }
    Students(String name_surname,int studentId,int year,String gradType){
        setStudentId(studentId);
        setYear(year);
        setName_surname(name_surname);
        setGradType(gradType);
    }
    public void addCourse(Courses course,int grade){
        coursesTaken.add(course.getCourseName());
        courseGrades.add(grade);
        course.setStdIds(studentId);
        index+=1;

    }
    public void courseInfo(){
        for(String item: coursesTaken){
            int indexer=0;
            System.out.println(coursesTaken.get(indexer));
            indexer+=1;
        }
    }


   public void checkCourse(Courses course){
       int i=0;
        for (String item : coursesTaken){
            if (coursesTaken.get(i)==item){
                System.out.println(name_surname+" is already taking "+ course.getCourseName());
                break;
            }
            else{
                i++;
                if (i==coursesTaken.size()){
                    System.out.println(name_surname+" isnt taking "+ course.getCourseName()+" yet.");
                }
                else
                    continue;

            }


        }
   }
   public void assignGrade(Courses course,int grade){
       for (String item : coursesTaken){
           if (course.getCourseName()==item){
               course.setCourseGrade(grade);
           }
           else
               continue;
       }
   }
    public void setGPA(){
        this.gpa=gpa;
    }
   public double getGPA(){
        return gpa;
   }

    public void gradInfo(){
        switch (degree){
            case DOCTORATE:
                doctoral();
                break;
            case UNDERGRAD:
                undergrad();
                break;
            case MASTER:
                master();
                break;


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
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year=(year>1900&&year<2023?year:2022); }

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

    public void setGradType(String gradType) {
        ;
        switch (gradType.toLowerCase()){
            case "doctorate":
                degree = Degree.DOCTORATE;
                break;
            case "master":
                degree = Degree.MASTER;
                break;
            case "undergrad":
                degree = Degree.UNDERGRAD;
                break;
            default:
                throw new RuntimeException("You can only assign Doctorate,Master or Undergrad to Graduation Type");
        }

    }




}
