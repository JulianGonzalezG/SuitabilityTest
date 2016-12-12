package com.springwalk.sample.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by jgonzalezg on 19/10/2016.
 */
public class Question {
    private String questionId;
    //private String answer;
    private List<CRAN_VEC_ADV_ProcessSTAnswer_CLS> answers = new ArrayList<>();
    private List<CRAN_VEC_ADV_ProcessSTMatrixAnswer_CLS> matrixAnswers = new ArrayList<>();
    private List<RequestError> error = new ArrayList<>();

    /**
     *
     * @return
     * The questionId
     */
    public String getQuestionId() {
        return questionId;
    }

    /**
     *
     * @param questionId
     * The questionId
     */
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    /**
     *
     * @return
     * The answer
     *//*
    public String getAnswer() {
        return answer;
    }

    *//**
     *
     * @param answer
     * The answer
     *//*
    public void setAnswer(String answer) {
        this.answer = answer;
    }*/

    /**
     *
     * @return
     * The error
     */
    public List<RequestError> getError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(List<RequestError> error) {
        this.error = error;
    }

    /**
     *
     * @return
     * The Answers
     */
    public List<CRAN_VEC_ADV_ProcessSTAnswer_CLS> getAnswers() {
        return answers;
    }

    /**
     *
     * @param answers
     * The answers
     */
    public void setAnswers(List<CRAN_VEC_ADV_ProcessSTAnswer_CLS> answers) {
        this.answers = answers;
    }

    public List<CRAN_VEC_ADV_ProcessSTMatrixAnswer_CLS> getMatrixAnswers() {
        return matrixAnswers;
    }

    public void setMatrixAnswers(List<CRAN_VEC_ADV_ProcessSTMatrixAnswer_CLS> matrixAnswers) {
        this.matrixAnswers = matrixAnswers;
    }
}
