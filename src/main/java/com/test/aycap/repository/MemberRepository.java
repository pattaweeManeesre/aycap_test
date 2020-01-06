package com.test.aycap.repository;

import com.test.aycap.entiry.MobileMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<MobileMember, Long> {

    List<MobileMember> findByMobileNo(String mobileNo);
}
