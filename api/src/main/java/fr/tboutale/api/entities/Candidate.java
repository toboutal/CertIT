package fr.tboutale.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Candidate {
    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String password;
}
