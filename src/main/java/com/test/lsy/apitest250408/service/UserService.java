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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    private final CountyRepository countyRepository;
    private final FlagsRepository flagsRepository;
    private final JdbcTemplate jdbcTemplate;

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
    public void saveUsers5(List<ResponseItem5> list) {
        if (list.isEmpty()) return;

        final int BATCH_SIZE = 100;

        long startTime = System.currentTimeMillis(); // 시작 시간

        log.info("list size() : {}", list.size() -1);

        for (int start = 0; start < list.size(); start += BATCH_SIZE) {
            int end = Math.min(start + BATCH_SIZE, list.size());
            List<ResponseItem5> batchList = list.subList(start, end);
            log.info("batchList size() : {}", batchList.size());

            // ---------------------
            // bulk insert into country_tb
            // ---------------------
            StringBuilder countrySql = new StringBuilder("INSERT INTO country_tb (id, countryName, officialEngName, region) VALUES ");
            List<Object> countryParams = new ArrayList<>();

            // ---------------------
            // bulk insert into flag_tb
            // ---------------------
            StringBuilder flagSql = new StringBuilder("INSERT INTO flag_tb (id, alt, png, svg) VALUES ");
            List<Object> flagParams = new ArrayList<>();

            for (int i = 0; i < batchList.size(); i++) {
                ResponseItem5 item = batchList.get(i);

                // country
                String countryName = item.getName().getCommon();
                String officialName = item.getName().getOfficial();
                String region = item.getRegion();
                String countryId = UUID.randomUUID().toString();

                countrySql.append("(?, ?, ?, ?)");
                if (i < batchList.size() - 1) countrySql.append(", ");

                countryParams.add(countryId);
                countryParams.add(countryName);
                countryParams.add(officialName);
                countryParams.add(region);

                // flag
                String alt = item.getFlags().getAlt();
                String png = item.getFlags().getPng();
                String svg = item.getFlags().getSvg();
                String flagId = UUID.randomUUID().toString();

                flagSql.append("(?, ?, ?, ?)");
                if (i < batchList.size() - 1) flagSql.append(", ");

                flagParams.add(flagId);
                flagParams.add(alt);
                flagParams.add(png);
                flagParams.add(svg);
            }

//            log.info("country_tb sql : {}", countrySql.toString());
//            log.info("country_tb param: {}", countryParams);
//            jdbcTemplate.update(countrySql.toString(), countryParams.toArray());

//            log.info("flag_tb sql : {}", flagSql.toString());
//            log.info("flag_tb param: {}", flagParams);
//            jdbcTemplate.update(flagSql.toString(), flagParams.toArray());
        }

        long endTime = System.currentTimeMillis(); // 종료 시간
        log.info("전체 INSERT 실행 시간: {} ms", (endTime - startTime)); // 전체 실행 시간 로그
    }

    // 기존 jpa bastch insert 방식
//    @Transactional
//    public void saveUsers5(List<ResponseItem5> list) {
//
//    long startTime = System.currentTimeMillis(); // 시작 시간
//
//        List<CountyEntity> countyEntities = new ArrayList<>();
//        List<FlagsEntity> flagsEntities = new ArrayList<>();
//
//        for (ResponseItem5 item : list) {
//            countyEntities.add(
//                    CountyEntity.builder()
//                            .countryName(item.getName().getCommon())
//                            .officialEngName(item.getName().getOfficial())
//                            .region(item.getRegion())
//                            .build()
//            );

//            flagsEntities.add(
//                    FlagsEntity.builder()
//                            .png(item.getFlags().getPng())
//                            .svg(item.getFlags().getSvg())
//                            .alt(item.getFlags().getAlt())
//                            .build()
//            );
//        }

//        countyRepository.saveAll(countyEntities);
//        flagsRepository.saveAll(flagsEntities);
//
//    long endTime = System.currentTimeMillis(); // 종료 시간
//    log.info("saveAll 실행 시간: {} ms", (endTime - startTime)); // 실행 시간 로그
//    }

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
