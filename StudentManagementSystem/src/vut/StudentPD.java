package vut;

import java.util.ArrayList;

public class StudentPD {

    private String initials, surname, studentNumber;

    public StudentPD() {
        this("None", "None", "210024275");
    }

    public StudentPD(String initials, String surname, String studentNumber) {
        setInitials(initials);
        setSurname(surname);
        setStudentNumber(studentNumber);
    }

    /**
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * @param initials the initials to set
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the studentNumber
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * @param studentNumber the studentNumber to set
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "initials: " + initials + ", surname: " + surname + ", studentNumber: " + studentNumber + '\n';
    }

    public void openConnection() {
        StudentDA.initializeConnection();
    }

    public void addStudent(StudentPD studentObj) {
        StudentDA.addStudent(studentObj);
    }

    public ArrayList<StudentPD> getAll() {
        return StudentDA.getAll();
    }

    public void deleteStudent(String studentNo) {
        StudentDA.removeStudent(studentNo);
    }
    
    

}
