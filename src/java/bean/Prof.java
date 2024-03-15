/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.persistence.*;

/**
 *
 * @author Bota
 */
@Entity
@Table(name = "prof")
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    private String codeprof;
    private String nom;
    private String prenom;
    private String grade;

    public Prof() {
    }

    public Prof(String codeprof, String nom, String prenom, String grade) {
        this.codeprof = codeprof;
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
    }

   


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCodeprof() {
        return codeprof;
    }

    public void setCodeprof(String codeprof) {
        this.codeprof = codeprof;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
    
}
