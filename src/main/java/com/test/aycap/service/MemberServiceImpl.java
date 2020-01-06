package com.test.aycap.service;

import com.test.aycap.api.model.RegisterRequest;
import com.test.aycap.entiry.MemberType;
import com.test.aycap.entiry.MobileMember;
import com.test.aycap.exception.BaseException;
import com.test.aycap.exception.ErrorCode;
import com.test.aycap.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public MobileMember save(RegisterRequest registerRequest) throws BaseException {

        MobileMember mobileMember = new MobileMember();
        mobileMember.setMobileNo(registerRequest.getMobileNo());
        mobileMember.setSalary(registerRequest.getSalary());
        mobileMember.setReferenceCode(this.generateReferenceCode(registerRequest.getMobileNo()));
        mobileMember.setMemberType(this.findMemberType(registerRequest.getSalary()));

        return memberRepository.save(mobileMember);
    }

    @Override
    public List<MobileMember> searchInformation(String mobileNo) {
        return memberRepository.findByMobileNo(mobileNo);
    }

    @Override
    public List<MobileMember> findAllMobileMember() {
        List<MobileMember> list = new ArrayList<>();
        memberRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    private MemberType findMemberType(Double salary) throws BaseException {
        if(salary == null || salary < 15000){
            throw new BaseException(new ErrorCode("0001","salary lower than 15000"));
        }else if(salary < 30000){
            return MemberType.Silver;
        }else if(salary < 50000){
            return MemberType.Gold;
        }else{
            return MemberType.Platinum;
        }
    }

    private String generateReferenceCode(String mobileNo) throws BaseException {
        if(mobileNo == null || mobileNo.length() != 10){
            throw new BaseException(new ErrorCode("0002","mobile number incorrect"));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDD");
        return simpleDateFormat.format(new Date()) + mobileNo.substring(6);
    }
}
