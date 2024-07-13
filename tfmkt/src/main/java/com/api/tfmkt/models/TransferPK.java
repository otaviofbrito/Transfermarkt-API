package com.api.tfmkt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TransferPK implements Serializable {
    @Column(name = "player_id")
    protected Long playerID;
    @Column(name = "left_club_id")
    protected Long leftClubID;
    @Column(name = "joined_club_id")
    protected Long joinedClubID;
    @Column(name = "year")
    protected Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferPK that = (TransferPK) o;
        return Objects.equals(playerID, that.playerID) &&
                Objects.equals(leftClubID, that.leftClubID) &&
                Objects.equals(joinedClubID, that.joinedClubID) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerID, leftClubID, joinedClubID, year);
    }
}
