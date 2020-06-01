/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QPBean;

/**
 *
 * @author Abha Suntwal
 */
public class table {
    
    private String id;
    private String question;
    private String discrimination; 
    private String time;
    private String difficulty;
    private String marks;
    private String relevancy;
    private String frequency;
    private String year;

    public table(String id, String question, String discrimination, String time, String difficulty, String marks, String relevancy, String frequency, String year) {
        this.id = id;
        this.question = question;
        this.discrimination = discrimination;
        this.time = time;
        this.difficulty = difficulty;
        this.marks = marks;
        this.relevancy = relevancy;
        this.frequency = frequency;
        this.year = year;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDiscrimination() {
        return discrimination;
    }

    public void setDiscrimination(String discrimination) {
        this.discrimination = discrimination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getRelevancy() {
        return relevancy;
    }

    public void setRelevancy(String relevancy) {
        this.relevancy = relevancy;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
}
