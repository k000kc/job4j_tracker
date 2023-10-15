package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
                count++;
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        int count;
        double sum;
        for (Pupil pupil : pupils) {
            count = 0;
            sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            rsl.add(new Label(pupil.name(), sum / count));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            count++;
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), subject.score()
                        + map.getOrDefault(subject.name(), 0));
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> sd : map.entrySet()) {
            labels.add(new Label(sd.getKey(), (double) sd.getValue() / count));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Queue<Label> labels = new LinkedList<>();
        double sum;
        for (Pupil pupil : pupils) {
            sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
        }
        return labels.peek();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), subject.score()
                        + map.getOrDefault(subject.name(), 0));
            }
        }
        Queue<Label> labels = new LinkedList<>();
        for (Map.Entry<String, Integer> sd : map.entrySet()) {
            labels.add(new Label(sd.getKey(), (double) sd.getValue()));
        }
        return labels.peek();
    }
}
