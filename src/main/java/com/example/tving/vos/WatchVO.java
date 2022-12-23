package com.example.tving.vos;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WatchVO {
    private String userID;
    private String programName;
    private String title;
    private byte watchOrder;
    private LocalDateTime watchDate;

}
