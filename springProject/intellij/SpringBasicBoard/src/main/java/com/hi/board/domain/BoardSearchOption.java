package com.hi.board.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoardSearchOption {

    private String searchType;
    private String keyword;

}
