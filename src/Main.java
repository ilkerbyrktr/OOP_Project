public class Main {
    public static void main(String[] args)
    {
        Courses crs1 = new Courses(304,"OOP",6,"undergrad");
        Courses crs2 = new Courses(207, "Data Science",6);
        Courses crs3 = new Courses(409,"Java Programming",3);
        Courses crs4 = new Courses(110,"C# Programming",6,"undergrad");
        Courses crs5 = new Courses(235,"Master Mathematics",5,"grad");

        Lecturers lec1 = new Lecturers(1234,"Hasan Ahmet");
        Lecturers lec2 = new Lecturers(2545,"Ahmet Hasanoğlu",false);
        Lecturers lec3 = new Lecturers(1111,"Hasan Başkan",true);
        Lecturers lec4 = new Lecturers(2593,"Ahmet Ahmetoğlu");


        Students std1 = new Students("İlker Bayraktar",2123,2011,"Undergrad");
        Students std2 = new Students("Bayraktar İlker", 2178,2015);
        Students std3 = new Students("Ahmet Çiçekçi",4586,2018);
        Students std4 = new Students("İlayda Ceylan",7536,2022);
        Students std5 = new Students("Ahmet Arabacı",2129,2011);
        Students std6 = new Students("Hüsnü Çoban",2111,1985,"doctorate");

        std1.addCourse(crs1,75);
        std1.addCourse(crs2,60);



    }
}