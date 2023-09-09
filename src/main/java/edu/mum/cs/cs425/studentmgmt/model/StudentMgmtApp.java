package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class StudentMgmtApp {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("my-persistence-unit");

    public static void main(String[] args) {
        Transcript transcript = new Transcript();
        transcript.setDegreeTitle("BS Computer Science");

        Classroom classroom = new Classroom();
        classroom.setBuildingName("McLaughlin building");
        classroom.setRoomNumber("M105");

        Student s1 = new Student();
        s1.setStudentNumber("000-61-0001");
        s1.setFirstName("Anna");
        s1.setMiddleName("Lynn");
        s1.setLastName("Smith");
        s1.setCgpa(3.45);
        s1.setDateOfEnrollment(LocalDate.of(2019, 5, 24));
        s1.setTranscript(transcript);
        s1.setClassroom(classroom);

        saveStudent(s1);
    }


    public static void saveStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
