package com.spring.codesharingplatform.DTO;

import com.spring.codesharingplatform.model.SharedCode;

public class SharedCodeResponseDTO {

    private SharedCode sharedCode;

    private Long timeLeft;

    private boolean isPrivate;

    public SharedCodeResponseDTO(SharedCode sharedCode, Long timeLeft, boolean isPrivate) {
        this.sharedCode = sharedCode;
        this.timeLeft = timeLeft;
        this.isPrivate = isPrivate;
    }

    public SharedCode getSharedCode() {
        return sharedCode;
    }

    public void setSharedCode(SharedCode sharedCode) {
        this.sharedCode = sharedCode;
    }

    public Long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
