package com.api.tfmkt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
public class ClubLeaguePK implements Serializable {
    private Long clubID;
    private String leagueID;
    @Column(name = "season")
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubLeaguePK that = (ClubLeaguePK) o;
        return Objects.equals(clubID, that.clubID) &&
                Objects.equals(leagueID, that.leagueID) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubID, leagueID, year);
    }
}
