    package com.pulkit.quizapp.dao;

    import com.pulkit.quizapp.model.Question;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    import static org.springframework.boot.env.RandomValuePropertySourceEnvironmentPostProcessor.ORDER;

    @Repository

    public interface QuestionDao extends JpaRepository<Question,Integer> {
        List<Question> findByCategory (String category);

//        List<Question> findById(int id);


        @Query(value = "SELECT * FROM Question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
        List<Question> findRandomQuestionsByCategory(String category, int numQ);


    }
