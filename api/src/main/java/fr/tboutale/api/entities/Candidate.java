package fr.tboutale.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Candidate extends AbstractEntity {
    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
