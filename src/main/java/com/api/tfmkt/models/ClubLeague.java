package com.api.tfmkt.models;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigInteger;

@Entity
@Table(name = "club_league")
public class ClubLeague {
    @EmbeddedId
    private ClubLeaguePK id;

    @NotFound(action = NotFoundAction.IGNORE)
    @MapsId("clubID")
    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "id", insertable = false, updatable = false,
            nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Club club;

    @NotFound(action = NotFoundAction.IGNORE)
    @MapsId("leagueID")
    @ManyToOne
    @JoinColumn(name = "league_id", referencedColumnName = "id", insertable = false, updatable = false,
            nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private League league;

    @Column(name = "squad")
    private Integer squadNumber;

    @Column(name = "market_value")
    private BigInteger marketValue;
}
