package com.example.umcweek7.service.MemberService;

import com.example.umcweek7.apiPayload.code.status.ErrorStatus;
import com.example.umcweek7.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umcweek7.converter.MemberConverter;
import com.example.umcweek7.converter.MemberPreferConverter;
import com.example.umcweek7.domain.FoodCategory;
import com.example.umcweek7.domain.Member;
import com.example.umcweek7.domain.mapping.MemberPrefer;
import com.example.umcweek7.repository.FoodCategoryRepository;
import com.example.umcweek7.repository.MemberRepository;
import com.example.umcweek7.web.dto.MemberRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}