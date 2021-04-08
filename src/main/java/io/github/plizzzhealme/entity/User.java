package io.github.plizzzhealme.entity;

public class User {

    private Integer id;
    private String email;
    private String name;
    private int year;
    private String sex;
    private Integer pollCount;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getSex() {
        return sex;
    }

    public Integer getPollCount() {
        return pollCount;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPollCount(Integer pollCount) {
        this.pollCount = pollCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", sex='" + sex + '\'' +
                ", pollCount=" + pollCount +
                '}';
    }
}
