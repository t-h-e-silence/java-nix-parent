package finance.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;

@Embeddable
public class Timestamp implements Serializable {

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Timestamp() {
    }


    public Timestamp(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public static Timestamp now() {
        var now = Instant.now();
        return new Timestamp(now);
    }

}