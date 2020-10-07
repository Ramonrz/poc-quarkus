package org.acme.dto;

import java.time.LocalDateTime;

import org.acme.enums.PersonType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

	private Long id;
	private String name;
	private String taxIdNumber;
	private PersonType personType;
	private LocalDateTime creationDate;
}