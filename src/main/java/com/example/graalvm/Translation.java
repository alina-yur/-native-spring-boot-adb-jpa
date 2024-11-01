package com.example.graalvm;

import jakarta.persistence.*;

@Entity
@Table(name = "TRANSLATION")
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "translation_seq")
    @SequenceGenerator(name = "translation_seq", sequenceName = "TRANSLATION_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String english;

    @Column(nullable = false)
    private String translation;

    public Translation() {
    }

    public Translation(String english, String translation) {
        this.english = english;
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}