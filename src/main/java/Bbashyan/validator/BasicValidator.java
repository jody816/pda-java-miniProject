package Bbashyan.validator;

public class BasicValidator {

  private static final String REGEX_ALPHABET_PATTERN = ".*[a-zA-Z].*";
  private static final String INVALID_INPUT_ERROR = "제시된 숫자만 입력 가능합니다.";
  private static final String EMPTY_INPUT_ERROR = "입력값이 필요합니다.";

//  public boolean isValidateNumber(String input) {
//    if (input == null || input.isEmpty()) {
//      return false;
//    }
//  }

  public static void isValidateNumber(String input) {
    if (input == null || input.isEmpty()) {
      throw new NullPointerException(EMPTY_INPUT_ERROR);
    }

    if (input.matches(REGEX_ALPHABET_PATTERN)) {
      throw new IllegalArgumentException(INVALID_INPUT_ERROR);
    }
  }
}
