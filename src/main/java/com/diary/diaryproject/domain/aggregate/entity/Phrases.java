package com.diary.diaryproject.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "phraseUniqueConstraint",
                          columnNames = {"id", "date"}
        )
})
public class Phrases {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer phraseNo;

    @JoinColumn(name = "id", insertable = false, updatable = false)
    private String id;

    @Column
    private String phrase;

    @Column
    private LocalDate date;
}
