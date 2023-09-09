package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.*;

@Entity
@Table(name = "transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transcriptId;

    @Column(nullable = false)
    private String degreeTitle;

    @OneToOne(mappedBy = "transcript", cascade = CascadeType.ALL)
    private Student student;

    public Transcript(long transcriptId, String degreeTitle, Student student) {
        this.transcriptId = transcriptId;
        this.degreeTitle = degreeTitle;
        this.student = student;
    }

    public Transcript() {

    }

    public long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
