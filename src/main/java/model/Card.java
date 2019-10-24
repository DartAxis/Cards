package model;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @Column(name = "tema")
    private String tema;

    public Card() {
    }

    public Card(String title, String text, String tema) {
        this.title = title;
        this.text = text;
        this.tema = tema;
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getTema() {
        return tema;
    }
}
