// src/main/java/com/example/welcome/repository/AfterSurgeryJoinRepositoryImpl.java
package com.example.welcome.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AfterSurgeryJoinRepositoryImpl implements AfterSurgeryJoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> fetchJoinedData() {
        String sql = "SELECT t1.date, " +
                "t1.numOfPostoperativeVisits, " +
                "t1.numOfPostoperativeAnalgesiaCases, " +
                "t1.numOfAdverseReactionCases, " +
                "t1.numOfInadequateAnalgesia, " +
                "t2.numOfNauseaAndVomiting, " +
                "t2.numOfDizziness, " +
                "t2.numOfNauseaAndVomitingAndDizziness, " +
                "t2.numOfItching, " +
                "t2.numOfAllergicRash, " +
                "t2.numOfProlongedAnestheticRecovery, " +
                "t2.numOfPunctureSiteAbnormality, " +
                "t2.numOfAbdominalDistension, " +
                "t2.numOfEndotrachealIntubationDiscomfort, " +
                "t2.numOfEpigastricPain, " +
                "t2.numOfDelirium, " +
                "t2.numOfChestDiscomfort, " +
                "t2.numOfTourniquetReaction, " +
                "t2.numOfOther, " +
                "t2.otherComments " +
                "FROM afterSurgeryTableOne t1 " +
                "JOIN afterSurgeryTableTwo t2 ON t1.date = t2.date";

        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}

