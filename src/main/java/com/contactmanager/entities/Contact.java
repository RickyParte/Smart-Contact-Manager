package com.contactmanager.entities;

import jakarta.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contactId;
    private String contactName;
    private String contactNickName;
    @Column(unique = true)
    private String contactEmail;
    private String contactWork;
    private String contactPhone;
    @Column(length = 1000)
    private String description;
    private String imageUrl;

    @ManyToOne
    private User user;

    public Contact(int contactId, String contactName, String contactNickName, String contactEmail, String contactWork, String contactPhone, String description, String imageUrl) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactNickName = contactNickName;
        this.contactEmail = contactEmail;
        this.contactWork = contactWork;
        this.contactPhone = contactPhone;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNickName() {
        return contactNickName;
    }

    public void setContactNickName(String contactNickName) {
        this.contactNickName = contactNickName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactWork() {
        return contactWork;
    }

    public void setContactWork(String contactWork) {
        this.contactWork = contactWork;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
