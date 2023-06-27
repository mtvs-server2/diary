//package com.diary.diaryproject.domain.repository;
//
//import com.diary.diaryproject.domain.aggregate.entity.User;
//
//import javax.persistence.EntityManager;
//import java.util.Optional;
//
//public class JpaUserRepository implements UserRepository {
//    private final EntityManager em;
//
//    public JpaUserRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public User save(User user) {
//        em.persist(user);   // .persist를 사용함으로써 연동된 db에 매개변수로 온 user가 db에 저장이된다(jpa가 알아서 쿼리 실행)
//        return user;
//    }
//
//    @Override
//    public Optional<User> findById(String id) {
//        User user = em.find(User.class, id);
//        return Optional.ofNullable(user);
//    }
//}
