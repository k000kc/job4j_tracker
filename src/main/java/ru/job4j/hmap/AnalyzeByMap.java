package ru.job4j.hmap;

import java.util.*;
import java.util.function.BiFunction;

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
        BiFunction<Integer, Integer, Integer> function = Integer::sum;
        int count = 0;
        for (Pupil pupil : pupils) {
            count++;
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), function);
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> sd : map.entrySet()) {
            labels.add(new Label(sd.getKey(), (double) sd.getValue() / count));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sum;
        double max = 0D;
        String name = null;
        for (Pupil pupil : pupils) {
            sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            if (sum > max) {
                max = sum;
                name = pupil.name();
            }
        }
        return new Label(name, max);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> function = Integer::sum;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), function);
            }
        }
        int max = 0;
        String name = null;
        for (Map.Entry<String, Integer> sd : map.entrySet()) {
            if (sd.getValue() > max) {
                max = sd.getValue();
                name = sd.getKey();
            }
        }
        return new Label(name, max);
    }
}
