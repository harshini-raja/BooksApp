package dev.harshiniraja97.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Reviews createReview(String reviewBody,String isbn){
        Reviews review = reviewRepository.insert(new Reviews(reviewBody));
        mongoTemplate.update(Books.class).matching(Criteria.where("isbn").is(isbn)).apply(new Update().push("reviewIds").value(review)).first();
        return review;
    }
}
