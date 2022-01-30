package web.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bonuses")
public class Bonus {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "bonus")
    private Integer bonus;

    @ManyToOne
    private Card card;

    public Bonus(Long id, Date date, Integer bonus) {
        this.id = id;
        this.date = date;
        this.bonus = bonus;
    }

    public Bonus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
