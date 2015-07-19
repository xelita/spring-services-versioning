package com.xelita.study.spring.boot.repository;

import com.xelita.study.spring.boot.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UserV2Repository extends JpaRepository<UserV2, String> {
}
