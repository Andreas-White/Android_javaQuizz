package com.bafdev.javaquizz;

public class Questions {

    private int mQuestionId;
    private char mAnswer;

    public Questions(int questionId, char answer) {
        this.mQuestionId = questionId;
        this.mAnswer = answer;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public char getAnswer() {
        return mAnswer;
    }
}
