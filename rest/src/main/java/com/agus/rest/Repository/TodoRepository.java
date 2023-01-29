package com.agus.rest.Repository;

import com.agus.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Task, Long> {
}
