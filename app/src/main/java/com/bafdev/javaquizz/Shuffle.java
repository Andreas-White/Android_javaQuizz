package com.bafdev.javaquizz;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class Shuffle {

    private Questions[] mQuestionStack = {
            new Questions(R.string.q1,'a'),
            new Questions(R.string.q2,'c'),
            new Questions(R.string.q3,'a'),
            new Questions(R.string.q4,'d'),
            new Questions(R.string.q5,'b'),
            new Questions(R.string.q6,'b'),
            new Questions(R.string.q7,'d'),
            new Questions(R.string.q8,'c'),
            new Questions(R.string.q9,'a'),
            new Questions(R.string.q10,'c'),
            new Questions(R.string.q11,'b'),
            new Questions(R.string.q12,'a'),
            new Questions(R.string.q13,'c'),
            new Questions(R.string.q14,'b'),
            new Questions(R.string.q15,'d'),
            new Questions(R.string.q16,'a'),
            new Questions(R.string.q17,'d'),
            new Questions(R.string.q18,'b'),
            new Questions(R.string.q19,'a'),
            new Questions(R.string.q20,'c'),
            new Questions(R.string.q21,'c'),
            new Questions(R.string.q22,'b'),
            new Questions(R.string.q23,'c'),
            new Questions(R.string.q24,'a'),
            new Questions(R.string.q25,'b'),
            new Questions(R.string.q26,'b'),
            new Questions(R.string.q27,'b'),
            new Questions(R.string.q28,'d'),
            new Questions(R.string.q29,'b'),
            new Questions(R.string.q30,'c'),
            new Questions(R.string.q31,'c'),
            new Questions(R.string.q32,'a'),
            new Questions(R.string.q33,'c'),
            new Questions(R.string.q34,'b'),
            new Questions(R.string.q35,'d'),
            new Questions(R.string.q36,'a'),
            new Questions(R.string.q37,'d'),
            new Questions(R.string.q38,'a'),
            new Questions(R.string.q39,'b'),
            new Questions(R.string.q40,'c'),
            new Questions(R.string.q41,'b'),
            new Questions(R.string.q42,'c'),
            new Questions(R.string.q43,'c'),
            new Questions(R.string.q44,'d'),
            new Questions(R.string.q45,'a'),
            new Questions(R.string.q46,'b'),
            new Questions(R.string.q47,'c'),
            new Questions(R.string.q48,'c'),
            new Questions(R.string.q49,'b'),
            new Questions(R.string.q50,'a'),
            new Questions(R.string.q51,'b'),
            new Questions(R.string.q52,'b'),
            new Questions(R.string.q53,'d'),
            new Questions(R.string.q54,'b'),
            new Questions(R.string.q55,'b'),
            new Questions(R.string.q56,'d'),
            new Questions(R.string.q57,'c'),
            new Questions(R.string.q58,'b'),
            new Questions(R.string.q59,'a'),
            new Questions(R.string.q60,'a'),
            new Questions(R.string.q61,'d'),
            new Questions(R.string.q62,'c'),
            new Questions(R.string.q63,'d'),
            new Questions(R.string.q64,'d'),
            new Questions(R.string.q65,'b'),
            new Questions(R.string.q66,'c'),
            new Questions(R.string.q67,'d'),
            new Questions(R.string.q68,'d'),
            new Questions(R.string.q69,'b'),
            new Questions(R.string.q70,'a'),
            new Questions(R.string.q71,'b'),
            new Questions(R.string.q72,'a'),
            new Questions(R.string.q73,'d'),
            new Questions(R.string.q74,'b'),
            new Questions(R.string.q75,'d'),
            new Questions(R.string.q76,'d'),
            new Questions(R.string.q77,'b'),
            new Questions(R.string.q78,'c'),
            new Questions(R.string.q79,'d'),
            new Questions(R.string.q80,'d'),
            new Questions(R.string.q81,'b'),
            new Questions(R.string.q82,'c'),
            new Questions(R.string.q83,'c'),
            new Questions(R.string.q84,'a'),
            new Questions(R.string.q85,'b'),
            new Questions(R.string.q86,'d'),
            new Questions(R.string.q87,'a'),
            new Questions(R.string.q88,'b'),
            new Questions(R.string.q89,'d'),
            new Questions(R.string.q90,'b'),
            new Questions(R.string.q91,'d'),
            new Questions(R.string.q92,'b'),
            new Questions(R.string.q93,'b'),
            new Questions(R.string.q94,'b')
    };

    private Questions[] mChoices = new Questions[15];

    SecureRandom mSecureRandom = new SecureRandom();

    Set<Integer> mSet = new HashSet<>();

    public Questions[] shuffledQuestions() {

        while (mSet.size() < 15) {
            int bound = (mSecureRandom.nextInt() % mQuestionStack.length);
            if (bound >= 0)
                mSet.add(bound);
        }

        int count = 0;
        for (Integer n : mSet) {
            mChoices[count] = mQuestionStack[n];
            count++;
        }

        return mChoices;
    }
}
