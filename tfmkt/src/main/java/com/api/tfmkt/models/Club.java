package com.api.tfmkt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    private BigInteger id;
    private String url;
    @Column(name = "club_name")
    private String name;
    @Column(name = "id_current_league")
    private String currentLeagueID;
    @Column(name = "current_mv")
    private BigInteger currentMarketValue;
}
