package com.spring.codesharingplatform.service;

import com.spring.codesharingplatform.CreatedDateComparator;
import com.spring.codesharingplatform.DTO.SharedCodeResponseDTO;
import com.spring.codesharingplatform.model.SharedCode;
import com.spring.codesharingplatform.repository.SharedCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SharedCodeService {
    private SharedCodeRepository sharedCodeRepository;

    @Autowired
    public SharedCodeService(SharedCodeRepository sharedCodeRepository) {
        this.sharedCodeRepository = sharedCodeRepository;
    }

    public SharedCode addSharedCode(SharedCode sharedCode) {
        sharedCode.setCreatedDate(LocalDateTime.now());
        return sharedCodeRepository.save(sharedCode);
    }

    public SharedCodeResponseDTO getSharedCode(Long codeId) {
        SharedCode foundSharedCode = sharedCodeRepository.findById(codeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "sharedCode not found"));
        if (foundSharedCode.isPublic()) {
            return new SharedCodeResponseDTO(foundSharedCode, 0L, false);
        }
        if (foundSharedCode.isExpired()) {
            sharedCodeRepository.delete(foundSharedCode);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "shared code cannot be viewed anymore");
        }
        foundSharedCode.setViews(foundSharedCode.getViews() - 1);
        SharedCodeResponseDTO sharedCodeResponseDTO = new SharedCodeResponseDTO(foundSharedCode, foundSharedCode.getTimeLeft(), true);
        sharedCodeRepository.save(foundSharedCode);
        return sharedCodeResponseDTO;
    }

    public List<SharedCode> getLatestSharedCodes() {
        List<SharedCode> foundSharedCodeList = sharedCodeRepository.findAll();
        List<SharedCode> latestFiveCodes = new ArrayList<>();
        List<SharedCode> sortedSharedCodeList = foundSharedCodeList.stream().sorted(new CreatedDateComparator().reversed()).collect(Collectors.toList());
//      Collections.sort(foundSharedCodeList, new CreatedDateComparator().reversed());
        for (int i = 0; i < 5; i++) {
            latestFiveCodes.add(sortedSharedCodeList.get(i));
//          latestFiveCodes.add(foundSharedCodeList.get(i));
        }
        return latestFiveCodes;
    }

}
