package com.hi.board.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
public class PageOption {
    private BoardSearchOption searchOption;
    private int startNum;
    private int count;

}
