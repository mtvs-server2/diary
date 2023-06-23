package com.diary.diaryproject.domain.aggregate.entity;

import javax.persistence.*;

@Entity
@Table(name = "Board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
