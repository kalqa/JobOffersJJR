package com.junioroffers.infrastructure.loginandregister.controller.dto;

import lombok.Builder;

@Builder
public record JwtResponseDto(
        String username,
        String token
) {
}
