package fasttrackit.trip_shop.domain;


import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    @GeneratedValue
    private  long id;
@NotNull
     private String vacanteRomania;
@NotNull
     private  String vacanteStrainatate;
@NotNull
     private String bileteDeAvion;
@NotNull
     private int perioada;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVacanteRomania() {
        return vacanteRomania;
    }

    public void setVacanteRomania(String vacanteRomania) {
        this.vacanteRomania = vacanteRomania;
    }

    public String getVacanteStrainatate() {
        return vacanteStrainatate;
    }

    public void setVacanteStrainatate(String vacanteStrainatate) {
        this.vacanteStrainatate = vacanteStrainatate;
    }

    public String getBileteDeAvion() {
        return bileteDeAvion;
    }

    public void setBileteDeAvion(String bileteDeAvion) {
        this.bileteDeAvion = bileteDeAvion;
    }

    public int getPerioada() {
        return perioada;
    }

    public void setPerioada(int perioada) {
        this.perioada = perioada;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", vacanteRomania='" + vacanteRomania + '\'' +
                ", vacanteStrainatate='" + vacanteStrainatate + '\'' +
                ", bileteDeAvion='" + bileteDeAvion + '\'' +
                ", perioada=" + perioada +
                '}';
    }
}
