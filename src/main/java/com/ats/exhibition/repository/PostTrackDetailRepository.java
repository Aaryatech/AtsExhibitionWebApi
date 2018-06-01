package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.exhibition.model.PostTrackDetail;

public interface PostTrackDetailRepository extends JpaRepository<PostTrackDetail, Integer>{

	List<PostTrackDetail> findByTrackIdAndIsUsed(int trackId, int i);

}
