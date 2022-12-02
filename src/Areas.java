enum RoomSize{
    SMALL,MEDIUM,BIG
}
enum RoomType{
    OFFICE,CLASS,SOCIAL,STAFFOFFICE,LECOFFICE
}
public class Areas {
    RoomType roomType;
    private int sqrmtr;
    private String roomName;
    private boolean classroom;
    private boolean person;
    private boolean lecturer;

    Areas(String roomName,boolean classroom,boolean person,boolean lecturer){
        setRoomName(roomName);
        setClassroom(classroom);
        setLecturer(lecturer);
        setPerson(person);
        defineRoomType();
        if (defineRoomType()==RoomType.OFFICE){
            roomType=(isLecturer()?RoomType.LECOFFICE:RoomType.STAFFOFFICE);
        }
    }

    public void setRoomName(String roomName) { this.roomName = roomName; }
    public String getRoomName() { return roomName; }

    public boolean isClassroom() { return classroom; }
    public void setClassroom(boolean classroom) { this.classroom = classroom; }

    public boolean isLecturer() { return lecturer; }
    public void setLecturer(boolean lecturer) { this.lecturer = lecturer; }

    public boolean isPerson() { return person; }

    public void setPerson(boolean person) { this.person = person; }

    private RoomType defineRoomType(){
        if (isClassroom())
            return roomType=RoomType.CLASS;
        else if (!isPerson())
            return roomType=RoomType.SOCIAL;
        else
            return roomType=RoomType.OFFICE;

    }


}
