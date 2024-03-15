/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Bota
 */
@Entity
@Table (name = "occuper")
public class Occuper {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_prof")
    private Prof prof;
    
    @ManyToOne
    @JoinColumn(name = "id_sal")
    private Salle salle;
    private Date date;

    public Occuper() {
    }

    public Occuper(Prof prof, Salle salle, Date date) {
        this.prof = prof;
        this.salle = salle;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
