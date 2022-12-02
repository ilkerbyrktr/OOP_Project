public class Secretary extends Staff{
    private int staffId;
    private int workHours;
    private String name_surname;

    Secretary(int staffId,String name_surname,int workHours){
        setStaffId(staffId);
        setWorkHours(workHours);
        setName_surname(name_surname);
    }

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
    public void appointCourse(Lecturers lecturer,Courses course){
        lecturer.addCourse(course);
    }
    public void removeCourse(Lecturers lecturer,Courses course){
        lecturer.removeCourse(course);
    }
    public int getWorkHours() { return workHours;}
    public void setWorkHours(int workHours) { this.workHours = (workHours<45&&workHours>0?workHours:40); }

    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public void taskInfo(){
        System.out.println("Secretary doing secretary stuff ");
    }
}
