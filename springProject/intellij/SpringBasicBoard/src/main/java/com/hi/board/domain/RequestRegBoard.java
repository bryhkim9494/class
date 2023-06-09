package com.hi.board.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class RequestRegBoard { // RequestRegBoard클래스는 커맨드클래스임
    private String title;
    private String content;
    // 회원제 게시판 작성자는 private String writerdptj memidx로 변경
//    private String writer;
    private int memidx;

    // 파일 업로드를 위해서 변수 2개 추가함
    private MultipartFile file; // 사용자로부터 받는 파일 객체
    private String filename; // DB에 저장할 File 이름


}
