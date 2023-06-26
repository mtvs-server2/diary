//package com.diary.diaryproject.domain.service;
//
//import com.diary.diaryproject.config.BeanConfiguration;
//import com.diary.diaryproject.config.JpaConfiguration;
//import com.diary.diaryproject.domain.DiaryProjectApplication;
//import com.diary.diaryproject.domain.aggregate.entity.Address;
//import com.diary.diaryproject.domain.repository.MapRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import javax.transaction.Transactional;
//
////@Transactional
//@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
//@SpringBootTest
////@RequiredArgsConstructor
//public class MapServiceTests {
//
//    @Autowired
//    private MapRepository mapRepository;
//
//    @Test
//    void init() {}
//
////    public MapServiceTests(MapRepository mapRepository) {
////        this.mapRepository = mapRepository;
////    }
//
//
//    @Test
//    public void mapInDB(){
//        String address = "경기도";
//        String roadAddress = "미미로";
//
//        Address address1 = new Address(address, roadAddress);
//
//        Address addr = mapRepository.save(address1);
//
//        Assertions.assertNotNull(addr);
//    }
//}
