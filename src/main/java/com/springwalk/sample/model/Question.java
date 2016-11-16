package com.springwalk.sample.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by jgonzalezg on 19/10/2016.
 */
public class Question {
    private String questionId;
    private String answer;
    private List<RequestError> error = new ArrayList<RequestError>();

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
     */
    public String getAnswer() {
        return answer;
    }

    /**
     *
     * @param answer
     * The answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

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
}
