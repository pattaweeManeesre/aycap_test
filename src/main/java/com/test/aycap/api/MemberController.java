package com.test.aycap.api;

import com.test.aycap.api.model.RegisterRequest;
import com.test.aycap.entiry.MobileMember;
import com.test.aycap.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MemberController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberService memberService;

    @GetMapping(value = "/getAllUser")
    public List<MobileMember> getAllUser(){
        return memberService.findAllMobileMember();
    }

    @GetMapping(value = "/getInformation")
    public List<MobileMember> getInformation(@RequestParam(required = true) String mobileNo){
        return memberService.searchInformation(mobileNo);
    }

    @PostMapping(value = "/register")
    public MobileMember register(@RequestBody RegisterRequest registerRequest){
        LOG.info("registerRequest : {}",registerRequest);
        return memberService.save(registerRequest);
    }

}
