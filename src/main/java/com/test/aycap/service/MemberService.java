package com.test.aycap.service;

import com.test.aycap.api.model.RegisterRequest;
import com.test.aycap.entiry.MobileMember;

import java.util.List;

public interface MemberService {
    MobileMember save(RegisterRequest registerRequest);
    List<MobileMember> searchInformation(String mobileNo);
    List<MobileMember> findAllMobileMember();
}
