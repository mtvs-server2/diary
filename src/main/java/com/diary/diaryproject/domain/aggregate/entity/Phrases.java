package com.diary.diaryproject.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Phrases")
public class Phrases {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer phraseNo;

    @Column
    private String userId;

    @Column
    private Integer emotion;

    @Column
    private String phrase;

    @Column
    private LocalDate createdDate;
}
