package com.api.tfmkt.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

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

    @ManyToOne
    @JoinColumn(name = "id_current_league", referencedColumnName = "id")
    private League currentLeague;

    @Column(name = "current_mv")
    private BigInteger currentMarketValue;
}
