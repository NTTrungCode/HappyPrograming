/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author MSI
 */
public class MentorAccount {
    private int id;
    private String ava;
    private String job;
    private String fullName;
    private String dob;
    private String intro;
    private String achivement;   

    public MentorAccount() {
    }

    public MentorAccount(int id, String ava,String job, String fullName, String dob, String intro, String achivement) {
        this.id = id;
        this.ava = ava;
        this.job = job;
        this.fullName = fullName;
        this.dob = dob;
        this.intro = intro;
        this.achivement = achivement;
    }

    public int getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAchivement() {
        return achivement;
    }

    public void setAchivement(String achivement) {
        this.achivement = achivement;
    }
    
}


