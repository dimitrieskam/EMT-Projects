package mk.finki.emt.sharedkernel.domain.contact;

import jakarta.persistence.Embeddable;
import mk.finki.emt.sharedkernel.domain.base.ValueObject;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
public class EmailAddress implements ValueObject {
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private String email;

    protected EmailAddress() {
        // for JPA
    }

    public EmailAddress(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email address format");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return email;
    }



    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {

    }
}
