package com.geunskoo.core.domain;

import java.util.HashMap;

public class MemoryMemberRepository implements MemberRepository {
    private static HashMap<Long, Member> store = new HashMap<>(); //ConcurrentHashMap 사용을 권장.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
