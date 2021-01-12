package nl.fhict.restserver.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Getter
    private Integer wins;

    @Getter
    private Integer draws;

    @Getter
    private Integer losses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerid")
    @Getter
    private Player player;

    public Record() {

    }

    public Record(Player player) {
        this.player = player;
        wins = 0;
        draws = 0;
        losses = 0;
    }

    public void addWin() {
        wins++;
    }

    public void addDraw() {
        draws++;
    }

    public void addLoss() {
        losses++;
    }
}
