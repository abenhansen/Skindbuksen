package com.example.demo;

//En klasse for Brugere i systemet, her sætter Brugerrepository alt sin data ind
public class Bruger {
    private Long id;
    private String username;
    private String password;
    private String roles;
    private boolean enabled;

    public Bruger(){

    }

    public Bruger(Long id, String username, String password, String roles, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.enabled = enabled;
    }

    public Bruger(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

