package org.scoula.travel.dao;

import org.scoula.travel.domain.TravelVO;

import java.util.List;
import java.util.Optional;

public interface TravelDao {

    int getTotalCount();

    // 페이지 별 목록
    List<TravelVO> getTravels(int page, int size);

    // 권역 목록
    List<String> getDistricts();

    // 특정 권역의 목록
    List<TravelVO> getTravelsByDistrict(String district);

    // 특정 관광지 정보
    Optional<TravelVO> getTravel(Long no);

    void insert(TravelVO travel);

    void update(TravelVO travel);

    void remove(Long no);
}
