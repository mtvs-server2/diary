package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.aggregate.entity.Address;
import com.diary.diaryproject.domain.dto.AddressDTO;
import com.diary.diaryproject.domain.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MapService {
    private final MapRepository mapRepository;


    @Transactional
    public void saveToRepository(AddressDTO addr, String id) {
        Address address = new Address(addr.getAddress(), addr.getRoadAddress(), id);

        mapRepository.save(address);
    }

    @Transactional
    public Address loadToRepository(String id) {
        Address address = mapRepository.findTopByUserIdOrderByAddressNoDesc(id);
        return address;
    }
}
