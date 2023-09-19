package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Petrov Andrey");
        student.setGroup("ИВТ-2105");
        student.setAdmissionDate(new Date());

        System.out.println("Студент: " + student.getName() + "зачислен в группу: "
                + student.getGroup() + " - " + student.getAdmissionDate());
    }
}
