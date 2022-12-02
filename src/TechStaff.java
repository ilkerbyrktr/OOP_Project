public class TechStaff extends Staff{
    private int staffId;
    private String name_surname;
    private int workHours;
    TechStaff(int staffId, String name_surname, int workHours){
        setStaffId(staffId);
        setName_surname(name_surname);
        setWorkHours(workHours);


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

    public int getWorkHours() { return workHours;}
    public void setWorkHours(int workHours) { this.workHours = (workHours<45&&workHours>0?workHours:40); }

    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public void taskInfo(){
        System.out.println("Tech staff doing techy things");
    }

}
