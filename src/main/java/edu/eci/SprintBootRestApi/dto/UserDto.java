package edu.eci.SprintBootRestApi.dto;

public class UserDto {
    private String name;
    private String email;
    private String lastName;
    private String createdAt;

    public UserDto(String name, String email, String lastName, String createdAt) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
