package com.api.tfmkt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigInteger;

@Entity
@Table(name = "leagues")
@Getter
public class League {
    @Id
    private String id;
    private String url;
    @Column(name = "league_name")
    private String name;
    private String country;
    @Column(name = "current_mv")
    private BigInteger current_market_value;
}
