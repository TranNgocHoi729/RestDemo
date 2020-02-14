package com.xtel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class User {
	String name;
	String number;
	String identify_number;
	double price;
}
