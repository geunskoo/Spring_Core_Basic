package com.geunskoo.core.domain;

public interface MemberRepository {

    //DB에 회원 저장
    void save(Member member);

    //DB 회원 조회
    Member findById(Long memberId);

}
