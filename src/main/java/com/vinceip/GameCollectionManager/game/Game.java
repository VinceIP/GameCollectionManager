package com.vinceip.GameCollectionManager.game;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Game {

    private int id, rating;
    private String name, description, website, metacriticUrl;
    private LocalDate released;
    private String[] alternative_names;
    private boolean userCompleted, userFavorite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMetacriticUrl() {
        return metacriticUrl;
    }

    public void setMetacriticUrl(String metacriticUrl) {
        this.metacriticUrl = metacriticUrl;
    }

    public String[] getAlternative_names() {
        return alternative_names;
    }

    public void setAlternative_names(String[] alternative_names) {
        this.alternative_names = alternative_names;
    }

    public boolean isUserCompleted() {
        return userCompleted;
    }

    public void setUserCompleted(boolean userCompleted) {
        this.userCompleted = userCompleted;
    }

    public boolean isUserFavorite() {
        return userFavorite;
    }

    public void setUserFavorite(boolean userFavorite) {
        this.userFavorite = userFavorite;
    }
}
