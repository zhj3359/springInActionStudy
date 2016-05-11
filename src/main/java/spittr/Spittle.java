package spittr;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 * Created by jhj on 2016-05-11.
 */
@Getter
public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private final Double latitude;
    private final Double longitude;

    public Spittle(String message, Date time){
        this(message,time,null,null);
    }

    private Spittle(String message, Date time, Double latitude, Double longitude){
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
