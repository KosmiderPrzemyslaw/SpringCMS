package pl.kosmider.POJO;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private String notes;
    private boolean reciveMessages;
    private String[] skills;

    public Student(String firstName, String lastName, String notes, boolean reciveMessages, String[] skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = notes;
        this.reciveMessages = reciveMessages;
        this.skills = skills;
    }

    public Student(String firstName, String lastName, String notes, boolean reciveMessages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = notes;
        this.reciveMessages = reciveMessages;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isReciveMessages() {
        return reciveMessages;
    }

    public void setReciveMessages(boolean reciveMessages) {
        this.reciveMessages = reciveMessages;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public Student(String firstName, String lastName, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = notes;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return reciveMessages == student.reciveMessages &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(notes, student.notes) &&
                Arrays.equals(skills, student.skills);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName, notes, reciveMessages);
        result = 31 * result + Arrays.hashCode(skills);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
