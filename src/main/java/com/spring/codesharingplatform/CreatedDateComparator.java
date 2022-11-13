package com.spring.codesharingplatform;

import com.spring.codesharingplatform.model.SharedCode;

import java.time.LocalDateTime;
import java.util.Comparator;

public class CreatedDateComparator implements Comparator<SharedCode> {
    @Override
    public int compare(SharedCode sharedCode1, SharedCode sharedCode2) {
        return sharedCode1.getCreatedDate().compareTo(sharedCode2.getCreatedDate());
    }
}
