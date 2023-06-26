package com.diary.diaryproject.domain.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressDTO {
    private String roadAddress;
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
