package com.teamsupercat.roupangbackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Grouped_order", schema = "supercat")
public class GroupedOrder {
    @Id
    @Column(name = "single_order_idx", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "single_order_idx", nullable = false)
    private SingleOrder singleOrders;

    @Column(name = "grouped_id", nullable = false)
    private String groupedId;

}