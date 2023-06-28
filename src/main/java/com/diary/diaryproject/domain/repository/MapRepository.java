package com.diary.diaryproject.domain.repository;

import com.diary.diaryproject.domain.aggregate.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MapRepository extends JpaRepository<Address, Integer> {
    Address findTopByUserIdOrderByAddressNoDesc(String id);

    Optional<Address> findByRoadAddressAndDate(String address, LocalDate date);
}

