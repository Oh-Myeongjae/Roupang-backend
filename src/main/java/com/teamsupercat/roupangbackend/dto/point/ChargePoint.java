package com.teamsupercat.roupangbackend.dto.point;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
public class ChargePoint {

    @Setter
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @JsonProperty("충전포인트")
        private Long chargePoint;

        @JsonProperty("결제 금액")
        private Long transactionAmount;

        @JsonProperty("결제수단 번호")
        private Integer paymentMethodIdx;

    }

    @Setter
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private Integer memberIdx;
        private String email;
        private Integer paymentMethodIdx;
        private String transactionType;
        private Integer transactionAmount;
        private Instant transactionDate;
        private Long remainingPoints;
        private Long chargePoint;
        private Long userPoint;

        public static Response from(PointDto pointDto){

            return Response.builder()
                    .memberIdx(pointDto.getMemberIdx())
                    .email(pointDto.getEmail())
                    .paymentMethodIdx(pointDto.getPaymentMethodIdx())
                    .transactionType(pointDto.getTransactionType())
                    .transactionAmount(pointDto.getPaymentIdx())
                    .transactionDate(pointDto.getTransactionDate())
                    .remainingPoints(pointDto.getRemainingPoints())
                    .chargePoint(pointDto.getChargePoint())
                    .userPoint(pointDto.getUserPoint())
                    .build();
        }

    }
}
