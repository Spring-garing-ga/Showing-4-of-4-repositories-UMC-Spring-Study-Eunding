package com.example.umcweek7.repository;

import com.example.umcweek7.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
