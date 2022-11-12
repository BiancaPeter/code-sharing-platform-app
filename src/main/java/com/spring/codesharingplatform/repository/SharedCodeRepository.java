package com.spring.codesharingplatform.repository;

import com.spring.codesharingplatform.model.SharedCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedCodeRepository extends JpaRepository<SharedCode,Long> {

}
