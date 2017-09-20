package jp.co.sample.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.sample.domain.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query(value = "select * from todos t where t.user_id = :userId", nativeQuery = true)
    public List<Todo> findByUserId(int userId);
}
