package gr.codelearn.java.path.spring.test.controller;

import gr.codelearn.java.path.spring.test.base.AbstractLogEntity;
import gr.codelearn.java.path.spring.test.domain.BaseEntity;
import gr.codelearn.java.path.spring.test.service.BaseService;
import gr.codelearn.java.path.spring.test.transfer.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T extends BaseEntity> extends AbstractLogEntity {
        protected abstract BaseService<T, Long> getBaseService();

        @GetMapping("/{id}")
        public ResponseEntity<ApiResponse<T>> findById(@PathVariable("id") final Long id) {
            return ResponseEntity.ok(ApiResponse.<T>builder().data(getBaseService().findById(id)).build());
        }

        @GetMapping
        public ResponseEntity<ApiResponse<List<T>>> findAll() {
            return ResponseEntity.ok(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).build());
        }

}
