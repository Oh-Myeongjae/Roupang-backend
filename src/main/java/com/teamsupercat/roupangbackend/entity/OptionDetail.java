package com.teamsupercat.roupangbackend.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "option_detail", schema = "supercat")
public class OptionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_idx", nullable = false)
    private Product productIdx;

    @Column(name = "option_detail_name", nullable = false)
    private String optionDetailName;

    @Column(name = "option_type_idx", nullable = false)
    private Integer optionTypeIdx;

    @Column(name = "option_type_name_idx", nullable = false)
    private Integer optionTypeNameIdx;

    public OptionDetail(Product product, String optionDetailName, Integer optionTypeIdx, Integer optionTypeNameIdx){
        this.productIdx = product;
        this.optionDetailName = optionDetailName;
        this.optionTypeIdx = optionTypeIdx;
        this.optionTypeNameIdx = optionTypeNameIdx;
    }

}
