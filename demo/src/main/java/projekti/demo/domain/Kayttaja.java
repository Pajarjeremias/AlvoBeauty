package projekti.demo.domain;

import jakarta.persistence.*;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="kayttaja")
public class Kayttaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kayt_id",nullable=false,unique=true)
    private Long kaytId;

    @Column(name="username", nullable=false)
    private String username;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="role")
    private String role;

    public Kayttaja() {
    }

    public Kayttaja(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getKaytId() {
        return kaytId;
    }

    public void setKaytId(Long kaytId) {
        this.kaytId = kaytId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}