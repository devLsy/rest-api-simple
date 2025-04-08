package com.test.lsy.apitest250408.service;

import com.test.lsy.apitest250408.dto.entity.UserEntity;
import com.test.lsy.apitest250408.dto.response1.ResultsItem;
import com.test.lsy.apitest250408.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional
    public <T extends ResultsItem> void saveUsers(List<T> results) {
        for (T result : results) {
            UserEntity user = UserEntity.builder()
                    .gender(result.getGender())
                    .firstName(result.getName().getFirst())
                    .lastName(result.getName().getLast())
                    .email(result.getEmail())
                    .phone(result.getPhone())
                    .pictureUrl(result.getPicture().getLarge())
                    .build();
            repository.save(user);

            throw new RuntimeException("강제 에러");
        }
    }
}
