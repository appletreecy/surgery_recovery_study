package com.example.welcome;

import com.example.welcome.model.Student;
import com.example.welcome.model.AfterSurgery;
import com.example.welcome.model.AfterSurgerySummary;
import com.example.welcome.repository.StudentRepository;
import com.example.welcome.repository.AfterSurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WelcomeController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AfterSurgeryRepository afterSurgeryRepository;

    @GetMapping("/")
    public String welcome(Model model) {
        List<Student> students = studentRepository.findAll();
        int totalAge = students.stream().mapToInt(Student::getAge).sum();

        List<Map<String, Object>> points = students.stream()
                .map(s -> {
                    Map<String, Object> point = new HashMap<>();
                    point.put("x", s.getId());
                    point.put("y", s.getAge());
                    return point;
                })
                .collect(Collectors.toList());

        List<AfterSurgery> records = afterSurgeryRepository.findAll();

        List<AfterSurgerySummary> summaries = records.stream()
                        .map(r -> new AfterSurgerySummary(
                                r.getId(),
                                r.getDate(),
                                r.getNumOfPostoperativeAnalgesiaCases(),
                                r.getNumOfAdverseReactionCases()
                        ))
                .collect(Collectors.toList());

        int totalVisits = records.stream()
                        .filter(r -> r.getNumOfPostoperativeVisits() != null)
                                .mapToInt(AfterSurgery::getNumOfPostoperativeVisits)
                                        .sum();

        int totalAnalgesia = records.stream()
                        .filter(r -> r.getNumOfPostoperativeAnalgesiaCases() != null)
                                .mapToInt(AfterSurgery::getNumOfPostoperativeAnalgesiaCases)
                                        .sum();

        int totalAdverse = records.stream()
                        .filter(r -> r.getNumOfAdverseReactionCases() != null)
                                .mapToInt(AfterSurgery::getNumOfAdverseReactionCases)
                                        .sum();

        int totalPoorAnalgesicEffect = records.stream()
                        .filter(r -> r.getPoorAnalgesicEffect() != null)
                                .mapToInt(AfterSurgery::getPoorAnalgesicEffect)
                                        .sum();

        int totalNumberOfFollowupVisitsForCriticallyIIIPatients = records.stream()
                        .filter(r -> r.getNumberOfFollowupVisitsForCriticallyIIIPatients() != null)
                                .mapToInt(AfterSurgery::getNumberOfFollowupVisitsForCriticallyIIIPatients)
                                        .sum();

        float proportionOfPostoperativeAnalgesia = (float) totalAnalgesia / totalVisits;

        float overallAdverseReactionRate = (float) totalAdverse / totalAnalgesia;

        float postoperativeAnalgesiaSatisfactionRate = (float) (totalAnalgesia - totalPoorAnalgesicEffect) / totalAnalgesia;

        // Table
        int totalNauseaAndVomiting = records.stream()
                        .filter(r -> r.getNauseaAndVomiting() != null)
                                .mapToInt(AfterSurgery::getNauseaAndVomiting)
                                        .sum();

        int totalDizziness = records.stream()
                .filter(r -> r.getDizziness() != null)
                .mapToInt(AfterSurgery::getDizziness)
                .sum();

        int totalNauseaVomitingDizziness = records.stream()
                .filter(r -> r.getNauseaVomitingDizziness() != null)
                .mapToInt(AfterSurgery::getNauseaVomitingDizziness)
                .sum();

        int totalSkinItching = records.stream()
                .filter(r -> r.getSkinItching() != null)
                .mapToInt(AfterSurgery::getSkinItching)
                .sum();

        float proportionOfNauseaAndVomiting = (float) totalNauseaAndVomiting / totalAdverse;

        float proportionDizziness = (float) totalDizziness / totalAdverse;

        float proportionOfNauseaVomitingDizziness = (float) totalNauseaVomitingDizziness / totalAdverse;

        float proportionOfSkinItching = (float) totalSkinItching / totalAdverse;

        int totalDelayedRecoveryFromAnesthesia = records.stream()
                .filter(r -> r.getDelayedRecoveryFromAnesthesia() != null)
                .mapToInt(AfterSurgery::getDelayedRecoveryFromAnesthesia)
                .sum();

        int totalAbnormalityAtThePunctureSite = records.stream()
                .filter(r -> r.getAbnormalityAtThePunctureSite() != null)
                .mapToInt(AfterSurgery::getAbnormalityAtThePunctureSite)
                .sum();

        int totalBloating = records.stream()
                .filter(r -> r.getBloating() != null)
                .mapToInt(AfterSurgery::getBloating)
                .sum();

        float proportionOfDelayedRecoveryFromAnesthesia = (float) totalDelayedRecoveryFromAnesthesia / totalAdverse;
        float proportionOfAbnormalityAtThePunctureSite = (float) totalAbnormalityAtThePunctureSite / totalAdverse;
        float proportionOfBloating = (float) totalBloating / totalAdverse;


        model.addAttribute("students", students);
        model.addAttribute("totalAge", totalAge);
        model.addAttribute("points", points);
        model.addAttribute("afterSurgeryRecords", records);
        model.addAttribute("afterSurgerySummaries", summaries);
        model.addAttribute("totalVisits", totalVisits);
        model.addAttribute("totalAnalgesia", totalAnalgesia);
        model.addAttribute("totalAdverse", totalAdverse);
        model.addAttribute("totalPoorAnalgesicEffect", totalPoorAnalgesicEffect);
        model.addAttribute("totalNumberOfFollowupVisitsForCriticallyIIIPatients",totalNumberOfFollowupVisitsForCriticallyIIIPatients);
        model.addAttribute("proportionOfPostoperativeAnalgesia", proportionOfPostoperativeAnalgesia);
        model.addAttribute("overallAdverseReactionRate", overallAdverseReactionRate);
        model.addAttribute("postoperativeAnalgesiaSatisfactionRate", postoperativeAnalgesiaSatisfactionRate);

        model.addAttribute("totalNauseaAndVomiting", totalNauseaAndVomiting);
        model.addAttribute("totalDizziness", totalDizziness);
        model.addAttribute("totalNauseaVomitingDizziness", totalNauseaVomitingDizziness);
        model.addAttribute("totalSkinItching", totalSkinItching);
        model.addAttribute("proportionOfNauseaAndVomiting", proportionOfNauseaAndVomiting);
        model.addAttribute("proportionDizziness", proportionDizziness);
        model.addAttribute("proportionOfNauseaVomitingDizziness", proportionOfNauseaVomitingDizziness);
        model.addAttribute("proportionOfSkinItching", proportionOfSkinItching);
        model.addAttribute("totalDelayedRecoveryFromAnesthesia", totalDelayedRecoveryFromAnesthesia);
        model.addAttribute("totalAbnormalityAtThePunctureSite", totalAbnormalityAtThePunctureSite);
        model.addAttribute("totalBloating", totalBloating);
        model.addAttribute("proportionOfDelayedRecoveryFromAnesthesia", proportionOfDelayedRecoveryFromAnesthesia);
        model.addAttribute("proportionOfAbnormalityAtThePunctureSite", proportionOfAbnormalityAtThePunctureSite);
        model.addAttribute("proportionOfBloating", proportionOfBloating);


        return "students";
    }
}
