package dev.harshiniraja97.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


import java.util.*;

@Document(collection = "books")
/*@Document Annotation:

This annotation is used to mark a class as a MongoDB document, which means it will be mapped to a collection in the MongoDB database.
It comes from the org.springframework.data.mongodb.core.mapping package.
collection = "books":

The collection attribute specifies the name of the MongoDB collection that the document (i.e., the class) will be mapped to.
In this case, the class will be mapped to a collection named "books".
*/

@Data
/*The @Data annotation in the Spring framework is part of the Project Lombok library.
Project Lombok is a Java library that helps to reduce boilerplate code by generating common methods such as getters, setters, toString, equals, hashCode, and constructors at compile time.
Getters for all fields.
Setters for all non-final fields.
toString method.
equals and hashCode methods.
A constructor that initializes all final fields, as well as any fields that are marked as @NonNull.
By using @Data, Lombok generates the following methods behind the scenes:

public String getId();public void setId(String id);public String getTitle();public void setTitle(String title);public String getAuthor()
public void setAuthor(String author);public String getIsbn();public void setIsbn(String isbn);public boolean equals(Object o)
public int hashCode();public String toString()
 */
@AllArgsConstructor //The @AllArgsConstructor annotation generates a constructor that takes one argument for each field in your class.
@NoArgsConstructor //The @NoArgsConstructor annotation in Project Lombok is used to generate a no-arguments constructor for a class.
public class Books {
    @Id
    private ObjectId id;
    private String isbn;
    private String title;
    private String publishedDate;
    private String publisher;
    private List<String> genres;
    private String bookCover;
    private List<String> authors;
    private String pageCount;
    private String description;
    @DocumentReference
    /*
    n the context of Spring Data MongoDB, @DocumentReference is an annotation that allows you to reference other documents in a MongoDB database flexibly.
    Here’s a detailed explanation:When you annotate a field with @DocumentReference, it indicates that the field will hold a reference to another entity.
     Unlike @DBRef, which stores references in a specific DBRef format, @DocumentReference allows for a more flexible schema and can reference anything that can be stored in MongoDB, such as a single value, an entire document, or a collection of documents
     */
    private List<Reviews> reviewIds;

}
