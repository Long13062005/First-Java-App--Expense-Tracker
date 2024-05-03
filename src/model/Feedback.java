/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TechCare
 */
public class Feedback {
    private int id;
    private int userID;
    private String description;

    public Feedback(int id, int userID, String description) {
        this.id = id;
        this.userID = userID;
        this.description = description;
    }

    public Feedback() {
    }

    public Feedback(int userID, String description) {
        this.userID = userID;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   }
