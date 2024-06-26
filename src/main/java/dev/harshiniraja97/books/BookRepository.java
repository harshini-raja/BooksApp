package dev.harshiniraja97.books;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Books, ObjectId> {

    Optional<Books> findBookByisbn(String isbn);
}
