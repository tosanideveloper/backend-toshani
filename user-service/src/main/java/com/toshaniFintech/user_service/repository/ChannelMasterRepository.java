package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ChannelMasterEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChannelMasterRepository extends JpaRepository<ChannelMasterEntity, Long> {

    Optional<ChannelMasterEntity> findByChannelUuid(String channelUuid);

    @Query("""
        SELECT c FROM ChannelMasterEntity c
        JOIN c.clientMaster cm
        JOIN c.partnerMaster pm
        WHERE (:channelStatus IS NULL OR cm.channelStatus = :channelStatus)
        AND (:channelName IS NULL OR LOWER(c.channelName) LIKE LOWER(CONCAT('%', :channelName, '%')))
        AND (
            :search IS NULL OR :search = '' OR
            (:searchByField = 'channelName' AND LOWER(c.channelName) LIKE LOWER(CONCAT('%', :search, '%')))
        )
    """)
    Page<ChannelMasterEntity> fetchChannels(
            @Param("channelName") String channelName,
            @Param("channelStatus") String channelStatus,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
