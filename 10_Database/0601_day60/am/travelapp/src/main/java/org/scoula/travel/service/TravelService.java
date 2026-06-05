package org.scoula.travel.service;

public interface TravelService {
    // 전체 관광지 목록
    void printTravels();

    // 특정 권역 관광지 목록
    void printTravelsByDistrict();

    // 특정 페이지 관광지 목록
    void printTravelsByPage();

    // 관광지 상세보기
    void printTravel();
}
