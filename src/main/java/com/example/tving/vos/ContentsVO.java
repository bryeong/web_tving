package com.example.tving.vos;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContentsVO {
    private String name;
    private byte order;
    private String title;
    private String introduce;
    private LocalDate airingDate;
    private short runningTime;
}
