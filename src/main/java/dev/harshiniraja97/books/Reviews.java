package dev.harshiniraja97.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reviews {
    @Id
    private ObjectId id;
    private String reviewBody;

    public Reviews(String reviewBody) {
        this.reviewBody = reviewBody;
    }
}
