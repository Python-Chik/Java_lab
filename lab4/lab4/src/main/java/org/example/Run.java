package org.example;

import org.example.controller.*;
import org.example.model.*;

public class Run {
    public static void main(String[] args) {
        Human rector = new Human("Олександр", "Азюковський", "Олександрович", Gender.MALE);  ///створюємо ректора та університет
        University university = UniversityCreator.createUniversity("Національний технічний університет Дніпровська Політехніка", rector);

        Human dean = new Human("Ірина", "Удовик", "Михайлівна", Gender.FEMALE); ///створюємо факультет та декана
        Faculty faculty = FacultyCreator.createFaculty("Факультет інформаційних технологій", dean);
        UniversityCreator.addFacultyToUniversity(university, faculty);

        Human headOfDepartment = new Human("Мартиненко", "Андрій","Анатольйович", Gender.MALE); ///створюємо кафедру ПЗКС
        Department department = DepartmentCreator.createDepartment("ПЗКС", headOfDepartment);
        FacultyCreator.addDepartmentToFaculty(faculty, department);

        Human groupHead1 = new Human("Юнісов", "Ярослав", "Андрійович", Gender.MALE);
        Group group1 = GroupCreator.createGroup("122-21-2", groupHead1);
        DepartmentCreator.addGroupToDepartment(department1, group1);

        Student student1 = StudentCreator.createStudent("Іваненко","Дмитро",  "Олександрович", Gender.MALE);  ///створюємо оболтусів(нарешті, хтось буде вчитися)
        Student student2 = StudentCreator.createStudent("Мельник","Анна",  "Ігорівна", Gender.FEMALE);

        GroupCreator.addStudentToGroup(group, student1); ///додаємо студента до групи
        GroupCreator.addStudentToGroup(group, student2);

        System.out.println(university.getName()); ///виводимо всю інфу про створену структуру
        for (Faculty f : university.getFaculties()) {
            System.out.println(f.getName());
            for (Department d : f.getDepartments()) {
                System.out.println("Кафедра " + d.getName());
                for (Group g : d.getGroups()) {
                    System.out.println("Група: " + g.getName());
                    for (Student s : g.getStudents()) {
                        System.out.println("Студент: " + s.getFullName());
                    }
                }
            }
        }
    }
}
