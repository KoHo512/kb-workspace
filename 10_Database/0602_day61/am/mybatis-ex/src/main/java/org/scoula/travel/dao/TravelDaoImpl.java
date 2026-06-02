package org.scoula.travel.dao;

import org.apache.ibatis.session.SqlSession;
import org.scoula.database.MyBatisConfig;
import org.scoula.travel.domain.TravelVO;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class TravelDaoImpl implements TravelDao {
    static final String NAMESPACE = "org.scoula.travel.dao.TravelDao.";

    @Override
    public int getTotalCount() {
        return MyBatisConfig.getSqlSession()
                .selectOne(NAMESPACE + "getTotalCount");
    }

    @Override
    public List<TravelVO> getTravels(int page, int size) {
        int start = (page - 1) * size;
        Map map = Map.of("start", start, "size", size);
        return MyBatisConfig.getSqlSession()
                .selectList(NAMESPACE + "getTravels", map);

    }

    @Override
    public List<String> getDistricts() {
        return MyBatisConfig.getSqlSession()
                .selectList(NAMESPACE + "getDistricts");
    }

    @Override
    public List<TravelVO> getTravelsByDistrict(String district) {
        return MyBatisConfig.getSqlSession()
                .selectList(NAMESPACE + "getTravelsByDistrict", district);
    }

    @Override
    public Optional<TravelVO> getTravel(Long no) {
        TravelVO travel = MyBatisConfig.getSqlSession()
                .selectOne(NAMESPACE + "getTravel", no);

        return Optional.ofNullable(travel);
    }

    private void transaction(Consumer<SqlSession> action) {
        try (SqlSession session = MyBatisConfig.getSqlSession()) {
            action.accept(session);
            session.commit();
        }
    }

    @Override
    public void insert(TravelVO travel) {
        transaction(session -> session.insert(NAMESPACE + "insert", travel));
    }

    @Override
    public void update(TravelVO travel) {
        transaction(session -> session.update(NAMESPACE + "update", travel));
    }

    @Override
    public void remove(Long no) {
        transaction(session -> session.delete(NAMESPACE + "remove", no));
    }
}
