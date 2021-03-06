package com.ketul.module;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
	
	@NotBlank(message = "name can not be null")
	@Size(min = 3, max = 30, message = "name must be between 3 and 30")
	private String name;
	
	@NotBlank(message = "email can not be null")
	private String email;
}
