package com.diary.diaryproject.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Phrases")
public class Phrases {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer phraseNo;

    @Column
    private Integer emotion;

    @Column
    private String phrase;
}
