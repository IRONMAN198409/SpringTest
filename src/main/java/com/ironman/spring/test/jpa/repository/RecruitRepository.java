package com.ironman.spring.test.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ironman.spring.test.jpa.domain.Recruit;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	// 1. 별도로 만들 필요 없음
	
	// 2. company id로 회사 공고 조회
	public List<Recruit> findByCompanyId(int companyId);
	
	// 3. 복합조건
	// position : 웹 back-end 개발자이고, type : 정규직
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// 4. 복합조건
	// 정규직이거나 연봉 9000이상인 공고 조회
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 5. 정렬 제한 조건
	// 계약직 목록을 연봉 기준으로 내림차순 3개만 조회
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 6. 범위 조회
	// '성남시 분당구'가 지역이고, 연봉 7000이상 ~ 8500이하인 공고 조회
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	// 7. Native query
	// 마감일이 2026-04-10 이후, 연봉이 8100이상인 '정규직' 공고, 연봉 내림차순 조회
	@Query(value="SELECT * FROM `job_posting` WHERE `deadline` > :deadline AND `salary` >= :salary AND `type` = :type ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> findByNative(@Param("deadline") String deadline, @Param("salary") int salary, @Param("type") String type);
	
	@Query(value="SELECT * FROM `job_posting` "
				+ "WHERE `deadline` >= :deadline"
			    + " AND `salary` >= :salary"
				+ " AND `type` = :type"
			    + " ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> findNativeQuery(
			@Param("deadline") String deadline
			, @Param("salary") int salary
			, @Param("type") String type);
}
