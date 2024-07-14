package com.api.tfmkt.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Entity
@Table(name = "players")
public class Player {
    @Id
    private Long id;
    private String url;
    private String name;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "birth_date")
    private Date birthdate;
    @Column(name = "death_date")
    private Date deathdate;
    private Integer height;
    @Column(name = "citizenship_1")
    private String primaryCitizenship;
    @Column(name = "citizenship_2")
    private String secondaryCitizenship;
    private String foot;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_club_id", referencedColumnName = "id",
            nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Club currentClub;

    private String outfitter;
    @Column(name = "main_position")
    private String position;
    @Column(name = "current_mv")
    private BigInteger currentMarketValue;

}
