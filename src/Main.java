public class Main {
    public static void main(String[] args)
    {
        Courses crs1 = new Courses(304,"OOP",6);
        Courses crs2 = new Courses(307, "Data Science",6);
        Courses crs3 = new Courses(309,"Java Programming",3);
        Lecturers lec1 = new Lecturers(1234,"Hasan Ahmet");
        Students std1 = new Students("İlker Bayraktar",2123,2011,"Doctorate");
        std1.addCourse(crs1,75);
        std1.addCourse(crs2,60);
        lec1.addCourse(crs1);
        lec1.addCourse(crs2);
        std1.courseInfo();
        std1.gradInfo();
        std1.checkCourse(crs1);
        std1.checkCourse(crs2);
        std1.checkCourse(crs3);
        System.out.println(lec1);
        crs1.courseInfo();
        lec1.removeCourse(crs1);
        System.out.println(lec1);

    }
}