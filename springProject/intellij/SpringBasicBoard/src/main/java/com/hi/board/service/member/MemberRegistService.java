package com.hi.board.service.member;

import com.hi.board.domain.member.MemberRegistRequest;
import com.hi.board.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
@Log4j2

public class MemberRegistService {
    @Autowired
    private MemberMapper memberMapper;

    // MemberRegistService에서 처리해줘야할것들
    // 1. MemberRegistRequest 객체와 HttpServletRequest객체를 받고
    public int registMember(MemberRegistRequest registRequest,
                            HttpServletRequest request
    ) {
        // 2. 첨부파일이 있으면 파일 저장
        if (registRequest.getUphoto() != null && registRequest.getUphoto().getSize() > 0) {

            // 저장 URI를 구함 =>즉, 폴더
            String uri = "/uploadfile/member";

            // 실제 경로
            String realPath = request.getSession().getServletContext().getRealPath(uri);


            // 이때 새로운 파일이름을 생성해줘야함 :uid_파일이름
            String newFileName = registRequest.getUid() + "_" + registRequest.getUphoto().getOriginalFilename();

            //저장
            File newFile = new File(realPath, newFileName);
            try {
                registRequest.getUphoto().transferTo(newFile);
                // 3. fileName에 새로운 파일 이름을 저장
                registRequest.setFileName(newFileName);

            } catch (IOException e) {
                // throw new RuntimeException(e);
                e.printStackTrace();
            }


        }
        log.info(">>>> Service : registRequest => " + registRequest);

        // 4. mapper에 insert 요청


        return memberMapper.insertMember(registRequest);
    }
}
