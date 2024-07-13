package com.api.tfmkt.models;

import com.api.tfmkt.enums.TransferTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@Entity
@Table(name = "transfers")
public class Transfer {
    @EmbeddedId
    private TransferPK id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("playerID")
    @JoinColumn(name = "player_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("leftClubID")
    @JoinColumn(name = "left_club_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Club leftClub;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("joinedClubID")
    @JoinColumn(name = "joined_club_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Club joinedClub;

    @Column(name = "transfer_fee")
    private BigInteger fee;

    @Column(name = "transfer_type")
    private Integer type;
}
