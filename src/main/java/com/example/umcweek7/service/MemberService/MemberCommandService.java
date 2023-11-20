package com.example.umcweek7.service.MemberService;

import com.example.umcweek7.domain.Member;
import com.example.umcweek7.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
