package com.ai.ems.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public record DependentDTO (@Id @GeneratedValue String name, String relationship) {
}
