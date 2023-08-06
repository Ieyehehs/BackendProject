package com.example.backend;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public record MyRecord(@Id Long id, @Column String name) {}

