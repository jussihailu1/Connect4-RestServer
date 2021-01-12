package nl.fhict.restserver.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Getter
    private String username;

    @Getter
    private String password;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Player() {

    }

//    public Integer getId() {
//        return id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
}
