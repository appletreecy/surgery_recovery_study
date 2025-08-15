package com.example.welcome;
import com.example.welcome.model.AfterSurgeryTableThree;
import com.example.welcome.repository.AfterSurgeryTableThreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("afterSurgeryTableThree")
public class AfterSurgeryTableThreeController {

    @Autowired
    private AfterSurgeryTableThreeRepository afterSurgeryRepositoryTableThree;

    @GetMapping({"/", ""})
    public String showTableOne(Model model){

        List<AfterSurgeryTableThree> tableThreeRecords = afterSurgeryRepositoryTableThree.findAll();
        int totalNumOfJointComplicationCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfJointComplicationCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfJointComplicationCount)
                .sum();

        int totalPostoperativeAnalgesia = tableThreeRecords.stream()
                .filter(r -> r.getNumOfMotorDysfunctionCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfMotorDysfunctionCount)
                .sum();

        int totalAdverseReactions = tableThreeRecords.stream()
                .filter(r -> r.getNumOfTraumaComplicationCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfTraumaComplicationCount)
                .sum();

        int totalInadequateAnalgesia = tableThreeRecords.stream()
                .filter(r -> r.getNumOfAnkleComplicationCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfAnkleComplicationCount)
                .sum();

        int totalNumOfPediatricAdverseEventCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfPediatricAdverseEventCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfPediatricAdverseEventCount)
                .sum();

        int totalNumOfSpinalComplicationCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfSpinalComplicationCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfSpinalComplicationCount)
                .sum();

        int totalNumOfHandSurgeryComplicationCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfHandSurgeryComplicationCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfHandSurgeryComplicationCount)
                .sum();

        int totalNumOfObstetricAdverseEventCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfObstetricAdverseEventCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfObstetricAdverseEventCount)
                .sum();

        int totalNumOfGynecologicalAdverseEventCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfGynecologicalAdverseEventCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfGynecologicalAdverseEventCount)
                .sum();

//        float proportionOfTotalPostoperativeAnalgesiaCases = (float) totalPostoperativeAnalgesia / totalVisits;
//
//        float proportionOfTotalAdverseReactions = (float) totalAdverseReactions / totalPostoperativeAnalgesia;
//
//        float proportionOfTotalInadequateAnalgesia = 1 - ((float) totalInadequateAnalgesia / totalPostoperativeAnalgesia);


        model.addAttribute("tableThreeRecords", tableThreeRecords);
//        model.addAttribute("totalVisits", totalVisits);
//        model.addAttribute("totalPostoperativeAnalgesia", totalPostoperativeAnalgesia);
//        model.addAttribute("totalAdverseReactions", totalAdverseReactions);
//        model.addAttribute("totalInadequateAnalgesia", totalInadequateAnalgesia);
//
//        model.addAttribute("proportionOfTotalPostoperativeAnalgesiaCases", proportionOfTotalPostoperativeAnalgesiaCases);
//        model.addAttribute("proportionOfTotalAdverseReactions", proportionOfTotalAdverseReactions);
//        model.addAttribute("proportionOfTotalInadequateAnalgesia", proportionOfTotalInadequateAnalgesia);



        return "afterSurgeryTableThree";
    }

}

