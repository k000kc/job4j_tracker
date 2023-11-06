package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(st -> st != null)
                .sorted((left, right) -> right.getScope() - left.getScope())
                .takeWhile(st -> st.getScope() >= bound)
                .collect(Collectors.toList());
    }
}
