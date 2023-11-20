package com.example.umcweek7.web.controller;

import com.example.umcweek7.apiPayload.ApiResponse;
import com.example.umcweek7.converter.MemberConverter;
import com.example.umcweek7.domain.Member;
import com.example.umcweek7.service.MemberService.MemberCommandService;
import com.example.umcweek7.web.dto.MemberRequestDTO;
import com.example.umcweek7.web.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}