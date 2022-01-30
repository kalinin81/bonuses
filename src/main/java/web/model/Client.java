package web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Set<Card> cards;

    public Client(Long id, String name, Set<Card> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }
}
