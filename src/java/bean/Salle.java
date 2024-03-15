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
@Table (name = "salle")

public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    private String codesal;
    private String Designation;

    public Salle() {
    }
    
    public Salle(String codesal, String Designation) {
        this.codesal = codesal;
        this.Designation = Designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodesal() {
        return codesal;
    }

    public void setCodesal(String codesal) {
        this.codesal = codesal;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public boolean isOccupeePar(Prof prof) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
