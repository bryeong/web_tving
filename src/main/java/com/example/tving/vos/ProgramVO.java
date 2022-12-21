package com.example.tving.vos;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProgramVO {
    private String name;
    private int age;
    private String time;
    private String genre;
    private String distributor;
    private String introduce;
    private String classification;
}
