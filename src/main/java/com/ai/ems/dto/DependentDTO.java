package com.ai.ems.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public record DependentDTO (Long id, @NotBlank String name,@NotBlank @NonNull String relationship) {
}
