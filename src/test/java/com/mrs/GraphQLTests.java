package com.mrs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester // Auto-configures GraphQlTester
public class GraphQLTests {

    @Autowired
    private GraphQlTester graphQlTester;

    private static String createdMovieId; // Store the generated movie ID

    // Step 1: Add a new movie and store its ID
    @Test
    void testAddMovie() {
        String mutation = """
            mutation {
                addMovie(genre: "Action", title: "The Test Movie", director: "John Doe", releaseDate: "2025-01-01") {
                    id
                    title
                }
            }
        """;

        createdMovieId = graphQlTester.document(mutation)
                .execute()
                .path("addMovie.id").entity(String.class).get(); // Store the movie ID

        graphQlTester.document(mutation)
                .execute()
                .path("addMovie.id").hasValue()
                .path("addMovie.title").matchesJson("\"The Test Movie\"");
    }

    // Step 2: Use the movie ID to fetch it
    @Test
    void testFetchMovie() {
        String query = """
            query {
                movie(id: "%s") {
                    id
                    title
                }
            }
        """.formatted(createdMovieId); // Insert the generated movie ID

        graphQlTester.document(query)
                .execute()
                .path("movie.id").hasValue()
                .path("movie.title").matchesJson("\"The Test Movie\"");
    }

    // Step 3: Use the movie ID to add a review
    @Test
    void testAddReview() {
        String mutation = """
            mutation {
                addReview(userId: "1b6f7722-e093-4736-89ae-a7cff6f89632",
                          movieId: "%s",
                          comment: "Amazing movie!") {
                    id
                    comment
                }
            }
        """.formatted(createdMovieId); // Insert movie ID into the mutation

        graphQlTester.document(mutation)
                .execute()
                .path("addReview.id").hasValue()
                .path("addReview.comment").matchesJson("\"Amazing movie!\"");
    }

    // Step 4: Fetch the user's reviews and check if it contains the new review
    @Test
    void testUserReviews() {
        String query = """
            query {
                userReviews(userId: "1b6f7722-e093-4736-89ae-a7cff6f89632") {
                    id
                    comment
                }
            }
        """;

        graphQlTester.document(query)
                .execute()
                .path("userReviews[0].id").hasValue()
                .path("userReviews[0].comment").hasValue();
    }
}


