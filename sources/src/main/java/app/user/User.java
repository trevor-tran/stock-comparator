package app.user;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Value // All fields are private and final. Getters (but not setters) are generated (https://projectlombok.org/features/Value.html)
public class User {
	String firstName;
	String lastName;
	String username;
	String salt;
	String hashedPassword;
	String email;
	BigDecimal investment;
	Date startDate;
	Date endDate;
	
	
}
