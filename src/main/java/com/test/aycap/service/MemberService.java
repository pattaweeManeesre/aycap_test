package com.test.aycap.service;

import com.test.aycap.api.model.RegisterRequest;
import com.test.aycap.entiry.MobileMember;
import com.test.aycap.exception.BaseException;

import java.util.List;

public interface MemberService {
    MobileMember save(RegisterRequest registerRequest) throws BaseException;
    List<MobileMember> searchInformation(String mobileNo);
    List<MobileMember> findAllMobileMember();
}
