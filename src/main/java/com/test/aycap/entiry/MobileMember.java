package com.test.aycap.entiry;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MobileMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String referenceCode;

    @Column
    private String mobileNo;

    @Enumerated(EnumType.STRING)
    @Column
    private MemberType memberType;
}
