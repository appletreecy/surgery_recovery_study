package com.example.welcome.dto;

import java.time.LocalDate;

public class AfterSurgeryJoinDto {
    private LocalDate date;

    // From Table One
    private Integer numOfPostoperativeVisits;
    private Integer numOfPostoperativeAnalgesiaCases;
    private Integer numOfAdverseReactionCases;
    private Integer numOfInadequateAnalgesia;

    // From Table Two
    private Integer numOfNauseaAndVomiting;
    private Integer numOfDizziness;
    private Integer numOfNauseaAndVomitingAndDizziness;
    private Integer numOfItching;
    private Integer numOfAllergicRash;
    private Integer numOfProlongedAnestheticRecovery;
    private Integer numOfPunctureSiteAbnormality;
    private Integer numOfAbdominalDistension;
    private Integer numOfEndotrachealIntubationDiscomfort;
    private Integer numOfEpigastricPain;
    private Integer numOfDelirium;
    private Integer numOfChestDiscomfort;
    private Integer numOfTourniquetReaction;
    private Integer numOfOther;
    private String otherComments;

    // Getters and Setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Integer getNumOfPostoperativeVisits() { return numOfPostoperativeVisits; }
    public void setNumOfPostoperativeVisits(Integer value) { this.numOfPostoperativeVisits = value; }

    public Integer getNumOfPostoperativeAnalgesiaCases() { return numOfPostoperativeAnalgesiaCases; }
    public void setNumOfPostoperativeAnalgesiaCases(Integer value) { this.numOfPostoperativeAnalgesiaCases = value; }

    public Integer getNumOfAdverseReactionCases() { return numOfAdverseReactionCases; }
    public void setNumOfAdverseReactionCases(Integer value) { this.numOfAdverseReactionCases = value; }

    public Integer getNumOfInadequateAnalgesia() { return numOfInadequateAnalgesia; }
    public void setNumOfInadequateAnalgesia(Integer value) { this.numOfInadequateAnalgesia = value; }

    public Integer getNumOfNauseaAndVomiting() { return numOfNauseaAndVomiting; }
    public void setNumOfNauseaAndVomiting(Integer value) { this.numOfNauseaAndVomiting = value; }

    public Integer getNumOfDizziness() { return numOfDizziness; }
    public void setNumOfDizziness(Integer value) { this.numOfDizziness = value; }

    public Integer getNumOfNauseaAndVomitingAndDizziness() { return numOfNauseaAndVomitingAndDizziness; }
    public void setNumOfNauseaAndVomitingAndDizziness(Integer value) { this.numOfNauseaAndVomitingAndDizziness = value; }

    public Integer getNumOfItching() { return numOfItching; }
    public void setNumOfItching(Integer value) { this.numOfItching = value; }

    public Integer getNumOfAllergicRash() { return numOfAllergicRash; }
    public void setNumOfAllergicRash(Integer value) { this.numOfAllergicRash = value; }

    public Integer getNumOfProlongedAnestheticRecovery() { return numOfProlongedAnestheticRecovery; }
    public void setNumOfProlongedAnestheticRecovery(Integer value) { this.numOfProlongedAnestheticRecovery = value; }

    public Integer getNumOfPunctureSiteAbnormality() { return numOfPunctureSiteAbnormality; }
    public void setNumOfPunctureSiteAbnormality(Integer value) { this.numOfPunctureSiteAbnormality = value; }

    public Integer getNumOfAbdominalDistension() { return numOfAbdominalDistension; }
    public void setNumOfAbdominalDistension(Integer value) { this.numOfAbdominalDistension = value; }

    public Integer getNumOfEndotrachealIntubationDiscomfort() { return numOfEndotrachealIntubationDiscomfort; }
    public void setNumOfEndotrachealIntubationDiscomfort(Integer value) { this.numOfEndotrachealIntubationDiscomfort = value; }

    public Integer getNumOfEpigastricPain() { return numOfEpigastricPain; }
    public void setNumOfEpigastricPain(Integer value) { this.numOfEpigastricPain = value; }

    public Integer getNumOfDelirium() { return numOfDelirium; }
    public void setNumOfDelirium(Integer value) { this.numOfDelirium = value; }

    public Integer getNumOfChestDiscomfort() { return numOfChestDiscomfort; }
    public void setNumOfChestDiscomfort(Integer value) { this.numOfChestDiscomfort = value; }

    public Integer getNumOfTourniquetReaction() { return numOfTourniquetReaction; }
    public void setNumOfTourniquetReaction(Integer value) { this.numOfTourniquetReaction = value; }

    public Integer getNumOfOther() { return numOfOther; }
    public void setNumOfOther(Integer value) { this.numOfOther = value; }

    public String getOtherComments() { return otherComments; }
    public void setOtherComments(String value) { this.otherComments = value; }
}

