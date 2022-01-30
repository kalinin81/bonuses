package web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency")
    private Short currency;

    @Column(name = "number")
    private Integer number;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="card_id")
    private Set<Bonus> bonuses;

    @ManyToOne
    private Client client;

    public Card(Long id, Short currency, Integer number) {
        this.id = id;
        this.currency = currency;
        this.number = number;
    }

    public Card() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getCurrency() {
        return currency;
    }

    public void setCurrency(Short currency) {
        this.currency = currency;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(Set<Bonus> bonuses) {
        this.bonuses = bonuses;
    }
}
