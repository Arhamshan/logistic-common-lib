package com.logistic.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CommonUtils {

	private static String EMAIL_REGEX = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
			+ "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";

	private static String MOBILE_REGEX = "^(?:\\+?[0-9]){1,20}$";

	private static final String ALPHANUMERIC_REGEX = "^[a-zA-Z0-9 ]*$";

	private static final String ALPHANUMERIC_WITH_FULLSTOP_REGEX = "^[a-zA-Z0-9.]+$";

	private static final String ALPHANUMERIC_WITH_FULLSTOP_SPACE_REGEX = "^[a-zA-Z0-9 .]+$";

	private static final String ALPHANUMERIC_WITH_UNDERSCORE_REGEX = "^[a-zA-Z0-9 _]+$";

	private static final String ADDRESS_ALLOWED_REGEX = "^[\\w\\s.,#\\-/]+$";

	private static final String EMAIL_ADDRESS_ALLOWED_REGEX = "^[a-zA-Z0-9 .\\-_+@'&/Â]+$";

	public static final String[] SQL_INJECTION_KEYWORDS = new String[] {
			"select", "or",  "and", "insert", "update", "delete", "drop", "create", "alter", "truncate",
			"where", "from", "join", "group by", "having", "order by", "limit", "offset",
			"union", "intersect", "except", "cast", "convert", "concat", "like", "ilike",
			"regexp", "rlike", "any", "all", "some", "in", "not in", "is null", "is not null",
			"true", "false", "null", "current_user", "current_date", "current_time",
			"current_timestamp", "transaction_id", "session_id", "user", "role",
			"database", "schema", "table", "column", "function", "procedure", "trigger",
			"view", "index", "constraint", "sequence", "operator", "comment",
			"set", "revoke", "grant", "superuser", "begin", "commit", "rollback",
			"call", "exec"
	};

	public static final String[] SQL_INJECTION_KEYWORDS_WITHOUT_SPACE = new String[] {
			"alert"
	};

	public static final String[] SCRIPTING_CHARACTERS = new String[] {
			"<", ">", "&gt", "&lt", "'", "\"", "\\", "/", ";", "=", ":", "[", "]",
			 "\'", "\n", "\r", "\t", "\b", "\f"
	};

	/*
	* ' will be allowed
	* */
	public static final String[] LIMITED_SCRIPTING_CHARACTERS = new String[] {
			"<", ">", "&gt", "&lt", "\"", "\\", "/", ";", "=", ":", "[", "]",
			"\n", "\r", "\t", "\b", "\f"
	};
	
	public static boolean isBlankString(String string) {
	    return string == null || string.trim().isEmpty();
	}

	public static boolean isBoolean(String string){
		return string != null && ("false".equalsIgnoreCase(string.trim()) || "true".equalsIgnoreCase(string.trim()));
	}

	public static boolean isDateValidate(String pickupDate, String dateFormat){
		try {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
			LocalDate.parse(pickupDate, dateTimeFormatter);

		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return  false;
		}
		return true;
	}

	public static boolean isValidLocalDateTime(String pickupDate, String dateFormat){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);

		try {

			LocalDateTime.parse(pickupDate, dateTimeFormatter);

		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return  false;
		}

		return true;
	}

	public static String convertToString(Object object) {
		try {
			return new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(object);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean isDatePast(final String date, String dateFormat) throws ParseException {
		String currentDateValue = LocalDate.now().format(DateTimeFormatter.ofPattern(dateFormat));
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date pickupDate = df.parse(date);

		if(date.equals(currentDateValue)) {
			return false;
		} else if(new Date().after(pickupDate)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isBlankNumber(Number number) {
	    return number == null;
	}	
	
	public static String getExecutionTime(long startTime) {
		long endTime = System.currentTimeMillis();
		return String.format("%d ms", (endTime - startTime));
	}

	public static String convertToDatabaseColumnName(String value) {

		StringBuilder stringBuilder = new StringBuilder();

		if(value != null) {
			for (int i =0; i < value.length(); i++) {
				char character = value.charAt(i);

				if(Character.isUpperCase(character)) {
					stringBuilder.append("_");
				}

				stringBuilder.append(String.valueOf(character).toLowerCase());
			}
		}

		return stringBuilder.toString();
	}

	public static Map<String, String> getFilterFieldValues(String filters) {

		Map<String, String> filtersMap = new HashMap<>();

		if(filters != null && !filters.equalsIgnoreCase("")) {
			String[] fieldValues = filters.split(",");

			for (String fieldVal : fieldValues) {
				String key = fieldVal.split(":(.*)")[0];
				String value = fieldVal.replace(key + ":", "");
				filtersMap.put(key.trim(), value.trim());
			}
		}

		return filtersMap;
	}

	public static List<String> getSearchFields(String fields) {

		List<String> searchFields = new ArrayList<>();

		if(fields != null && !fields.equalsIgnoreCase("")) {
			searchFields = Arrays.asList(fields.split(","));
		}

		return searchFields;
	}

	/*public static Map<String, String> getSort(PageRequestVo requestVo, String defaultFieldName, SortOrder defaultOrder) {

		Map<String, String> sort = new HashMap<>();

		if (requestVo == null || requestVo.getSortBy() == null || requestVo.getSortBy().isEmpty()) {
			sort.put(defaultFieldName, defaultOrder.name());
		} else {
			String[] sortValues = requestVo.getSortBy().split(",");

			for (int i = 0; i < sortValues.length; i++) {
				String[] val = sortValues[i].split(":");
				sort.put(convertToDatabaseColumnName(val[0]), getSortOrder(val[1]).name());
			}
		}

		return sort;
	}*/

	public static Boolean isValidFilter(String filter) {
		return filter != null && !filter.trim().isEmpty();
	}

	public static boolean isValidDialingCode(String dialingCode) {
		String pattern = "^(\\+?\\d{1,3}|\\d{1,4})$";

		return dialingCode != null &&
				(Pattern.matches(pattern, dialingCode));
	}

	public static boolean isValidConsignmentId(String dialingCode) {
		String pattern = "([A-Za-z0-9\\-\\_]+)";

		return dialingCode != null &&
				(Pattern.matches(pattern, dialingCode));
	}




	/*private static SortOrder getSortOrder(String sortValue) {
		if (sortValue.trim().equalsIgnoreCase(SortOrder.ASC.name())) {
			return SortOrder.ASC;
		} else {
			return SortOrder.DESC;
		}
	}*/

	public static boolean isTrue(Boolean booleanValue) {
		return booleanValue != null && Boolean.TRUE.equals(booleanValue);
	}


	/*public static String removeHtmlTags(String html) {
		return Jsoup.parse(html).text();
	}*/

	public static boolean emailValidation(String email) {
		return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
	}

	public static boolean isValidMobileNumber(String mobileNumber) { return Pattern.compile(MOBILE_REGEX).matcher(mobileNumber).matches(); }

	/*public static String removeCustomerCodeSuffix(String customerCode) {

		if(customerCode == null || customerCode.isEmpty()) {
			return null;
		}

		Set<String> productSuffixes = Arrays.stream(ProductCode.values()).map(v -> v.displayName).collect(Collectors.toSet());

		productSuffixes.addAll(Arrays.stream(ProductServiceCodes.values()).map(ProductServiceCodes::getCustomerCodeSuffix).collect(Collectors.toSet()));

		String pattern = String.join("|", productSuffixes);
		pattern = "(?i)(" + pattern + ")$";

		Pattern regexPattern = Pattern.compile(pattern);
		Matcher matcher = regexPattern.matcher(customerCode);
		if (matcher.find()) {
			return customerCode.substring(0, matcher.start()).trim();
		} else {
			return customerCode;
		}
	}*/

	// Check whether it contains scripting characters
	public static boolean isContainScriptingCharacters(String text) {

		Optional<String> exist = Arrays.stream(SCRIPTING_CHARACTERS).filter(text::contains).findAny();

		return exist.isPresent();
	}

	// Check whether it contains scripting characters with limitations
	public static boolean isContainLimitedScriptingCharacters(String text) {

		Optional<String> exist = Arrays.stream(LIMITED_SCRIPTING_CHARACTERS).filter(text::contains).findAny();

		return exist.isPresent();
	}

	// Check text with regex
	public static boolean isValidRegex(String text, String regex) {
		return Pattern.compile(regex).matcher(text).matches();
	}

	// Check alpha numeric validations
	public static boolean isValidAlphanumeric(String text) {
		return Pattern.compile(ALPHANUMERIC_REGEX).matcher(text).matches();
	}

	// Check alpha numeric with underscore validations
	public static boolean isValidAlphanumericWithUnderscore(String text) {
		return Pattern.compile(ALPHANUMERIC_WITH_UNDERSCORE_REGEX).matcher(text).matches();
	}

	// Check alpha numeric with full stop validations
	public static boolean isValidAlphanumericWithFullStop(String text) {
		return Pattern.compile(ALPHANUMERIC_WITH_FULLSTOP_REGEX).matcher(text).matches();
	}

	// Check alpha numeric with full stop and space validations
	public static boolean isValidAlphanumericWithFullStopAndSpace(String text) {
		return Pattern.compile(ALPHANUMERIC_WITH_FULLSTOP_SPACE_REGEX).matcher(text).matches();
	}

	// Check some specific special character validations
	public static boolean isValidAddress(String address) {
		return Pattern.compile(ADDRESS_ALLOWED_REGEX).matcher(address).matches();
	}

	// Check email with some specific special character validations
	public static boolean isValidEmailAddress(String address) {
		return Pattern.compile(EMAIL_ADDRESS_ALLOWED_REGEX).matcher(address).matches();
	}

	// Check SQL injection keywords
	public static boolean validateSqlInjection(String text) {

		// Build the regular expression pattern to check the keyword with space
		String regex = ".*(?:^|\\s)(" + buildRegexPattern(SQL_INJECTION_KEYWORDS) + ")(?:\\s|$).*";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);

		if (matcher.matches()) {
			return true;

		} else {
			// Build the regular expression pattern to check the keyword without space
			String regexWithoutSpace = ".*(" + buildRegexPattern(SQL_INJECTION_KEYWORDS_WITHOUT_SPACE) + ").*";

			Pattern patternWithoutSpace = Pattern.compile(regexWithoutSpace, Pattern.CASE_INSENSITIVE);
			Matcher matcherWithoutSpace = patternWithoutSpace.matcher(text);

			return matcherWithoutSpace.matches();
		}
	}

	public static boolean validateSqlInjection(String text, String exclude) {

		String[] filteredKeywords = null;
		String[] filteredKeywordsForWithoutSpace = null;

		if (!CommonUtils.isBlankString(exclude)) {
			List<String> wordsToRemoveList = Arrays.asList(exclude.split(","));
			filteredKeywords = removeWordsFromArray(SQL_INJECTION_KEYWORDS, wordsToRemoveList);
			filteredKeywordsForWithoutSpace = removeWordsFromArray(SQL_INJECTION_KEYWORDS_WITHOUT_SPACE, wordsToRemoveList);
		} else {
			filteredKeywords = SQL_INJECTION_KEYWORDS;
			filteredKeywordsForWithoutSpace = SQL_INJECTION_KEYWORDS_WITHOUT_SPACE;
		}

		// Build the regular expression pattern to check the keyword with space
		String regex = ".*(?:^|\\s)(" + buildRegexPattern(filteredKeywords) + ")(?:\\s|$).*";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);

		if (matcher.matches()) {
			return true;

		} else {
			if(filteredKeywordsForWithoutSpace.length > 0) {
				// Build the regular expression pattern to check the keyword without space
				String regexWithoutSpace = ".*(" + buildRegexPattern(filteredKeywordsForWithoutSpace) + ").*";

				Pattern patternWithoutSpace = Pattern.compile(regexWithoutSpace, Pattern.CASE_INSENSITIVE);
				Matcher matcherWithoutSpace = patternWithoutSpace.matcher(text);

				return matcherWithoutSpace.matches();
			} else {
				return false;
			}
		}
	}

	public static String[] removeWordsFromArray(String[] array, List<String> wordsToRemove) {
		List<String> filteredList = new ArrayList<>();
		for (String word : array) {
			if (!wordsToRemove.contains(word)) {
				filteredList.add(word);
			}
		}
		return filteredList.toArray(new String[0]);
	}

	private static String buildRegexPattern(String[] textArray) {
		StringBuilder pattern = new StringBuilder();

		// Build the regex pattern using "|" (OR) operator
		for (String text : textArray) {
			if (pattern.length() > 0) {
				pattern.append("|");
			}
			pattern.append(text.trim());
		}

		return pattern.toString();
	}

}
