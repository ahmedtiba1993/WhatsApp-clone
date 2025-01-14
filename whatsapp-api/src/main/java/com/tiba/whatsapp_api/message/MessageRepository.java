package com.tiba.whatsapp_api.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.chat.id = :chatId ORDER BY m.createdDate")
    List<Message> findMessagesByChatId(@Param("chatId") Long chatId);

    @Transactional
    @Modifying
    @Query("UPDATE Message m SET m.state = :newState WHERE m.chat.id = :chatId")
    void setMessagesToSeenByChat(@Param("chatId") Long chatId, @Param("newState") MessageState newState);
}