package com.example.welcome;
import com.example.welcome.model.AfterSurgeryTableThree;
import com.example.welcome.repository.AfterSurgeryTableThreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.welcome.model.AfterSurgeryTableOne;
import com.example.welcome.repository.AfterSurgeryTableOneRepository;

import java.util.List;

@Controller
@RequestMapping("afterSurgeryTableThree")
public class AfterSurgeryTableThreeController {

    @Autowired
    private AfterSurgeryTableThreeRepository afterSurgeryRepositoryTableThree;

    @Autowired
    private AfterSurgeryTableOneRepository afterSurgeryRepositoryTableOne;

    @GetMapping({"/", ""})
    public String showTableOne(Model model){

        List<AfterSurgeryTableThree> tableThreeRecords = afterSurgeryRepositoryTableThree.findAll();
        int totalNumOfJointComplicationCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfJointComplicationCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfJointComplicationCount)
                .sum();

        int totalNumOfMotorDysfunctionCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfMotorDysfunctionCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfMotorDysfunctionCount)
                .sum();

        int totalNumOfTraumaComplicationCount = tableThreeRecords.stream()
                .filter(r -> r.getNumOfTraumaComplicationCount() != null)
                .mapToInt(AfterSurgeryTableThree::getNumOfTraumaComplicationCount)
                .sum();

        int totalNumOfAnkleComplicationCount = tableThreeRecords.stream()
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

        List<AfterSurgeryTableOne> tableOneRecords = afterSurgeryRepositoryTableOne.findAll();

        // TableOne
        int totalAdverseReactions = tableOneRecords.stream()
                .filter(r -> r.getNumOfAdverseReactionCases() != null)
                .mapToInt(AfterSurgeryTableOne::getNumOfAdverseReactionCases)
                .sum();

        float proportionOfJointComplicationCount = (float) totalNumOfJointComplicationCount / totalAdverseReactions;

        float proportionOfMotorDysfunctionCount = (float) totalNumOfMotorDysfunctionCount / totalAdverseReactions;

        float proportionOfTraumaComplicationCount = (float) totalNumOfTraumaComplicationCount / totalAdverseReactions;

        float proportionOfAnkleComplicationCount = (float) totalNumOfAnkleComplicationCount / totalAdverseReactions;

        float proportionOfPediatricAdverseEventCount = (float) totalNumOfPediatricAdverseEventCount / totalAdverseReactions;

        float proportionOfSpinalComplicationCount = (float) totalNumOfSpinalComplicationCount / totalAdverseReactions;

        float proportionOfHandSurgeryComplicationCount = (float) totalNumOfHandSurgeryComplicationCount / totalAdverseReactions;


        model.addAttribute("tableThreeRecords", tableThreeRecords);

        model.addAttribute("totalNumOfJointComplicationCount", totalNumOfJointComplicationCount);
        model.addAttribute("totalNumOfMotorDysfunctionCount", totalNumOfMotorDysfunctionCount);
        model.addAttribute("totalNumOfTraumaComplicationCount", totalNumOfTraumaComplicationCount);
        model.addAttribute("totalNumOfAnkleComplicationCount", totalNumOfAnkleComplicationCount);
        model.addAttribute("totalNumOfPediatricAdverseEventCount", totalNumOfPediatricAdverseEventCount);
        model.addAttribute("totalNumOfSpinalComplicationCount", totalNumOfSpinalComplicationCount);
        model.addAttribute("totalNumOfHandSurgeryComplicationCount", totalNumOfHandSurgeryComplicationCount);

        model.addAttribute("proportionOfJointComplicationCount", proportionOfJointComplicationCount);
        model.addAttribute("proportionOfMotorDysfunctionCount", proportionOfMotorDysfunctionCount);
        model.addAttribute("proportionOfTraumaComplicationCount", proportionOfTraumaComplicationCount);
        model.addAttribute("proportionOfAnkleComplicationCount", proportionOfAnkleComplicationCount);
        model.addAttribute("proportionOfPediatricAdverseEventCount", proportionOfPediatricAdverseEventCount);
        model.addAttribute("proportionOfSpinalComplicationCount", proportionOfSpinalComplicationCount);
        model.addAttribute("proportionOfHandSurgeryComplicationCount", proportionOfHandSurgeryComplicationCount);



        return "afterSurgeryTableThree";
    }

}

