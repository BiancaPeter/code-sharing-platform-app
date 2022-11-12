package com.spring.codesharingplatform.controller;

import com.spring.codesharingplatform.DTO.SharedCodeResponseDTO;
import com.spring.codesharingplatform.model.SharedCode;
import com.spring.codesharingplatform.service.SharedCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code")
public class SharedCodeController {
    private SharedCodeService sharedCodeService;

    @Autowired
    public SharedCodeController(SharedCodeService sharedCodeService) {
        this.sharedCodeService = sharedCodeService;
    }

    @PostMapping("/add")
    public SharedCode addSharedCode(@RequestBody SharedCode sharedCode) {
        return sharedCodeService.addSharedCode(sharedCode);
    }

    @GetMapping("/{codeId}")
    public SharedCodeResponseDTO getSharedCode(@PathVariable Long codeId){
return sharedCodeService.getSharedCode(codeId);
    }
}
