package com.test.lsy.apitest250408.service;

import com.test.lsy.apitest250408.dto.entity.InfoEntity;
import com.test.lsy.apitest250408.dto.entity.UserEntity;
import com.test.lsy.apitest250408.dto.entity.UserEntity2;
import com.test.lsy.apitest250408.dto.response1.Info;
import com.test.lsy.apitest250408.dto.response1.Response;
import com.test.lsy.apitest250408.dto.response1.ResultsItem;
import com.test.lsy.apitest250408.dto.response2.ResponseItem1;
import com.test.lsy.apitest250408.repository.InfoRepository;
import com.test.lsy.apitest250408.repository.User2Repository;
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

    private final UserRepository userRepository;
    private final User2Repository user2Repository;
    private final InfoRepository infoRepository;

    @Transactional
    public void saveUsers(Response response) {

        List<ResultsItem> results = response.getResults();
        Info info = response.getInfo();

        InfoEntity infoEntity = InfoEntity.builder()
                .seed(info.getSeed())
                .results(info.getResults())
                .page(info.getPage())
                .version(info.getVersion())
                .build();

        if(info != null) infoRepository.save(infoEntity);

        if(results.size() > 0) {
            results.stream().map(result -> UserEntity.builder()
                    .gender(result.getGender())
                    .firstName(result.getName().getFirst())
                    .lastName(result.getName().getLast())
                    .email(result.getEmail())
                    .phone(result.getPhone())
                    .pictureUrl(result.getPicture().getLarge())
                    .build())
                    .forEach(user -> {
                userRepository.save(user);
//                throw new RuntimeException("강제 에러");
            });
        }
    }

    @Transactional
    public void saveUsers2(List<ResponseItem1> list) {
        if(list.size() > 0) {
            list.stream().map(result -> UserEntity2.builder()
                    .id(result.getId())
                    .name(result.getName())
                    .email(result.getEmail())
                    .gender(result.getGender())
                    .status(result.getStatus())
                    .build())
                    .forEach(user -> {
                user2Repository.save(user);
            });
        }
    }
}
