package com.api.tfmkt.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigInteger;

@Getter
@Entity
@Table(name = "transfers")
public class Transfer {
    @EmbeddedId
    private TransferPK id;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @MapsId("playerID")
    @JoinColumn(name = "player_id", referencedColumnName = "id", insertable = false, updatable = false,
            nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Player player;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @MapsId("leftClubID")
    @JoinColumn(name = "left_club_id", referencedColumnName = "id", insertable = false, updatable = false,
            nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Club leftClub;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @MapsId("joinedClubID")
    @JoinColumn(name = "joined_club_id", referencedColumnName = "id", insertable = false, updatable = false,
            nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Club joinedClub;

    @Column(name = "transfer_fee")
    private BigInteger fee;

    @Column(name = "transfer_type")
    private String type;
}
