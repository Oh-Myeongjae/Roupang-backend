package com.teamsupercat.roupangbackend.entity;

import com.teamsupercat.roupangbackend.dto.seller.SellerRequest;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Member", schema = "supercat")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Integer id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Lob
    @Column(name = "member_img", nullable = false)
    private String memberImg;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "user_point")
    private Long userPoint;



}

