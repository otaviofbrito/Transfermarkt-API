package com.api.tfmkt.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigInteger;

@Getter
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    private Long id;
    private String url;
    @Column(name = "club_name")
    private String name;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_current_league", referencedColumnName = "id",
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private League currentLeague;

    @Column(name = "current_mv")
    private BigInteger currentMarketValue;
}
