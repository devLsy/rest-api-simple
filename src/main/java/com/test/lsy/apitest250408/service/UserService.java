package com.test.lsy.apitest250408.service;

import com.test.lsy.apitest250408.dto.entity.*;
import com.test.lsy.apitest250408.dto.response1.Info;
import com.test.lsy.apitest250408.dto.response1.Response;
import com.test.lsy.apitest250408.dto.response1.ResultsItem;
import com.test.lsy.apitest250408.dto.response2.ResponseItem1;
import com.test.lsy.apitest250408.dto.response3.DataItem;
import com.test.lsy.apitest250408.dto.response3.Response3;
import com.test.lsy.apitest250408.dto.response4.ResponseItem2;
import com.test.lsy.apitest250408.dto.response5.ResponseItem5;
import com.test.lsy.apitest250408.repository.*;
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
    private final User4Repository user4Repository;
    private final User5Repository user5Repository;
    private final InfoRepository infoRepository;
    private final EmpRepository empRepository;
    private final LocationRepository locationRepository;
    private final PictureRepository pictureRepository;
    private final LoginRepository loginRepository;
    private final TimezoneRepository timezoneRepository;

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

    @Transactional
    public void saveUsers4(List<ResponseItem2> list) {
        if(list.size() > 0) {
            list.stream().map(result -> UserEntity4.builder()
                        .website(result.getWebsite())
                        .zipcode(result.getAddress().getZipcode())
                        .phone(result.getPhone())
                        .name(result.getName())
                        .id(result.getId())
                        .username(result.getUsername())
                        .city(result.getAddress().getCity())
                        .street(result.getAddress().getStreet())
                        .suite(result.getAddress().getSuite())
                    .build())
                    .forEach(user -> {
                        user4Repository.save(user);
                    });
        }
    }

    @Transactional
    public void saveUsers5(List<ResponseItem5> list) {
    }

    @Transactional
    public void saveUsers3(Response3 response) {
        if(response != null) {
            List<DataItem> results = response.getData();

            results.stream().map(result -> UserEntity5.builder()
                            .id(result.getId())
                            .email(result.getEmail())
                            .firstName(result.getFirstName())
                            .lastName(result.getFirstName())
                            .avatar(result.getAvatar())
                            .build())
                    .forEach(user -> {
                        user5Repository.save(user);
                    });
        }
    }

    @Transactional
    public void saveUser6(Response response) {
        List<ResultsItem> results = response.getResults();
        Info info = response.getInfo();

        try {
            for (ResultsItem result : results) {
                // 1. EmpEntity 저장
                EmpEntity emp = EmpEntity.builder()
                        .gender(result.getGender())
                        .titleName(result.getName().getTitle())
                        .firstName(result.getName().getFirst())
                        .lastName(result.getName().getLast())
                        .build();
                empRepository.save(emp);

                // 2. LocationEntity 저장
                LocationEntity location = LocationEntity.builder()
                        .streetNumber(result.getLocation().getStreet().getNumber())
                        .streetName(result.getLocation().getStreet().getName())
                        .city(result.getLocation().getCity())
                        .state(result.getLocation().getState())
                        .country(result.getLocation().getCountry())
                        .postcode(result.getLocation().getPostcode())
                        .latitude(result.getLocation().getCoordinates().getLatitude())
                        .longitude(result.getLocation().getCoordinates().getLongitude())
                        .build();
                locationRepository.save(location);

                // 3. LoginEntity 저장
                LoginEntity login = LoginEntity.builder()
                        .uuid(result.getLogin().getUuid())
                        .username(result.getLogin().getUsername())
                        .password(result.getLogin().getPassword())
                        .salt(result.getLogin().getSalt())
                        .md5(result.getLogin().getMd5())
                        .sha1(result.getLogin().getSha1())
                        .sha256(result.getLogin().getSha256())
                        .build();
                loginRepository.save(login);

                // 4. pictureEntity 저장
                PictureEntity pictureEntity = PictureEntity.builder()
                        .large(result.getPicture().getLarge())
                        .medium(result.getPicture().getMedium())
                        .thumbnail(result.getPicture().getThumbnail())
                        .build();
                pictureRepository.save(pictureEntity);
//                throw new Exception("강제 에러");
//                 throw new RuntimeException("강제 에러");

                // 5. timezoneEntity 저장
                TimezoneEntity timezone = TimezoneEntity.builder()
                        .offset(result.getLocation().getTimezone().getOffset())
                        .description(result.getLocation().getTimezone().getDescription())
                        .build();
                timezoneRepository.save(timezone);
            }

        } catch(Exception e) {
            // 예외를 잡기만 하고 다시 던지지 않으면 롤백되지 않음
            log.error("saveUser5 중 예외 발생, 롤백합니다: {}", e.getMessage(), e);
            // ✅ 트랜잭션 롤백을 원하면 아래처럼 런타임 예외로 다시 던져야 함
             throw new RuntimeException("saveUser5 실패 - 트랜잭션 롤백", e);
        }
    }
}
