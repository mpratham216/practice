package tech.practice;

public class UtilityEmailValidation {
	public static void validate(String email) throws CustomEmailValidation {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new CustomEmailValidation("Invalid email format: Email must contain both '@' and '.'");
        }
    }

}
