package team.asd.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ConverterService implements IsConverterService {

	@Override
	public String convertIntegerIntoString(Integer value) {
		return value == null ? null : value.toString();
	}

	@Override
	public Integer convertStringIntoInteger(String value) {
		if (value == null) return null;
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Provided string is not a valid integer: " + value);
		}
	}

	@Override
	public Double convertStringIntoDouble(String value) {
		if (value == null) return null;
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Provided string is not a valid double: " + value);
		}
	}

	@Override
	public LocalDate convertStringIntoLocalDate(String dateString) throws DateTimeParseException {
		if (dateString == null) return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") ;
		try {
			return LocalDate.parse(dateString, formatter);
		} catch (DateTimeParseException e) {
			throw new DateTimeParseException("Provided string is not a valid date: " + dateString, dateString, 0);
		}
	}
}
