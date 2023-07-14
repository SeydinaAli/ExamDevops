package com.groupeisi.m2gl.seydina_badara_aliou_keita;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PalindromeController {

    @PostMapping("/checkpalindrome")
    public ResponseEntity<PalindromeResponse> checkPalindrome(@RequestBody PalindromeRequest request) {
        String word = request.getMotAverifier();
        boolean isPalindrome = isPalindrome(word);

        PalindromeResponse response = new PalindromeResponse(isPalindrome);
        HttpStatus status = isPalindrome ? HttpStatus.ACCEPTED : HttpStatus.OK;

        return ResponseEntity.status(status).body(response);
    }

    private boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }
}