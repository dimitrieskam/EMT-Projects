package mk.finki.emt.docktormanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.finki.emt.sharedkernel.domain.base.ValueObject;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

@Embeddable
public class Specialization implements ValueObject {
    private final String name;
    protected Specialization(){
        this.name=null;
    }
    public Specialization(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;
        Specialization that=(Specialization) obj;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {

    }
}
