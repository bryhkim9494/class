package org.example.service;

import org.example.dao.Dao;
import org.example.domain.Member;
import org.example.domain.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

public class MemberRegisterService {

    @Autowired
    @Qualifier("member")
    private Dao dao;
    // 생성자를 통해서 Dao를 주입

//    public MemberRegisterService(Dao dao) { // new MemberDao
//        this.dao = dao;
//    }


    //setter 메소드 이용해서 Dao를 주입

//    public void setDao(Dao dao) {
//        this.dao = dao;
//    }

    // 등록 처리해주는 메소드: RegisterRequest(email,password, confirmPassword,name)
    public void regist(RegisterRequest request) {

        // 이메일 존재 여부 확인 : map저장시 email을 key값으로 사용
        Member member  = dao.selectByEmail(request.getEmail()); //Member 객체를 반환하거나 해당 key의 값이 없으면 null이 나옴
        if(member !=null) {
            System.out.println("중복되는 이메일이 있습니다. 다시 시도해주세요.");
            return;
        }

        // 저장을 하기위한 Member객체를 생성
        Member newMember = new Member();
        newMember.setEmail(request.getEmail());
        newMember.setPassword(request.getPassword());
        newMember.setName(request.getName());
        newMember.setRegDate(new Date());

        // dao => 저장
        dao.insert(newMember);
        System.out.println("저장 되었습니다.");



    }


}
