package io.github.plizzzhealme.entity;

public class Poll {

    private int id;
    private String question;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }
}
