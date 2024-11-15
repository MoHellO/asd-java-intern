package team.asd.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class ConverterService implements IsConverterService {
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public String convertIntegerIntoString(Integer value) {
		return value != null ? String.valueOf(value) : null;
	}

	@Override
	public Integer convertStringIntoInteger(String value) {
		return Optional.ofNullable(value)
				.map(val -> {
					try {
						return Integer.parseInt(val);
					} catch (NumberFormatException e) {
						throw new NumberFormatException(e.getMessage());
					}
				})
				.orElse(null);
	}

	@Override
	public Double convertStringIntoDouble(String value) {
		return Optional.ofNullable(value)
				.map(val -> {
					try {
						return Double.parseDouble(val);
					} catch (NumberFormatException e) {
						throw new NumberFormatException(e.getMessage());
					}
				})
				.orElse(null);
	}

	@Override
	public LocalDate convertStringIntoLocalDate(String dateString) throws DateTimeParseException {
		// Використання Optional для обробки null і конвертація String у LocalDate
		return Optional.ofNullable(dateString)
				.map(value -> {
					try {
						return LocalDate.parse(value, DATE_FORMATTER);
					} catch (DateTimeParseException e) {
						throw new DateTimeParseException(e.getMessage(), e.getParsedString(), e.getErrorIndex());
					}
				})
				.orElse(null);
	}
}
