package com.example.welcome;
import com.example.welcome.model.AfterSurgeryTableOne;
import com.example.welcome.repository.AfterSurgeryTableOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("afterSurgeryTableOne")
public class AfterSurgeryTableOneController {

    @Autowired
    private AfterSurgeryTableOneRepository afterSurgeryRepositoryTableOne;

    @GetMapping({"/", ""})
    public String showTableOne(Model model){

        List<AfterSurgeryTableOne> records = afterSurgeryRepositoryTableOne.findAll();
        int totalVisits = records.stream()
                .filter(r -> r.getNumOfPostoperativeVisits() != null)
                .mapToInt(AfterSurgeryTableOne::getNumOfPostoperativeVisits)
                .sum();

        int totalPostoperativeAnalgesia = records.stream()
                        .filter(r -> r.getNumOfPostoperativeAnalgesiaCases() != null)
                                .mapToInt(AfterSurgeryTableOne::getNumOfPostoperativeAnalgesiaCases)
                                        .sum();

        int totalAdverseReactions = records.stream()
                        .filter(r -> r.getNumOfAdverseReactionCases() != null)
                                .mapToInt(AfterSurgeryTableOne::getNumOfAdverseReactionCases)
                                        .sum();

        int totalInadequateAnalgesia = records.stream()
                        .filter(r -> r.getNumOfInadequateAnalgesia() != null)
                                .mapToInt(AfterSurgeryTableOne::getNumOfInadequateAnalgesia)
                                        .sum();

        float proportionOfTotalPostoperativeAnalgesiaCases = (float) totalPostoperativeAnalgesia / totalVisits;

        float proportionOfTotalAdverseReactions = (float) totalAdverseReactions / totalPostoperativeAnalgesia;

        float proportionOfTotalInadequateAnalgesia = 1 - ((float) totalInadequateAnalgesia / totalPostoperativeAnalgesia);


        model.addAttribute("afterSurgeryTableOne", records);
        model.addAttribute("totalVisits", totalVisits);
        model.addAttribute("totalPostoperativeAnalgesia", totalPostoperativeAnalgesia);
        model.addAttribute("totalAdverseReactions", totalAdverseReactions);
        model.addAttribute("totalInadequateAnalgesia", totalInadequateAnalgesia);

        model.addAttribute("proportionOfTotalPostoperativeAnalgesiaCases", proportionOfTotalPostoperativeAnalgesiaCases);
        model.addAttribute("proportionOfTotalAdverseReactions", proportionOfTotalAdverseReactions);
        model.addAttribute("proportionOfTotalInadequateAnalgesia", proportionOfTotalInadequateAnalgesia);



        return "afterSurgeryTableOne";
    }

}

