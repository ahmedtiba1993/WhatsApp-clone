package com.tiba.whatsapp_api.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, String> {

    @Query("SELECT DISTINCT c FROM Chat c WHERE c.sender.id = :senderId OR c.recipient.id = :senderId ORDER BY c.createdDate DESC")
    List<Chat> findChatBySenderId(@Param("senderId") String senderId);

    @Query("SELECT DISTINCT c FROM Chat c WHERE (c.sender.id = :senderId AND c.recipient.id = :recipientId) OR (c.sender.id = :recipientId AND c.recipient.id = :senderId) ORDER BY c.createdDate DESC")
    List<Chat> findChatBySenderIdAndRecipient(@Param("senderId") String senderId, @Param("recipientId") String recipientId);
}
