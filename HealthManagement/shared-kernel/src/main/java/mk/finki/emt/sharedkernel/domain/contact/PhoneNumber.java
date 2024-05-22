package mk.finki.emt.sharedkernel.domain.contact;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.finki.emt.sharedkernel.domain.base.ValueObject;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
@Getter
public class PhoneNumber implements ValueObject {
    private static final String PHONE_NUMBER_REGEX = "^\\+?[0-9. ()-]{7,25}$";
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);

    private final String number;

    public PhoneNumber(String number) {
        if (number == null || !PHONE_NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        this.number = number;
    }

    public PhoneNumber() {

        number = null;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number;
    }


    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {
        if (object instanceof PhoneNumber) {
            outputStream.write(((PhoneNumber) object).getNumber().getBytes(StandardCharsets.UTF_8));
        } else {
            throw new IllegalArgumentException("Invalid object type for serialization");
        }
    }


}
