package com.diary.diaryproject.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressNo;

    @Column
    private String roadAddress;

    @Column
    private String address;

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
