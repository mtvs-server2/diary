package com.diary.diaryproject.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressNo;

    @Column
    private String roadAddress;

    @Column
    private String address;

    @Column
    private String userId;

    @Column
    private LocalDate date;

    public Address(String roadAddress, String address, String userId, LocalDate date) {
        this.roadAddress = roadAddress;
        this.address = address;
        this.userId = userId;
        this.date = date;
    }
}
