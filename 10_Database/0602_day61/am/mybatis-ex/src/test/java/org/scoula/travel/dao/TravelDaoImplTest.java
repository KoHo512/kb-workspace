package org.scoula.travel.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.scoula.travel.domain.TravelVO;

import java.util.List;

class TravelDaoImplTest {
    TravelDao dao = new TravelDaoImpl();

    @Test
    void getTotalCount() {
        int count = dao.getTotalCount();
        Assertions.assertTrue(count > 0, "Total count should be greater than 0");
        System.out.printf("Total count : %d\n", count);
    }

    @Test
    void getTravels() {
        List<TravelVO> list = dao.getTravels(1, 10);
        Assertions.assertTrue(list.size() > 0);
        list.forEach(System.out::println);
    }

    @Test
    void getDistricts() {
        List<String> list = dao.getDistricts();
        Assertions.assertTrue(list.size() > 0);
        list.forEach(System.out::println);
    }

    @Test
    void getTravelsByDistrict() {
        List<TravelVO> list = dao.getTravelsByDistrict("강원권");
        Assertions.assertTrue(list.size() > 0);
        list.forEach(System.out::println);
    }

    @Test
    void getTravel() {
        TravelVO travel = dao.getTravel(1L).orElseThrow();
        Assertions.assertNotNull(travel);
        System.out.println(travel);
    }

    @Test
    void insert() {
        TravelVO travel = TravelVO.builder()
                .district("수도권")
                .title("해너미 명소")
                .description("해너미 명소로 유명해요")
                .address("인천 광역시 서해바다")
                .phone("111-222-3333")
                .build();

        dao.insert(travel);
        System.out.println(travel);
    }
}
