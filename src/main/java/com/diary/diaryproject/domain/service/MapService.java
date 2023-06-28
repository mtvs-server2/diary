package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.aggregate.entity.Address;
import com.diary.diaryproject.domain.dto.AddressDTO;
import com.diary.diaryproject.domain.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MapService {
    private final MapRepository mapRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AddressDTO saveToRepository(AddressDTO addr, String id) {
        LocalDate date = LocalDate.parse(addr.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Address address = new Address(addr.getAddress(), addr.getRoadAddress(), id, date);

        Address result =  mapRepository.save(address);

        AddressDTO res =  modelMapper.map(result, AddressDTO.class);
//        AddressDTO res = new AddressDTO();
//        res.setAddressNo(result.get);

        return res;
    }

    @Transactional
    public Address loadToRepository(String id) {
        Address address = mapRepository.findTopByUserIdOrderByAddressNoDesc(id);
        return address;
    }
}
